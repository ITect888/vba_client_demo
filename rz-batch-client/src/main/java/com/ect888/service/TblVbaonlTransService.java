package com.ect888.service;

public interface TblVbaonlTransService {
	/**
	 * 
	 * 通过流水号，查出流水全部字段的json表示
	 * 
	 * @param sysSeqNb
	 * @return
	 */
	String getBySysSeqNb(String sysSeqNb);
}
