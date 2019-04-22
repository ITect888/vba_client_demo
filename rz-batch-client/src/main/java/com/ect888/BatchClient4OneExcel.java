package com.ect888;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.ect888.bus.Util;
import com.ect888.bus.impl.Writer;
import com.ect888.bus.view.CallBack;
import com.ect888.config.Config;
import com.ect888.controller.Controller;
import com.ect888.controller.impl.ThreadControllerImpl;
import com.ect888.view.excel.ExcelWriter;
import com.ect888.view.excel.impl.Excel2007Reader;
import com.ect888.view.excel.impl.Excel2007Writer;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 处理单个输入文件（单个sheet）并产生单个结果
 * 
 * @author fanyj
 *
 */
@Component
@Slf4j
public class BatchClient4OneExcel {
	
	/**
	 * 启动多线程交易
	 * 
	 * 这些交易线程在本方法内都执行完成了
	 * 
	 * @param controller 多线程控制
	 * @param callBack 解析输入回调接口的实例
	 * @param input 文件入参
	 * @return
	 */
	private Controller control(Controller controller,CallBack callBack, File input) {
		log.info("main control...input="+input.getName());
		
		callBack.setController(controller);
		try {
			reader.process(input,callBack);
		} catch (InvalidOperationException | IOException | OpenXML4JException | SAXException e) {
			log.error("",e);
		}

		log.info("main control completely"+input.getName());
		
		return controller;
	}
	
	@Autowired
	private Excel2007Reader reader;
	

	@Autowired
	private Writer writer;
	
	/**
	 * 
	 * 首先关闭生产者线程池controller，然后单个消费进行消费，写入Excel
	 * 
	 * 
	 * @param fileName
	 * @param outputTitles
	 * @param controller
	 * @param outputFileNamePrefix 输出文件前缀
	 * @param seq 截止到本输出文件发送的笔数(从0开始计数),因为某个输入文件会被多次使用，以满足“发送最少笔数限制”spec-num2-post,故写出的文件需要按照顺序区分命名
	 */
	private void write(String fileName,List<List<String>> outputTitles,Controller controller
			, String outputFileNamePrefix,long seq) {
		
		//必须首先关闭生产者线程池controller，否则死循环，因消费者采取“生产者还在继续生产或者还未消费完历史存量就继续消费”策略，而是否“消费完历史存量”是看controller是否关闭
		controller.shutdown();
		
		//进行消费
		
		String fullFileName=outputFileNamePrefix+Util.SPLIT+seq+fileName;//输出文件的文件名前缀（application.yml的output-file-name-prefix配置）+“-”+截止到本输出文件已读入输入数据的笔数+输入文件名
		
		log.info("main write..."+fullFileName);
		ExcelWriter excelWriter = conExcelWriter();
		
		if(null!=outputTitles)
			outputTitles.stream().forEach(outputTitle->{
				try {
					excelWriter.reset(fullFileName, outputTitle);
				} catch (IOException e) {
					log.error("", e);
				}
			});

		writer.consume(controller, excelWriter,controller.getBlockQueue());

		try {
			excelWriter.writeAndClose();
		} catch (IOException e) {
			log.error("", e);
		}
		log.info("main write completely!");
	}

	@Autowired
    private ApplicationContext applicationContext;
	
	private ExcelWriter conExcelWriter() {
		return applicationContext.getBean(Excel2007Writer.class);
	}
	
	
	@Autowired
	private Config config;
	
	
	/**
	 * 
	 * 读取单个excel文件file，让callBack进行处理，生成单个excel输出
	 * 
	 * 其中涉及的生产者线程池声明周期起与此也在此完结
	 * 消费者也是
	 * 
	 * @param mode
	 * @param file
	 * @param callBack
	 */
	public void doWork(String mode,File file,CallBack callBack) {

		ThreadControllerImpl threadControllerImpl=applicationContext.getBean(ThreadControllerImpl.class);
		
		threadControllerImpl.initThreadPool(config.getNThreads());
		threadControllerImpl.setMode(mode);
		
		try {
			control(threadControllerImpl,callBack,file);
		}catch(RuntimeException e) {
			log.error("运行时异常，可能是入参excel不符合模板，如excel只能有一个合法的sheet,或者必填字段如ptyKey不能为空",e);
		}

		try {
			write(file.getName(),callBack.getOutPutTitle(),threadControllerImpl,config.getOutputFileNamePrefix(),Util.INVOKE_SEQ.get() );
		}catch(RuntimeException e) {
			log.error("写入Excel运行时异常",e);
		}
	}
	

}
