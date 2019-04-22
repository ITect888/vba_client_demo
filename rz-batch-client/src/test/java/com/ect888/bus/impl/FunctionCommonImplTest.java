package com.ect888.bus.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FunctionCommonImplTest {
	@Autowired
	private FunctionCommonImpl fun;
	
//	@Autowired
//	private PoolClient client;
	
	@Test
	public void test() {

		
		String ptyKey="vba2ciasacctPtykey";
		Map<String, String> params=new HashMap<>();
		
		params.put("funcNo", "2000251");

		params.put("toSign_ptyacct", "ciasacct");
		params.put("toSign_ptycd", "0000100000");
		params.put("toPicBase64_videopic", "F:\\30K高清案例.jpg");
		params.put("usernm", "范燕军");
		
		params.put("toAes_toUrl_toBase64_certseq", "341227198912173710");
		params.put("toSign_biztyp", "spec_");
		params.put("toSign_biztypdesc", "spec_");
		params.put("toSign_placeid", "spec_");
		
		params.put("toSign_timestamp", "spec_time");
		
		params.put("toSign_sourcechnl", "spec_");
		
		try {
			LongStream.range(0, 6000000000l).forEach((i)->{
				log.info(i+" ...");
				fun.invoke(ptyKey, params);
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					log.error("",e);
				}
				log.info(i+" done");
			});
		}catch(Exception e) {
			log.error("",e);
		}
	}
}
