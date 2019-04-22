package com.ect888.bus;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 
 * 常量
 * 
 * @author fanyj
 *
 */
public interface Util {
	/**
	 * 流水序列号 
	 */
	public static final AtomicLong INVOKE_SEQ = new AtomicLong(0);
	
	/**
	 * 主键的间隔
	 */
	public static final String SPLIT = "-";
	
	/**
	 * 断言结果为false或NULL时，追加信息的间隔
	 * 如
	 * false|expected|actual

	 */
	public static final String ASSERTED_SPLIT = "|";
	
	/**
	 * VBA返回报文的期望值字段开头
	 */
	public static final String EXPECTED_HEAD="expected_";
	
	public static final String ASSERTED_HEAD="assert_";
	
	public static final String DB_ASSERTED_HEAD="db_assert_";
	
	/**
	 * 数据库记录值的期望值字段开头
	 */
	public static final String DB_EXPECTED_HEAD="db_expected_";
	
	public static final String FUNC_NO_STR="funcNo";
	
	/**
	 * 
	 */
	public static final String TO_SIGN_PTY_CD="toSign_ptycd";
	
	/**
	 * 
	 */
	public static final String TO_SIGN_PTY_ACCT="toSign_ptyacct";
	
	/**
	 * 数据库结果json中cretm字段名
	 */
	public static final String DB_CRETM_STR="cretm";
	
	/**
	 *  数据库结果json中updatetm字段名
	 */
	public static final String DB_UPDATETM_STR="updatetm";
	
	public static final String EXPECTED_STR="期望值入参";
	
	public static final String PARAMS_STR="业务请求入参";
	
	public static final String CASE_DESC_STR="案例说明";
	
	public static final String PTY_KEY_STR="会话秘钥";
	
	public static final String IS_ONE_PLUS_N_STR="是否调用N次102结果查询";
}
