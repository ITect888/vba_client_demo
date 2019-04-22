package com.ect888.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 
 * http长连接的配置
 * 
 * @author fanyj
 *
 */
@Component
@Data
@ConfigurationProperties(prefix = "my-http")
public class ConfigHttp {
	
	/**
	 * 最大线程数
	 */
	private int maxTotal;
	
	/**
	 * 每个网络路由的最大数
	 */
	private int defaultMaxPerRoute;
	
	/**
	 * 尝试关闭空闲网络连接的时间间隔，单位秒
	 */
	private int closeIdleConnections;
	
	/**
	 * 是否启动代理
	 */
	private boolean proxy;

	/**
	 * 启动代理时的代理IP
	 */
	private String squidIp;
	
	/**
	 * 启动代理时的代理端口
	 */
	private int squidPort;
	
	/**
	 * 对服务端连接的默认keepalive时间，单位秒
	 */
	private long keepAliveDefault;
	
}
