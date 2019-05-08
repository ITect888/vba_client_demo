package com.ect888.bus;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;

import com.ect888.controller.Controller;
import com.ect888.view.excel.ExcelWriter;

/**
 * 消费者
 * 
 * @author fanyj
 *
 */
public interface Customer {
	
	/**
	 * 消费结果队列
	 * 
	 * @param controller
	 * @param excelWriter
	 * @param blockQueue
	 * @return
	 */
	boolean consume(CompletableFuture<Void> thread2,Controller controller,ExcelWriter excelWriter,BlockingQueue<List<String>> blockQueue);
}
