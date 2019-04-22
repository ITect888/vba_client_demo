package com.ect888.bus;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.ect888.bus.view.CallBack;
import com.ect888.bus.view.impl.InputRowData;

/**
 * @author fanyj
 *
 */
public interface Factory {
	
	public static final String MODE_TEST="自动验证小程序";
	
	public static final String MODE_ORG="机构跑批";
	
	/**
	 * 
	 * 工厂产生工作接口的实例
	 * 
	 * @param mode 模式：机构跑批还是自动验证小程序
	 * @param blockQueue 队列
	 * @param inputRowData 一行输入数据
	 * @return
	 */
	Worker factoryWorker(String mode,BlockingQueue<List<String>> blockQueue,InputRowData inputRowData);
	
	/**
	 * 工厂产生解析输入回调接口的实例
	 * 
	 * @param mode 模式：机构跑批还是自动验证小程序
	 * @return
	 */
	CallBack factoryCallBack(String mode);
}
