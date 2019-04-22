package com.ect888.bus;

import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * 
 * 工作接口
 * 包括线程化，输出生产者
 * 
 * @author fanyj
 *
 */
public interface Worker extends Runnable{
	
	/**
	 * 
	 * 向结果队列blockQueue中添加数据
	 * 
	 * @param result
	 * @return
	 */
	boolean produce(List<String> result);
	
	/**
	 * 
	 * 设置队列
	 * 
	 * @param blockQueue
	 */
	void setBlockingQueue(BlockingQueue<List<String>> blockQueue);

	/**
	 * 设置流水序列号
	 * 
	 * @param seq
	 */
	void setSeq(String seq);
}
