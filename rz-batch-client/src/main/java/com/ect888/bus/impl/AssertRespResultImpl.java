package com.ect888.bus.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ect888.bus.AssertRespResult;
import com.ect888.bus.AssertUtil;
import com.ect888.bus.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AssertRespResultImpl implements AssertRespResult {
	
	@Autowired
	private AssertUtil compare;

	@Override
	public Map<String,String> produceAssertResult(Map<String, String> expectedRespMap, ChangelessOutput resp) {

		Map<String,String> reMap=new HashMap<String,String>();
		
		if(null==resp||null==expectedRespMap) {
			return reMap;
		}
		
		String respStr=resp.getResults();
		
		if(null==respStr) {
			return reMap;
		}
		
		JSONObject common=JSON.parseObject(respStr);//外层
		JSONArray arr=common.getJSONArray("results");//里层
		
		expectedRespMap.forEach((inTitleKey,expectedValue)->{
			
			String acKey=inTitleKey.replaceFirst(Util.EXPECTED_HEAD, "");
			
			String actualValue=common.getString(acKey);
			if(null==actualValue) {//外层没有，尝试从里层取
				if(null!=arr&&arr.size()>0) {
					JSONObject dataObj=arr.getJSONObject(0);
					actualValue=dataObj.getString(acKey);
				}
			}
			
			String outTitleKey=inTitleKey.replaceFirst(Util.EXPECTED_HEAD, Util.ASSERTED_HEAD);
			
			String compareResult=compare.compare(expectedValue, actualValue);
			reMap.put(outTitleKey, compareResult);
			
		});
		
		log.debug("reMap="+JSON.toJSONString(reMap));
		
		return reMap;
	}

}
