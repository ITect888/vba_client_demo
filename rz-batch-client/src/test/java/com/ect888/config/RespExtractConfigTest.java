package com.ect888.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RespExtractConfigTest {
	
	@Autowired
	private RespExtractConfig respExtractConfig;
	
	@Test
	public void test() {
		log.info("respExtractConfig="+JSON.toJSONString(respExtractConfig));
	}

}
