package com.ect888.bus.view.impl;

import java.util.List;
import java.util.Map;

import lombok.Data;

/**
 * 
 * 输入中数据行的逐行处理结果
 * 
 * 包括：
 * 字段名到字段值的映射，案例说明
 * 字段名到字段值的映射，会话秘钥
 * 字段名到字段值的映射，业务请求入参
 * 字段名到字段值的映射，期望值入参
 * 
 * 还有输出title和列号一一对应关系映射数组，其中数组下标为列号，数组值为输出title
 * 
 * @author fanyj
 *
 */
@Data
public class InputRowData {
	/**
	 * 字段名到字段值的映射，案例说明
	 * 包括title
	 * 是否调用N次102结果查询
	 */
	private Map<String,String> caseDes;
	/**
	 * 会话秘钥值
	 */
	private String ptyKey;
	/**
	 * 字段名到字段值的映射，业务请求入参
	 */
	private Map<String,String> params;
	/**
	 * 字段名到字段值的映射，期望值入参
	 */
	private Map<String,String> expected;
	
	/**
	 * 输出title和列号一一对应关系映射数组，数组下标为列号，数组值为输出title
	 */
	private List<String> outPutTitle;
}
