package com.ect888.bus.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.Customer;
import com.ect888.controller.Controller;
import com.ect888.view.excel.ExcelWriter;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 消费者，消费请求的结果写入Excel
 * 
 * @author fanyj
 *
 */
@Slf4j
@Component
public class Writer implements Customer {

	@Override
	public boolean consume(CompletableFuture<Void> thread2,Controller controller,ExcelWriter excelWriter,BlockingQueue<List<String>> blockQueue) {
		if(null==controller){
			log.error("null==controller");
			return false;
		}	
		
		if (null == excelWriter) {
			log.error("null==excelWriter");
			return false;
		}
		log.info("cosume...");
		
		// 生产者还在继续生产(1 还在提交线程池 2 线程池还有未执行完毕的 )或者还未消费完历史存量就继续消费
		while (!thread2.isDone()||!controller.isTerminated()||!blockQueue.isEmpty()) {
			doOneByOne(excelWriter,blockQueue);
		}
		log.info("cosume completely!");
		return true;
	}

	/**
	 * 从队列中移除并处理
	 * 
	 * @param blockQueue
	 */
	private void doOneByOne(ExcelWriter excelWriter,BlockingQueue<List<String>> blockQueue) {
		// write it one by one

		List<String> dataCol=null;
		try {
//			log.info("blockQueue.take()...");
//			dataCol = blockQueue.take();//一直阻塞
//			log.info("blockQueue.take() done");
//			log.info("to dataCol =blockQueue.poll(200,TimeUnit.MILLISECONDS)...");
			dataCol =blockQueue.poll(200,TimeUnit.MILLISECONDS);
//			log.info("done dataCol =blockQueue.poll(200,TimeUnit.MILLISECONDS) ,dataCol="+dataCol);
		} catch (InterruptedException e) {
			log.warn("",e);
		}

		if(null==dataCol) {
			return;
		}
		
		try {
//			log.info("add one to excel...dataCol="+JSON.toJSONString(dataCol));
			excelWriter.addRow(dataCol);
//			log.info("add one to excel completely dataCol="+JSON.toJSONString(dataCol));
		} catch (IOException e) {
			log.error("", e);
		}

	}

}
