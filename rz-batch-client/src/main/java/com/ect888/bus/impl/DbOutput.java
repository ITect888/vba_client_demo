package com.ect888.bus.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * 
 * 数据库结果输出
 * 包括：
 * 1 数据库字段结果的json格式
 * 2 时差，单位毫秒：流水更新时间-流水创建时间
 * 3 流水更新时间
 * 4 流水创建时间
 * 
 * @author fanyj
 *
 */
@Data
public class DbOutput {

	/**
	 * 输出title，数据库字段结果的json格式
	 */
	public static final String DB_RESULTS_STR="数据库字段结果的json格式";
	
	/**
	 * 输出title，数据库开始时间
	 */
	public static final String DB_CRE_TM_STR="数据库开始时间";
	
	/**
	 * 输出title，数据库结束时间
	 */
	public static final String DB_UPDATE_TM_STR="数据库结束时间";
	
	/**
	 * 输出title，数据库流水时差（毫秒）
	 */
	public static final String DB_TIME_DIFF_STR="数据库流水时差（毫秒）";
	
	/**
	 * 数据库字段结果的json格式
	 */
	private String dbJsonResult;
	
    /**
     * 流水创建时间
     */
    private LocalDateTime cretm;

    /**
     * 流水更新时间
     */
    private LocalDateTime updatetm;
    
    /**
     * 时差，单位毫秒：流水更新时间-流水创建时间
     */
    private long timeDiffMills;

	/**
	 * 固定输出字段值排列后的列表
	 * 依次为
	 * 1 所有字段结果的json格式
	 * 2 时差，单位毫秒：流水更新时间-流水创建时间
	 * 3 流水更新时间
	 * 4 流水创建时间
	 * 
	 * @return
	 */
	public List<String> dataList(){
		List<String> r=new ArrayList<String>();
		r.add(dbJsonResult);
		r.add(timeDiffMills+"");
		String updatetmStr="";
		if(null!=updatetm) {
			updatetmStr=updatetm.toString();
		}
		r.add(updatetmStr);
		String cretmStr="";
		if(null!=cretm) {
			cretmStr=cretm.toString();
		}
		r.add(cretmStr);
		return r;
	}
	
	/**
	 * 数据库结果输出字段title排列后的列表
	 * 只有db_results
	 */
	public static final List<String> TITLE_LIST;
	static {
		TITLE_LIST=new ArrayList<String>();
		TITLE_LIST.add(DB_RESULTS_STR);
		TITLE_LIST.add(DB_TIME_DIFF_STR);
		TITLE_LIST.add(DB_UPDATE_TM_STR);
		TITLE_LIST.add(DB_CRE_TM_STR);
	}
	
	

}
