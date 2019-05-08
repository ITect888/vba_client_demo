package com.ect888;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.Util;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@ComponentScan(basePackages = { "com.ect888" })
@MapperScan("com.ect888.mapper")
@Slf4j 
public class RzBatchClientApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(RzBatchClientApplication.class, args);
	}
	
	@Autowired
	private PoolClient client;
	
	@Autowired
	private Config config;
	
	@Override
	public void run(String... args) throws Exception {
		
		String mode=config.getMode();
		
		if(null!=mode) {
			mode=mode.trim();
		}
		
		long specNum2Post=config.getSpecNum2Post();//指定发送笔数，大于0有效，小于等于0则只发送excel已有数据的量

		log.info("start process...config="+JSON.toJSONString(config));
		
		int batchId=0;//批次序列号
		try {
			do{
				log.info("第"+batchId+"批次...");
				doWork(mode);
				batchId++;
			}while(specNum2Post>Util.INVOKE_SEQ.get());//lowLimit>Util.INVOKE_SEQ.get()其中后者大于等于0，故前者大于0有效，小于等于0则只发送excel已有数据的量
		}finally {
			//应用结束，关闭长连接及其连接池
			client.destroy();
			client.getConnManager().destroy();
		}
		
		log.info("end!");
	}
	
	/**
	 * 
	 * 读取目录下所有excel输入，进行处理
	 * 
	 * @param mode
	 */
	private void doWork(String mode) {
		File file=new File(config.getInput());
		
		File[] fs=null;
		
		if(file.isDirectory()) {
			fs=file.listFiles();
		}else {
			List<File> tmp=new ArrayList<>();
			tmp.add(file);
			fs=tmp.toArray(new File[0]);
		}
		
		for(File f:fs) {
			long seqNum = Util.INVOKE_SEQ.get();
			long specNum2Post=config.getSpecNum2Post();//指定发送笔数，大于0有效，小于等于0则只发送excel已有数据的量
			if(specNum2Post>0&&seqNum>specNum2Post) {
				log.warn("超过指定笔数"+specNum2Post+"不再发送.当前seqNum="+seqNum);
				return;
			}
			
			try {
				batchClient4OneExcel.doWork(mode,f);
			}catch(Exception e) {
				log.info("文件处理失败"+f.getAbsolutePath(),e);
			}
		}
	}
	
	@Autowired
	private BatchClient4OneExcel batchClient4OneExcel;


}

