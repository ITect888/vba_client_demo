package com.ect888.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.ect888.entity.Tbl_vbaonl_trans_1;
import com.ect888.entity.Tbl_vbaonl_trans_2;
import com.ect888.mapper.Tbl_vbaonl_trans_1Mapper;
import com.ect888.mapper.Tbl_vbaonl_trans_2Mapper;
import com.ect888.service.TblVbaonlTransService;

@Service
public class TblVbaonlTransServiceImpl implements TblVbaonlTransService {
	@Autowired 
	private Tbl_vbaonl_trans_1Mapper tblVbaonlTrans1Mapper;
	
	@Autowired 
	private Tbl_vbaonl_trans_2Mapper tblVbaonlTrans2Mapper;

	@Override
	public String getBySysSeqNb(String sysSeqNb) {
		String json=null;
		
		if(null==sysSeqNb)
			return null;

		Tbl_vbaonl_trans_1 trans1=tblVbaonlTrans1Mapper.selectById(sysSeqNb);
		if(null!=trans1) {
			return JSON.toJSONString(trans1);
		}
		
		Tbl_vbaonl_trans_2 trans2=tblVbaonlTrans2Mapper.selectById(sysSeqNb);
		if(null!=trans2) {
			return JSON.toJSONString(trans2);
		}
		
		return json;
	}
	


}
