package com.ect888.http;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.net.ssl.SSLContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;

import com.ect888.config.ConfigHttp;

/**
 * 
 * http访问的连接池
 * 
 * @author fanyj
 *
 */
public class HttpConnectionManager {
	
	
	private Log log = LogFactory.getLog(HttpConnectionManager.class);
	
	private HttpConnectionManager() {
		
	}
	
	private static class Holder{
		public static final HttpConnectionManager instance=new HttpConnectionManager();
	}
	
	public static HttpConnectionManager getInstance() {
		return Holder.instance;
	}
	
	private ConfigHttp configHttp=ConfigHttp.getInstance();

	PoolingHttpClientConnectionManager cm = null;
    
    ConnectionKeepAliveStrategy myStrategy=null;
    
    DefaultProxyRoutePlanner routePlanner=null;
    
    
    /**
     * 
     * 
     *   The  only  feasible  solution
that  does  not  involve  a  one  thread  per  socket  model  for  idle  connections  is  a  dedicated  monitor
thread  used  to  evict  connections  that  are  considered  expired  due  to  a  long  period  of  inactivity.
The monitor thread can periodically call  ClientConnectionManager#closeExpiredConnections()
method  to  close  all  expired  connections  and  evict  closed  connections  from  the  pool.  It  can  also
optionally call  ClientConnectionManager#closeIdleConnections()  method to close all connections
that have been idle over a given period of time.
     * 
     * @author fanyj
     *
     */
    public static class IdleConnectionMonitorThread extends Thread {
    	private Log log = LogFactory.getLog(IdleConnectionMonitorThread.class);
    	
        private final HttpClientConnectionManager connMgr;
        private volatile boolean shutdown;
        private final int closeIdleConnections;
        
        public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr,int closeIdleConnections) {
            super();
            this.connMgr = connMgr;
            this.closeIdleConnections=closeIdleConnections;
        }
        @Override
        public void run() {
            try {
                while (!shutdown) {
                    synchronized (this) {
                        wait(5000);
                        int secs=closeIdleConnections;
//                        log.info(" evict  connections  that  are  considered  expired  due  to  a  long  period  of  inactivity. idle secends is "+secs);
                        // Close expired connections
                        connMgr.closeExpiredConnections();
                        // Optionally, close connections
                        // that have been idle longer than secs sec
                        if(secs>0)
                        	connMgr.closeIdleConnections(secs, TimeUnit.MILLISECONDS);
                    }
                }
            } catch (InterruptedException ex) {
                // terminate
            	log.error("",ex);
            }
        }
        
