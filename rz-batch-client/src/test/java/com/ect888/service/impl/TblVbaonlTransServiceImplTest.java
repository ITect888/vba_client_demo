package com.ect888.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TblVbaonlTransServiceImplTest {

	@Autowired
	private TblVbaonlTransServiceImpl service;
	
	@Test
	public void testTrans1() {
		
		String sysSeqNb="111";
		log.info(sysSeqNb+" testTrans1...");
		String t=service.getBySysSeqNb(sysSeqNb);
		log.info(sysSeqNb+" testTrans1="+t);
	}
	
	@Test
	public void testTrans2() {
		String sysSeqNb="19103520190131221646280001";
		log.info(sysSeqNb+" testTrans2...");
		String t=service.getBySysSeqNb(sysSeqNb);
		log.info(sysSeqNb+" testTrans2="+t);
	}
	
}
