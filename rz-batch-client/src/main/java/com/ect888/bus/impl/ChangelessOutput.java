package com.ect888.bus.impl;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * 固定输出，即VBA返回结果
 * 
 * @author fanyj
 *
 */
@Data
public class ChangelessOutput {

	/**
	 * 输出title，即合并单元格中值
	 */
	public static final String TYPE_STR="固定输出";
	
	/**
	 * 输出title，sysseqnb
	 */
	public static final String SYSSEQNB_STR="sysseqnb";
	
	
	/**
	 * 输出title，results
	 */
	public static final String RESULTS_STR="results";
	
	private String sysseqnb;
	private String results;

	/**
	 * 固定输出字段值排列后的列表
	 * 先是sysseqnb再是results
	 * 
	 * @return
	 */
	public List<String> dataList(){
		List<String> r=new ArrayList<String>();
		
		r.add(sysseqnb);
		r.add(results);
		
		return r;
	}
	
	/**
	 * 固定输出字段title排列后的列表
	 * 先是sysseqnb再是results
	 */
	public static final List<String> TITLE_LIST;
	static {
		TITLE_LIST=new ArrayList<String>();
		
		TITLE_LIST.add(SYSSEQNB_STR);
		TITLE_LIST.add(RESULTS_STR);
	}
	
	/**
	 * 从发起请求VBA到VBA返回的时间记录
	 */
	private ConsumingTime consumingTime;

}
