package com.ect888.bus;

import java.util.Map;

import com.ect888.bus.impl.DbOutput;

/**
 * 
 * 根据数据库记录值产生断言结果
 * 
 * @author fanyj
 *
 */
public interface AssertDbResult {
	/**
	 * 
	 * 根据数据库记录值产生断言结果
	 * 
	 * 期望值是正则表达式 
	 * 
	 * 结果有如下形式：
	 *1 true 代表有期望值也有返回值，满足正则表达式
	 *2 false|expected|actual 代表有期望值也有返回值，但不满足正则表达式
	 *3 noExpected|actual   代表有期望列，但无值
	 *4 NULL|expected 代表有期望值，但实际结果为空
	 *5 Exception.getMessage()|expected|actual 因为入参正则表达式有误，导致无法比较
	 * 
	 * @param expectedDbMap 字段名到字段值的映射，对数据库记录值的期望值入参（期望值是正则表达式 ）,db_expected_开头
	 * @param db 数据库记录值，json格式
	 * @return
	 */
	Map<String,String> produceAssertResult(Map<String,String> expectedDbMap,DbOutput db);
}
