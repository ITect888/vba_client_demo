package com.ect888.bus.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ect888.bus.AssertDbResult;
import com.ect888.bus.AssertUtil;
import com.ect888.bus.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AssertDbResultImpl implements AssertDbResult {
	
	@Autowired
	private AssertUtil compare;
	
	@Override
	public Map<String, String> produceAssertResult(Map<String, String> expectedDbMap, DbOutput db) {
		Map<String,String> reMap=new HashMap<String,String>();
		
		if(null==db||null==expectedDbMap) {
			return reMap;
		}
		
		String dbJsonStr=db.getDbJsonResult();
		
		if(null==dbJsonStr) {
			return reMap;
		}
		
		JSONObject common=JSON.parseObject(dbJsonStr);//外层
		
		expectedDbMap.forEach((inTitleKey,expectedValue)->{
			
			String acKey=inTitleKey.replaceFirst(Util.DB_EXPECTED_HEAD, "");
			
			String actualValue=common.getString(acKey);
			
			String outTitleKey=inTitleKey.replaceFirst(Util.DB_EXPECTED_HEAD, Util.DB_ASSERTED_HEAD);
			
			String compareResult=compare.compare(expectedValue, actualValue);
			reMap.put(outTitleKey, compareResult);
			
		});
		
		log.debug("reMap="+JSON.toJSONString(reMap));
		
		return reMap;
	}
	

}
