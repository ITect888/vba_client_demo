package com.ect888.bus;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 断言的通用处理：
 * 
 * 
 * @author fanyj
 *
 */
@Component
@Slf4j
public class AssertUtil {

	/**
	 * 
	 * 比较得到结果，结果有如下形式：
	 *1 true 代表有期望值也有返回值，满足正则表达式
	 *2 false|expected|actual 代表有期望值也有返回值，但不满足正则表达式
	 *3 noExpected|actual   代表有期望列，但无值
	 *4 NULL|expected 代表有期望值，但实际结果为空
	 *5 Exception.getMessage()|expected|actual 因为入参正则表达式有误，导致无法比较
	 * 
	 * 
	 * @param expectedValue 期望值
	 * @param actualValue 实际值
	 * @return 结果，如下形式：
	 *1 true 代表有期望值也有返回值，满足正则表达式
	 *2 false|expected|actual 代表有期望值也有返回值，但不满足正则表达式
	 *3 noExpected|actual   代表有期望列，但无值
	 *4 NULL|expected 代表有期望值，但实际结果为空
	 *5 Exception.getMessage()|expected|actual 因为入参正则表达式有误，导致无法比较
	 * 
	 */
	public String compare(String expectedValue,String actualValue) {
		if(null==expectedValue) {
			return "noExpected"+Util.ASSERTED_SPLIT+actualValue;
		}
		
		if(null==actualValue) {
			return "NULL"+Util.ASSERTED_SPLIT+expectedValue;
		}
		
		boolean r=false;
		
		try {
			r=actualValue.matches(expectedValue);//满足期望值正在表达式就认为正确
		}catch(Exception e){
			String msg=Util.ASSERTED_SPLIT+expectedValue+Util.ASSERTED_SPLIT+actualValue;
			log.error(msg,e);
			return e.getMessage()+msg;
		}
		
		if(r){//满足期望值正在表达式就认为正确
			return "true";
		}
		
		return "false"+Util.ASSERTED_SPLIT+expectedValue+Util.ASSERTED_SPLIT+actualValue;
	}
	
}
