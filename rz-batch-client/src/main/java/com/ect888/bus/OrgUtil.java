package com.ect888.bus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.ect888.config.RespExtractConfig;
import com.ect888.config.TitleTransConfig;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 机构跑批模式的通用处理：
 * 
 * 1 中文title到字段英文名映射
 * 
 * 只实例化时初始，后续get但不set，故线程安全
 * 
 * 
 * @author fanyj
 *
 */
@Component
@Getter
@Slf4j
public class OrgUtil {

	/**
	 * 中文title到字段英文名映射
	 */
	private Map<String,String> chi2fieldMap;
	
	/**
	 * 从响应结果中提取的字段及其对应输出中文title
	 */
	private Map<String,String> field2chiMap;
	
	/**
	 * 提取的字段中，字段值需要中文映射的数据字典映射   
	 */
	private Map<String,Map<String,String>> field2value2chiMap;
	
	@Autowired
	public OrgUtil(TitleTransConfig titleTransConfig,RespExtractConfig respExtractConfig){
		pro(titleTransConfig);
	
		pro(respExtractConfig);
	}
	
	private void pro(RespExtractConfig respExtractConfig) {
		//从响应结果中提取的字段及其对应输出中文title
		field2chiMap=new HashMap<>();
		
		respExtractConfig.getField2chiList().forEach(d->{
			field2chiMap.put(d.getField(), d.getChi() );
		});
		
		log.info("field2chiMap="+JSON.toJSONString(field2chiMap));
		
		//提取的字段中，字段值需要中文映射的数据字典映射   
		field2value2chiMap=new HashMap<>();
		respExtractConfig.getField2value2chiList().forEach(d->{
			Map<String,String> v2cMap=new HashMap<>();
			d.getValue2chiList().forEach(v2c->{
				v2cMap.put(v2c.getValue(), v2c.getChi());
			});
			field2value2chiMap.put(d.getField(), v2cMap);
		});
		
		log.info("field2value2chiMap="+JSON.toJSONString(field2value2chiMap));
	}
	
	private void pro(TitleTransConfig titleTransConfig) {
		chi2fieldMap=new HashMap<>();
		
		titleTransConfig.getChi2fieldList().forEach(d->{
			chi2fieldMap.put(d.getChi(), d.getField());
		});
		
		log.info("chi2fieldMap="+JSON.toJSONString(chi2fieldMap));
	}
}
