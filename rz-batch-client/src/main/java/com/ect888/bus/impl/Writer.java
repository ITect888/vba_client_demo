package com.ect888.bus.impl;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.springframework.stereotype.Component;

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
	public boolean consume(Controller controller,ExcelWriter excelWriter,BlockingQueue<List<String>> blockQueue) {
		if(null==controller){
			log.error("null==controller");
			return false;
		}	
		
		if (null == excelWriter) {
			log.error("null==excelWriter");
			return false;
		}
		log.info("cosume...");
		
		// 生产者还在继续生产或者还未消费完历史存量就继续消费
		while (!controller.isTerminated()||!blockQueue.isEmpty()) {
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
			dataCol = blockQueue.take();//一直阻塞
		} catch (InterruptedException e) {
			log.warn("",e);
		}

		try {
			log.info("add one to excel...");
			excelWriter.addRow(dataCol);
			log.info("add one to excel completely");
		} catch (IOException e) {
			log.error("", e);
		}

	}

}
