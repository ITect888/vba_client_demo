package com.ect888.controller.impl;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ect888.bus.Util;
import com.ect888.bus.Worker;
import com.ect888.bus.impl.FactoryImpl;
import com.ect888.bus.view.impl.InputRowData;
import com.ect888.config.Config;
import com.ect888.controller.Controller;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 线程池方式控制的实现
 * 
 * 原型模式
 * 
 * @author fanyj
 *
 */
@Scope("prototype")
@Slf4j
@Component
public class ThreadControllerImpl implements Controller {
	
	/**
	 * 执行线程池
	 */
	private ExecutorService invokeThreadPool;
	
	public static final int DEF_NTHREADS = 10;
	
	public void initThreadPool(int nThreads) {
		invokeThreadPool = Executors.newFixedThreadPool(nThreads);
	}
	
	private String mode;
	
	private BlockingQueue<List<String>> blockQueue;
	
	public ThreadControllerImpl() {
		blockQueue=new LinkedBlockingQueue<>();
	}
	
	@Override
	public BlockingQueue<List<String>> getBlockQueue() {
		return blockQueue;
	}
	
	@Autowired
	private FactoryImpl factory;
	
	@Autowired
	private Config config;
	
	@Override
	public boolean invoke(InputRowData inputRowData) {

		long seqNum = Util.INVOKE_SEQ.addAndGet(1);
		long specNum2Post=config.getSpecNum2Post();//指定发送笔数，大于0有效，小于等于0则只发送excel已有数据的量
		if(specNum2Post>0&&seqNum>specNum2Post) {
			log.warn("超过指定笔数"+specNum2Post+"不再发送.当前seqNum="+seqNum);
			return false;
		}
		
		Worker worker=factory.factoryWorker(mode, blockQueue, inputRowData);
		String seq = seqNum + Util.SPLIT;
		log.info(seq+" add to submit inputRowData="+inputRowData);
		worker.setSeq(seq);
		invokeThreadPool.submit(worker);
		
		return true;
	}

	@Override
	public void shutdown() {
		invokeThreadPool.shutdown();
	}

	@Override
	public boolean isTerminated() {
		return invokeThreadPool.isTerminated();
	}

	@Override
	public void setMode(String mode) {
		this.mode=mode;		
	}

}
