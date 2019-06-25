package com.ect888.config;

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
	 * 访问地址
	 */
	private String url;  
	
	/**
	 * 固定线程池大小
	 */
	private int nThreads; 
	
	/**
	 * 输入文件或目录
	 */
	private String input;
	/**
	 * 输出文件前缀
	 */
	private String outputFileNamePrefix;

	/**
	 * 机构跑批还是自动验证小程序
	 */
	private String mode;

	/**
	 * 指定发送笔数
	 * 大于0有效，小于等于0则只发送excel已有数据的量
	 */
	private long specNum2Post;

	/**
	 * 指定spec-num2-post笔交易数第一笔和最后一笔的间隔时长，其间的交易时间上均匀分布，spec-num2-post和spec-num2-post-duration大于0有效，单位分钟
	 */
	private long specNum2PostDuration;
}
