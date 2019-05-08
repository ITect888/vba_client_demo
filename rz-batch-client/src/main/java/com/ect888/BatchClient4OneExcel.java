package com.ect888;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.ect888.bus.Util;
import com.ect888.bus.impl.FactoryImpl;
import com.ect888.bus.impl.Writer;
import com.ect888.bus.view.CallBack;
import com.ect888.bus.view.impl.InputRowData;
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
	private void control(Controller controller,CallBack callBack, File input) {
		log.info("main control...input="+input.getName());
		
		callBack.setController(controller);
		try {
			reader.process(input,callBack);
		} catch (InvalidOperationException | IOException | OpenXML4JException | SAXException e) {
			log.error("",e);
		}

		log.info("main control completely"+input.getName());
		
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
	private void write(CompletableFuture<Void> thread2,String fileName,List<List<String>> outputTitles,Controller controller
			, String outputFileNamePrefix,long seq) {
		
		//进行消费
		
		String fullFileName=outputFileNamePrefix+Util.SPLIT+seq+fileName;//输出文件的文件名前缀（application.yml的output-file-name-prefix配置）+“-”+截止到本输出文件已读入输入数据的笔数+输入文件名
		
		log.info("main write..."+fullFileName);
		ExcelWriter excelWriter = conExcelWriter();
		
		if(null==outputTitles||outputTitles.isEmpty()) {
			String msg="null==outputTitles||outputTitles.isEmpty()";
			log.error(msg);
			throw new IllegalArgumentException(msg);
		}
			
			
		outputTitles.stream().forEach(outputTitle->{
			try {
				excelWriter.reset(fullFileName, outputTitle);
			} catch (IOException e) {
				log.error("", e);
			}
		});

		writer.consume(thread2,controller, excelWriter,controller.getBlockQueue());

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
	
	@Autowired
	private FactoryImpl factory;
	

	
	/**
	 * 
	 * 读取单个excel文件file，生成单个excel输出
	 * 
	 * 其中涉及的生产者线程池生命周期起于此也在此完结
	 * 消费者也是
	 * 
	 * @param mode
	 * @param file
	 * @param callBack
	 */
	public void doWork(String mode,File file) {

		ThreadControllerImpl threadControllerImpl=applicationContext.getBean(ThreadControllerImpl.class);
		
		threadControllerImpl.initThreadPool(config.getNThreads());
		threadControllerImpl.setMode(mode);
		
		CallBack callBack=factory.factoryCallBack(mode);
		
		/**
		 * 线程3开启的前提条件是，产生了输出title
		 * 
		 * 故需要等待其他线程完成操作
		 */
		CountDownLatch cd = new CountDownLatch(1);
		
		callBack.setCountDownLatch(cd);
		
		CompletableFuture<Void> thread1=CompletableFuture.runAsync(()->{//线程1，是往队列blockQueue4Excel中读入的生产者		
			try {
				control(threadControllerImpl,callBack,file);
			}catch(Exception e) {
				log.error("运行时异常，可能是入参excel不符合模板，如excel只能有一个合法的sheet,或者必填字段如ptyKey不能为空",e);
			}
			
			log.info("线程1完成");
		});
		
		CompletableFuture<Void> thread2=CompletableFuture.runAsync(()->{//线程2，是往队列blockQueue4Excel中取数的消费者，也是往invokeThreadPool即往blockQueue队列的写入的生产者		
			while(!thread1.isDone()||!threadControllerImpl.getBlockQueue4Excel().isEmpty()) {//线程1没有完成，或者队列中还有值
				InputRowData inputRowData=null;
				try {
//					log.info("to threadControllerImpl.getBlockQueue4Excel().take()...");
//					inputRowData = threadControllerImpl.getBlockQueue4Excel().take();//一直阻塞
//					log.info("threadControllerImpl.getBlockQueue4Excel().take() done");
					
					log.info("to inputRowData =threadControllerImpl.getBlockQueue4Excel().poll(200,TimeUnit.MILLISECONDS)...");
					inputRowData =threadControllerImpl.getBlockQueue4Excel().poll(200,TimeUnit.MILLISECONDS);
					log.info("done inputRowData =threadControllerImpl.getBlockQueue4Excel().poll(200,TimeUnit.MILLISECONDS) ,inputRowData="+inputRowData);
					
					if(null==inputRowData) {
						continue;
					}
					
					threadControllerImpl.summit(inputRowData);
				} catch (InterruptedException e) {
					log.error("",e);
				} catch (RejectedExecutionException e) {//未捕获则线程会跳出终止
					log.error("",e);
				} catch (Exception e) {//未捕获则线程会跳出终止
					log.error("",e);
				}
			}
			
			//线程1完成是线程2完成的先决条件。还有要队列空了	
			log.info("线程2完成");
		});
		
		CompletableFuture<Void> thread3=CompletableFuture.runAsync(()->{//线程3，是往blockQueue队列取数的消费者
			try {
				cd.await();//线程3开启的前提条件是，产生了输出title.故需要等待线程1完成对应操作
				write(thread2,file.getName(),callBack.getOutPutTitle(),threadControllerImpl,config.getOutputFileNamePrefix(),Util.INVOKE_SEQ.get() );
			}catch(Exception e) {
				log.error("写入Excel运行时异常",e);
			}
			
			//线程2完成是线程3完成的先决条件。还有要队列空了，且线程池结束了	
			log.info("线程3完成");
		});
		
		//需要线程1执行完成才shutdown！！！
		log.info("等待线程1执行完成...");
		thread1.join();//阻塞在此
		log.info("线程1执行完成,等待线程2执行完成...");
		thread2.join();
		log.info("线程2执行完成，关闭线程池");
		
		//必须在线程3前关闭生产者线程池controller，否则死循环，因消费者采取“生产者还在继续生产或者还未消费完历史存量就继续消费”策略，而是否“消费完历史存量”是看controller是否关闭
		threadControllerImpl.shutdown();//shutdown只是将线程池的状态设置成SHUTDOWN状态，然后中断所有没有正在执行任务的线程。
		
		log.info("等待线程3执行完成...");
		thread3.join();
		log.info("线程3执行完成");
		log.info(file.getAbsolutePath()+"模式"+mode+"下完成！");
		
	}
	

}
