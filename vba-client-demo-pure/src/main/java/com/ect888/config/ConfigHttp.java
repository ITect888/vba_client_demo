package com.ect888.config;

/**
 * 
 * http长连接的配置
 * 
 * @author fanyj
 *
 */
public class ConfigHttp {
	
	private ConfigHttp() {
		
	}
	
	private static class Holder{
		public static final ConfigHttp instance=new ConfigHttp();
	}
	
	public static ConfigHttp getInstance() {
		return Holder.instance;
	}
	
	/**
	 * 最大线程数
	 */
	private int maxTotal=250;
	
	/**
	 * 每个网络路由的最大数
	 */
	private int defaultMaxPerRoute=200;
	
	/**
	 * 尝试关闭空闲网络连接的时间间隔，单位秒
	 */
	private int closeIdleConnections=30;
	
	/**
	 * 是否启动代理
	 */
	private boolean proxy=false;

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

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getDefaultMaxPerRoute() {
		return defaultMaxPerRoute;
	}

	public void setDefaultMaxPerRoute(int defaultMaxPerRoute) {
		this.defaultMaxPerRoute = defaultMaxPerRoute;
	}

	public int getCloseIdleConnections() {
		return closeIdleConnections;
	}

	public void setCloseIdleConnections(int closeIdleConnections) {
		this.closeIdleConnections = closeIdleConnections;
	}

	public boolean isProxy() {
		return proxy;
	}

	public void setProxy(boolean proxy) {
		this.proxy = proxy;
	}

	public String getSquidIp() {
		return squidIp;
	}

	public void setSquidIp(String squidIp) {
		this.squidIp = squidIp;
	}

	public int getSquidPort() {
		return squidPort;
	}

	public void setSquidPort(int squidPort) {
		this.squidPort = squidPort;
	}

	public long getKeepAliveDefault() {
		return keepAliveDefault;
	}

	public void setKeepAliveDefault(long keepAliveDefault) {
		this.keepAliveDefault = keepAliveDefault;
	}
	
}
