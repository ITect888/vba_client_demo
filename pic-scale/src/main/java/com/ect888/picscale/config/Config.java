package com.ect888.picscale.config;

import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * 应用配置
 * 
 * @author fanyj
 *
 */
@Component
@Data
@ConfigurationProperties(prefix = "my-app")
public class Config {
	
	/**
	 * 压缩图片目标大小，单位B
	 */
	private int targetSize;  
	
	/**
	 * 最大尝试次数
	 */
	private int tryTimes; 
	
	/**
	 * 支持的文件后缀列表
	 */
	private Set<String> supportSuffix;

}
