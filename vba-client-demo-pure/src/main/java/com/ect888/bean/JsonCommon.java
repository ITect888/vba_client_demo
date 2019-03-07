package com.ect888.bean;

import java.util.ArrayList;

/**
 * 
 * 一般无业务字段的通用查询结果
 * 对应json
 * 
 * {"error_info":"","dsName":["results"],"results":[],"error_no":"0"}
或
{"error_info":"机构账号或者密码不对","error_no":"-1004"}
 * 
 * 
 * @author fanyj
 *
 */
public class JsonCommon {
	
	/**
	 * 
	 * 最外层，系统级调用返回码
	 * 
	 * 等于0成功，否则代表失败
	 */
	private String error_no;
	
	/**
	 * 失败说明
	 */
	private String error_info;
	
	/**
	 * 预留字段
	 */
	private ArrayList<String> dsName;

	public String getError_no() {
		return error_no;
	}

	public void setError_no(String error_no) {
		this.error_no = error_no;
	}

	public String getError_info() {
		return error_info;
	}

	public void setError_info(String error_info) {
		this.error_info = error_info;
	}

	public ArrayList<String> getDsName() {
		return dsName;
	}

	public void setDsName(ArrayList<String> dsName) {
		this.dsName = dsName;
	}
	
	

}
