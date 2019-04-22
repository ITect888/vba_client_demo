package com.ect888.bus.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * 交易耗时
 * 包括：
 * 1 时差，单位毫秒：收到交易返回结果时间-交易发起时间
 * 2 收到交易返回结果时间 
 * 3 交易发起时间
 * 
 * @author fanyj
 *
 */
@Data
public class ConsumingTime {

	/**
	 * 输出title，交易发起时间
	 */
	public static final String DB_POST_TM_STR="交易发起时间";
	
	/**
	 * 输出title，交易响应时间
	 */
	public static final String DB_RESP_TM_STR="交易响应时间";
	
	/**
	 * 输出title，交易耗时
	 */
	public static final String DB_TIME_DIFF_STR="交易耗时（毫秒）";
	
	
    /**
     * 交易发起时间
     */
    private LocalDateTime posttm;

    /**
     * 收到交易返回结果时间 
     */
    private LocalDateTime resptm;
    
    /**
     * 时差，单位毫秒：收到交易返回结果时间-交易发起时间
     */
    private long timeDiffMills;

	/**
	 * 固定输出字段值排列后的列表
	 * 依次为
	 * 1 时差，单位毫秒：收到交易返回结果时间-交易发起时间
	 * 2 收到交易返回结果时间 
	 * 3 交易发起时间
	 * 
	 * @return
	 */
	public List<String> dataList(){
		List<String> r=new ArrayList<String>();
		r.add(timeDiffMills+"");
		String resptmStr="";
		if(null!=resptm) {
			resptmStr=resptm.toString();
		}
		r.add(resptmStr);
		String posttmStr="";
		if(null!=posttm) {
			posttmStr=posttm.toString();
		}
		r.add(posttmStr);
		return r;
	}
	
	/**
	 * 数据库结果输出字段title排列后的列表
	 * 只有db_results
	 */
	public static final List<String> TITLE_LIST;
	static {
		TITLE_LIST=new ArrayList<String>();
		TITLE_LIST.add(DB_TIME_DIFF_STR);
		TITLE_LIST.add(DB_RESP_TM_STR);
		TITLE_LIST.add(DB_POST_TM_STR);
	}
	
	

}
