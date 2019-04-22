package com.ect888.bus.impl;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ect888.bus.FunctionCommon;

import lombok.extern.slf4j.Slf4j;

/**
 * VBA接口通用调用
 * 调用一次funcNoFirst，然后调用N次102结果查询
 * 
 * @author fanyj
 *
 */
@Slf4j
@Service
public class FunctionCommonOnePlusNImpl  implements FunctionCommon{
	
	@Autowired
	private FunctionCommonImpl functionCommonImpl;
	
	@Override
	public ChangelessOutput invoke(String ptyKey,Map<String,String> params){
		
		String ptyacct=params.get(TO_SIGN_HEAD+"ptyacct");
		if(null==ptyacct)
			ptyacct=params.get(TO_SIGN_HEAD+"ptyAcct");
		if(null==ptyacct)
			ptyacct=params.get("ptyacct");
		if(null==ptyacct)
			ptyacct=params.get("ptyAcct");
		
		if(null==ptyacct) {
			String msg="调用一次funcNoFirst，然后调用N次102结果查询必须输入机构账号,title为ptyacct或ptyAcct";
			log.error(msg);
			throw new IllegalArgumentException(msg);
		}
		
		ChangelessOutput out=null;
		try {
			out=functionCommonImpl.invoke(ptyKey, params);
		
			String reStr=polling(out, ptyKey, ptyacct);
			if(StringUtils.hasText(reStr))
				out.setResults(reStr);
		}finally {
			LocalDateTime resptm=LocalDateTime.now();
			if(null!=out&&null!=out.getConsumingTime()) {
				out.getConsumingTime().setResptm(resptm);
				
				ZoneOffset zoneOffset=OffsetDateTime.now().getOffset();
				long timeDiffMills=out.getConsumingTime().getResptm().toInstant(zoneOffset).toEpochMilli()
						-out.getConsumingTime().getPosttm().toInstant(zoneOffset).toEpochMilli();
				out.getConsumingTime().setTimeDiffMills(timeDiffMills);//时差，单位毫秒：收到交易返回结果时间-交易发起时间
			}
		}
		
		//解析返回数据并处理
		return out;
	}

	private String polling(ChangelessOutput out,String ptyKey,String ptyacct) {
		String result=out.getResults();
		String sysseqnb=out.getSysseqnb();
		if(null==result||!StringUtils.hasText(sysseqnb)) {
			log.error("结果为null或者返回流水号为空"+result);
			return null;
		}
		
		Map<String, String> params=new HashMap<>();
		params.put("funcNo", "2000102");
		params.put(TO_SIGN_HEAD+"sysseqnb", sysseqnb);//发送请求后返回的流水号流水号
		params.put(TO_SIGN_HEAD+"ptyacct", ptyacct);//券商帐号
		params.put(TO_SIGN_HEAD+"timestamp", SPEC_TIME_STR);//时间
		
		String re102=null;
		String status=null;
		
		long[] steps={200,300,500,1000,2000,3000,5000,8000,10000,15000};
		for(long step:steps) {
			
			try {
				Thread.sleep(step);
			} catch (InterruptedException e) {
				log.error("",e);
			}
			log.info("sleep "+steps+" ms to invoke 2000102");
			
			ChangelessOutput out102=functionCommonImpl.invoke(ptyKey, params);
			if(null==out102)
				continue;
			
			re102=out102.getResults();
			if(null==re102)
				continue;
			
			JSONObject common=JSON.parseObject(re102);
			JSONArray arr=common.getJSONArray("results");
			if(null!=arr&&!arr.isEmpty()) {
				status=arr.getJSONObject(0).getString("status");
	    		
		    	if("00".equals(status)||"03".equals(status)){//00成功结束，03异常结束
		    		break;//结束则跳出轮询
		    	}	
			}
	    	
	    	//未结束，则继续轮询
			
		}

		return re102;
	}
	
}
