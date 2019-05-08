package com.ect888.bus.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ect888.bus.OrgUtil;
import com.ect888.bus.Worker;
import com.ect888.bus.view.impl.InputRowData;
import com.ect888.config.TitleTransConfig;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 独立线程发起外部调用。
 * 
 * 针对机构跑批
 * 
 * 根据入参发起请求，得到结果，拼装输出
 * 
 * @author fanyj
 *
 */
@Slf4j
@Component
@Scope("prototype")
@Setter
public class WorkerImpl4Org implements Worker{

	private BlockingQueue<List<String>> blockingQueue;

	private InputRowData inputRowData;
	
	@Override
	public boolean produce(List<String> result) {
		boolean flag=false;
		try {
			do {
				log.info("to blockingQueue.offer(inputRowData,200,TimeUnit.MILLISECONDS) ");
				flag = blockingQueue.offer(result,200,TimeUnit.MILLISECONDS);
				log.info("done blockingQueue.offer(inputRowData,200,TimeUnit.MILLISECONDS) flag="+flag);
			}while(!flag);
		} catch (InterruptedException e) {
			log.error("",e);
		}
		return true;
	}

	@Override
	public void setBlockingQueue(BlockingQueue<List<String>> blockQueue) {
		this.blockingQueue=blockQueue;
	}
	
	private String seq;
	
	@Override
	public void run() {
		
		try {
			doWork(seq);
		}catch(RuntimeException e) {
			log.error(seq+"处理出现运行时错误",e);
		}

	}
	
	@Autowired
	private FunctionCommonOnePlusNImpl functionCommonOnePlusNImpl;
	
	@Autowired
	private TitleTransConfig titleTransConfig;
	
	private void doWork(String seq) {
		log.info(seq+" worker start...," + inputRowData);

		ChangelessOutput resp= null;
		
		boolean onePlusN=titleTransConfig.isOnePlusN();
		
		log.info(seq+"是否调用N次102结果查询onePlusN为"+onePlusN);
		
		if(!onePlusN) {
			resp=functionCommonImpl.invoke(inputRowData.getPtyKey(),inputRowData.getParams());
		}else {
			resp=functionCommonOnePlusNImpl.invoke(inputRowData.getPtyKey(),inputRowData.getParams());
		}
		
		List<String> result=produceResult(resp, inputRowData.getParams());
		
		produce(result);

		log.info(seq+" worker completed,"+ inputRowData);
		
	}

	/**
	 * 
	 * 从返回报文中提取配置文件中指定提取的输出
	 * 若没有则空字符串占位
	 * 
	 * 长度必然为orgUtil.getField2chiMap().size()
	 * 
	 * @param resp
	 * @return
	 */
	private List<String> extract(String resp) {
		List<String> result=new ArrayList<String>();
		if(null==resp) {
			IntStream.range(0, orgUtil.getField2chiMap().size()).forEach(d->{
				result.add("");
			});
			
			return result;
		}
		
		JSONObject common=JSON.parseObject(resp);//外层
		JSONArray arr=common.getJSONArray("results");//里层
		
		//若没有则空字符串占位
		orgUtil.getField2chiMap().forEach((f,c)->{
			String v=extractOne(f, common,arr);
			result.add(v);
		});
		
		return result;
	}
	
	/**
	 * 根据字段名f从json中提取出值
	 * 值为null则返回空字符串
	 * 否则进一步根据数据字典转换
	 * 
	 * @param f 字段名
	 * @param common
	 * @return
	 */
	private String extractOne(String f,JSONObject common,JSONArray arr) {
		String v=common.getString(f);
		if(null==v) {
			//外层没有，尝试从里层取
			if(null!=arr&&arr.size()>0) {
				JSONObject dataObj=arr.getJSONObject(0);
				v=dataObj.getString(f);
			}
		}
		
		if(null==v)
			return "";
		
		if(orgUtil.getField2value2chiMap().containsKey(f)) {//需要数据字典转换
			v=orgUtil.getField2value2chiMap().get(f).get(v);//数据字典转换
		}
		
		if(null==v)
			return "";
		
		return v;
	}
	
	/**
	 * 
	 * 输出数据和输出title对应排列
	 * 按照title种类顺序排列：
	 * 指定提取的输出（由application.yml resp-extract.field2chi-list配置）  固定输出（sysseqnb	results） 输入中文title	
	 * 
	 * @param resp 固定输出，即VBA响应结果
	 * @param params 业务请求入参
	 * @return 输出数据和输出title对应排列后的结果数据
	 */
	private List<String> produceResult(ChangelessOutput resp,Map<String,String> params) {
		
		List<String> result=new ArrayList<String>();
		
		/**
		 * 输出title和行号一一对应关系
		 */
		List<String> outPutTitle=inputRowData.getOutPutTitle();
		
		int start=0;
		
		//指定提取的输出（由application.yml resp-extract.field2chi-list配置）
		if(null!=resp) {
			List<String> specList=extract(resp.getResults());
			result.addAll(specList);
		}else {
			//占位
			IntStream.range(start,start+orgUtil.getField2chiMap().size()).forEach(i->{
				result.add("");				
			});;
		}
		start=start+orgUtil.getField2chiMap().size();
		
		// 固定输出（sysseqnb	results）
		if(null!=resp) {
			result.addAll(resp.dataList());
		}else {
			//占位
			IntStream.range(start,start+ChangelessOutput.TITLE_LIST.size()).forEach(i->{
				result.add("");				
			});;
		}
		start=start+ChangelessOutput.TITLE_LIST.size();
		
		//输入中文title	
		if(null!=params) {	
			//业务请求入参	
			IntStream.range(start,outPutTitle.size()).forEach(i->{
				String chiKey=outPutTitle.get(i);//输出中文title
				
				String fieldKey=orgUtil.getChi2fieldMap().get(chiKey);//英文字段名
				
				result.add(params.get(fieldKey));
			});
			start=start+outPutTitle.size();
		}
		
		return result;
	}
	
	@Autowired
	private OrgUtil orgUtil;
	
	@Autowired
	private FunctionCommonImpl functionCommonImpl;

}