        public void shutdown() {
            shutdown = true;
            synchronized (this) {
                notifyAll();
            }
        }
        
    }
    
    /**
     * 初始化
     * 
     * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行,init()方法之前执行。
     * @throws KeyStoreException 
     * @throws NoSuchAlgorithmException 
     * @throws KeyManagementException 
     */
    @PostConstruct
    public void init() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
    	
    	log.info("初始化...maxTotal="+configHttp.getMaxTotal()+",defaultMaxPerRoute="+configHttp.getDefaultMaxPerRoute());
    	
		SSLContext sslContext = SSLContexts.custom()
					.loadTrustMaterial(new TrustStrategy() {//ssl选择相信服务端
						@Override
						public boolean isTrusted(
								X509Certificate[] x509Certificates, String s)
								throws CertificateException {
							return true;
						}
					}).build();
		
        LayeredConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext,
                NoopHostnameVerifier.INSTANCE);// The NO_OP HostnameVerifier essentially turns hostname verification  off
        
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory> create()
                .register("https", sslsf)
                .register("http", new PlainConnectionSocketFactory())
                .build();
        
        cm =new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(configHttp.getMaxTotal());//（一定要注意）httpclient设置的最大连接数绝对不能超过tomcat设置的最大连接数，否则tomcat的连接就会被httpclient连接池一直占用，直到系统挂掉
        cm.setDefaultMaxPerRoute(configHttp.getDefaultMaxPerRoute());//配置最大连接数和最大路由连接数，如果你要连接的url只有一个，两个必须配置成一样，否则只会取最小值。（这是个坑，默认最大连接是20，每个路由最大连接是2）
       
        log.info("初始化连接池完成，ssl选择相信服务端");
        
        initKeepAlive();
        
        initProxy();
        
        log.info("启动监视进程，以回收长时间不活动过期连接，从而释放IP资源");
        idleConMonThread=new IdleConnectionMonitorThread(cm,configHttp.getCloseIdleConnections());
        idleConMonThread.start();
        
        log.info("初始化完毕");
        
    }
    
    private IdleConnectionMonitorThread idleConMonThread;
    
    private void initProxy() {
    	if(configHttp.isProxy()) {
			String ip = configHttp.getSquidIp();
			int port = configHttp.getSquidPort();
	        HttpHost proxy = new HttpHost(ip, port);  
	        routePlanner = new DefaultProxyRoutePlanner(proxy);
	        log.info("初始化代理完成,ip="+ip+",port="+port);
    	}else {
    		log.info("不使用代理");
    	}
    		
    }

    /**
     * The HTTP specification does not specify how long a persistent connection may be and should be kept
alive. Some HTTP servers use a non-standard  Keep-Alive  header to communicate to the client the
period of time in seconds they intend to keep the connection alive on the server side. HttpClient makes
use of this information if available. If the  Keep-Alive  header is not present in the response, HttpClient
assumes the connection can be kept alive indefinitely. However, many HTTP servers in general use
are configured to drop persistent connections after a certain period of inactivity in order to conserve
system resources, quite often without informing the client. In case the default strategy turns out to be
too optimistic, one may want to provide a custom keep-alive strategy.
     */
    private void initKeepAlive() {
    	
    	myStrategy =  new DefaultConnectionKeepAliveStrategy() {
    	    @Override
    	    public long getKeepAliveDuration(
    	            HttpResponse response,
    	            HttpContext context) {
    	        long keepAlive = super.getKeepAliveDuration(response, context);
    	        if (-1 == keepAlive) {
    	            // Keep connections alive 5 seconds if a keep-alive value
    	            // has not be explicitly set by the server
    	        	HttpHost target = (HttpHost) context.getAttribute(
    	    	                HttpClientContext.HTTP_TARGET_HOST);
    	    	        
	    	        //keep alive for 30 seconds by default
	    	        keepAlive=configHttp.getKeepAliveDefault();
	    	        
	    	        log.warn(target.getHostName()+" has no Keep-Alive header, keepAlive="+keepAlive);
    	        }else {
    	        	
	   	        	 HttpHost target = (HttpHost) context.getAttribute(
		    	                HttpClientContext.HTTP_TARGET_HOST);
	   	        	 
	   	        	 log.info(target.getHostName()+" has Keep-Alive header, keepAlive="+keepAlive);
    	        }
    	        return keepAlive;
    	    }
    	};
    	
    	log.info("初始化KeepAlive策略完成"+configHttp.getKeepAliveDefault());
    }
    
    /**
     * 
     * 走代理的
     * 
     * While  HttpClient  instances are thread safe and can be shared between multiple threads of execution,
it is highly recommended that each thread maintains its own dedicated instance of  HttpContext  .
     * 
     * @return
     */
    public CloseableHttpClient getHttpClientProxy() {      
    	
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRoutePlanner(routePlanner)
                .setKeepAliveStrategy(myStrategy)
                .build();          
        
        /*CloseableHttpClient httpClient = HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接*/
        return httpClient;
    }
        
    /**
     * 
     * 直接访问，不走代理的
     * 
     * @return
     */
    public CloseableHttpClient getHttpClient() {      
    	
        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setKeepAliveStrategy(myStrategy)
                .build();          
        
        /*CloseableHttpClient httpClient = HttpClients.createDefault();//如果不采用连接池就是这种方式获取连接*/
        return httpClient;
    }

	public void destroy() {
		idleConMonThread.shutdown();
	}

    
}
