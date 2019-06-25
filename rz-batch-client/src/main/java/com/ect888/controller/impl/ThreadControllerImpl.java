package com.ect888.controller.impl;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

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
		blockQueue4Excel=new LinkedBlockingQueue<>(nThreads);//yml中参数化
	}
	
	/**
	 * @param inputRowData
	 * @return
	 */
	public boolean summit(InputRowData inputRowData) {
		if(null==inputRowData) {
			return false;
		}
		
		long seqNum = Util.INVOKE_SEQ.addAndGet(1);
		long specNum2Post=config.getSpecNum2Post();//指定发送笔数，大于0有效，小于等于0则只发送excel已有数据的量
		if(specNum2Post>0) {
			if(seqNum>specNum2Post) {
				log.warn("超过指定笔数"+specNum2Post+"不再发送.当前seqNum="+seqNum);
				return false;
			}
			
			if(specNum2Post>0) {
				if(config.getSpecNum2PostDuration()>0) {//指定spec-num2-post笔交易数第一笔和最后一笔的间隔时长，其间的交易时间上均匀分布，spec-num2-post和spec-num2-post-duration大于0有效，单位分钟
					long timeMillSec=(config.getSpecNum2PostDuration()*60000)/specNum2Post;
					log.info("to wait millsecs "+timeMillSec);
					try {
						Thread.sleep(timeMillSec);
					} catch (InterruptedException e) {
						log.error("",e);
					}
					log.info("done for waitting millsecs "+timeMillSec);
				}
			}
		}
		
		Worker worker=factory.factoryWorker(mode, blockQueue, inputRowData);
		String seq = seqNum + Util.SPLIT;
		
		worker.setSeq(seq);
		
		log.info(seq+" add to submit inputRowData="+inputRowData);
		invokeThreadPool.submit(worker);
		log.info(seq+" submited inputRowData="+inputRowData);
		
		return true;
		
	}
	
	private String mode;
	
	/**
	 * 
	 */
	private BlockingQueue<List<String>> blockQueue;
	
	public ThreadControllerImpl() {
		blockQueue=new LinkedBlockingQueue<>();
	}
	
	/**
	 * 缓存待请求的数据，最多nThreads个，满了就等待
	 */
	private BlockingQueue<InputRowData> blockQueue4Excel;
	
	public BlockingQueue<InputRowData> getBlockQueue4Excel() {
		return blockQueue4Excel;
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
		boolean flag=false;
		
		try {
			do {
//				log.info("to blockQueue4Excel.put(inputRowData)... ");
//				blockQueue4Excel.put(inputRowData);//满了就等待,阻塞
//				log.info("done blockQueue4Excel.put(inputRowData)");
				log.info("to blockQueue4Excel.offer(inputRowData,200,TimeUnit.MILLISECONDS) ");
				flag = blockQueue4Excel.offer(inputRowData,200,TimeUnit.MILLISECONDS);
				log.info("done blockQueue4Excel.offer(inputRowData,200,TimeUnit.MILLISECONDS) flag="+flag);
			}while(!flag);
			
		} catch (InterruptedException e) {
			log.error("",e);
			return false;
		}

		return true;
	}

	@Override
	public void shutdown() {
		invokeThreadPool.shutdown();
	}

	@Override
	public boolean isTerminated() {
		return invokeThreadPool.isTerminated()&&blockQueue4Excel.isEmpty();
	}

	@Override
	public void setMode(String mode) {
		this.mode=mode;		
	}

}
