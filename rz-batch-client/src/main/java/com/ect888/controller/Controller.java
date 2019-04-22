package com.ect888.controller;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.ect888.bus.view.impl.InputRowData;

/**
 * 
 * 控制层，调用具体接口获得认证结果，维护结果队列
 * 
 * @author fanyj
 *
 */
public interface Controller {
	/**
	 * 
	 * 调用接口获得认证结果，并将认证结果放入阻塞队列中
	 * 
	 * @param inputRowData
	 * @return
	 */
	boolean invoke(InputRowData inputRowData);
	
	/**
	 * 等待线程池内任务完成后，关闭线程池
	 */
	void shutdown();
	
	/**
	 * 
	 * 线程池是否结束
	 * 
	 * @return
	 */
	boolean isTerminated();

	/**
	 * @return
	 */
	BlockingQueue<List<String>> getBlockQueue();
	
	void setMode(String mode);
	
}
