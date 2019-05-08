package com.ect888.bus.impl;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.ect888.bus.Factory;
import com.ect888.bus.Worker;
import com.ect888.bus.view.CallBack;
import com.ect888.bus.view.impl.CallBack4Org;
import com.ect888.bus.view.impl.CallBack4Test;
import com.ect888.bus.view.impl.InputRowData;

/**
 * 
 * 一行行读取excel，对当前行数据处理的回调的
 * 实例工厂
 * 
 * @author fanyj
 *
 */
@Service
public class FactoryImpl implements Factory{
	

	@Override
	public Worker factoryWorker(String mode,BlockingQueue<List<String>> blockQueue,InputRowData inputRowData) {
		if(MODE_TEST.equals(mode)) {
			return conWorker4Test(mode, blockQueue, inputRowData);
		}
		
		return conWorker4Org(mode, blockQueue, inputRowData);
	}

	@Override
	public CallBack factoryCallBack(String mode) {
		if(MODE_TEST.equals(mode)) {
			return applicationContext.getBean(CallBack4Test.class);//自动验证小程序入参输入读入处理和输出title构建
		}
		return  applicationContext.getBean(CallBack4Org.class);//机构跑批入参输入读入处理和输出title构建
	}
	
	@Autowired
    private ApplicationContext applicationContext;
	
	/**
	 * 
	 * 构建自动验证小程序模式发起请求产生结果工作线程
	 * 
	 * @param mode 模式：机构跑批还是自动验证小程序
	 * @param blockQueue 队列
	 * @param inputRowData 一行输入数据
	 * @return
	 */
	private Worker conWorker4Test(String mode,BlockingQueue<List<String>> blockQueue,InputRowData inputRowData) {
		WorkerImpl4Test worker =applicationContext.getBean(WorkerImpl4Test.class);
		worker.setBlockingQueue(blockQueue);
		worker.setInputRowData(inputRowData);
		return worker;
	}
	
	/**
	 * 
	 * 构建机构跑批模式发起请求产生结果工作线程
	 * 
	 * @param mode 模式：机构跑批还是自动验证小程序
	 * @param blockQueue 队列
	 * @param inputRowData 一行输入数据
	 * @return
	 */
	private Worker conWorker4Org(String mode,BlockingQueue<List<String>> blockQueue,InputRowData inputRowData) {
		WorkerImpl4Org worker =applicationContext.getBean(WorkerImpl4Org.class);
		worker.setBlockingQueue(blockQueue);
		worker.setInputRowData(inputRowData);
		return worker;
	}
}
