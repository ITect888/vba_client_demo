package com.ect888.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * 
 * http长链接连接池方式访问客户端
 * 
 * @author fanyj
 *
 */
public class PoolClient {
	
	
	private Log log = LogFactory.getLog(PoolClient.class);
	
	private PoolClient() {
		init();
	}
	
	private static class Holder{
		public static final PoolClient instance=new PoolClient();
	}
	
	public static PoolClient getInstance() {
		return Holder.instance;
	}
	
	HttpConnectionManager connManager=HttpConnectionManager.getInstance();

	RequestConfig requestConfig = null;

	/**
	 * HttpClient  implementations are expected to be thread safe. It is recommended that the same instance
		of this class is reused for multiple request executions.
	 */
	CloseableHttpClient httpClient = null;
	
	/**
	 * When  an  instance  CloseableHttpClient   is  no  longer  needed  and  is  about  to  go  out
		of  scope  the  connection  manager  associated  with  it  must  be  shut  down  by  calling  the
		CloseableHttpClient#close()  method.
	 */
	public void destroy() {
		try {
			httpClient.close();
		} catch (IOException e) {
			log.error("",e);
		}
	}
	
	/**
	 * 连接超时时间
	 */
	private static final int CONNECTION_TIMEOUT_MS = 60000;

	/**
	 * 读取数据超时时间
	 */
	private static final int SO_TIMEOUT_MS = 60000;

	/**
	 * 初始化
	 * 
	 * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
	 * PostConstruct在构造函数之后执行,init()方法之前执行。
	 * 
	 */
	public void init() {
		requestConfig = RequestConfig.custom().setSocketTimeout(SO_TIMEOUT_MS).setConnectTimeout(CONNECTION_TIMEOUT_MS).build();

		log.info("走代理访问，SocketTimeout="+SO_TIMEOUT_MS+"毫秒，ConnectTimeout="+CONNECTION_TIMEOUT_MS+"毫秒");
		
		httpClient = connManager.getHttpClientProxy();
	}
	
	/**
	 * @param path
	 * @param clazz
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public <T> T get(String path, Class<T> clazz) throws ClientProtocolException, IOException {
		HttpGet httpGet = new HttpGet(path);
		httpGet.setConfig(requestConfig);
//		httpGet.setHeader("Connection", "keep-alive");
		
		String json=tryExecute(httpGet);
		
		return JSON.parseObject(json, clazz);
	}
	

	/**
	 * @param path
	 * @param headers
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String get(String path,Map<String , String>headers, Map<String, String> params) throws ClientProtocolException, IOException {
		String url = buildGetUrl(path, params);
		HttpGet httpGet = new HttpGet(url);
		httpGet.setConfig(requestConfig);

		if(null!=headers){
			for(String key:headers.keySet()){
				String value=headers.get(key);
				httpGet.setHeader(key, value);
			}
		}
		String responeEntity=tryExecute(httpGet);
		
		return responeEntity;
	}
	
	/**
	 * @param path
	 * @param clazz
	 * @param body
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public <T> T post(String path, Class<T> clazz,String body) throws ClientProtocolException, IOException{
		 return post(path, clazz, body, ContentType.APPLICATION_JSON, null);
	}
	
	/**
	 * @param path
	 * @param clazz
	 * @param body
	 * @param contentType
	 * @param headers
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public <T> T post(String path, Class<T> clazz,String body,ContentType contentType,Map<String, String> headers) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(path);
		httpPost.setConfig(requestConfig);
//		httpPost.setHeader("Connection", "keep-alive");
		
		StringEntity se = new StringEntity(body,contentType);
		httpPost.setEntity(se);
		
		if(null!=headers){
			for(String key:headers.keySet()){
				String value=headers.get(key);
				httpPost.setHeader(key, value);
			}
		}
		String json=tryExecute(httpPost);
	
		return JSON.parseObject(json, clazz);
	}

	/**
	 * @param path
	 * @param body
	 * @param headers
	 * @param headers
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String post(String path,String body,Map<String, String> headers) throws ClientProtocolException, IOException {
		HttpPost httpPost = new HttpPost(path);
		httpPost.setConfig(requestConfig);
//		httpPost.setHeader("Connection", "keep-alive");

		StringEntity se = new StringEntity(body,ContentType.APPLICATION_JSON);
		httpPost.setEntity(se);

		if(null!=headers){
			for(String key:headers.keySet()){
				String value=headers.get(key);
				httpPost.setHeader(key, value);
			}
		}
		String json=tryExecute(httpPost);

		return json;
	}

	/**
	 * @param request
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private String tryExecute(final HttpUriRequest request) throws ClientProtocolException, IOException {
		String json = null;
		
		CloseableHttpResponse response=null;
		try{
			response=httpClient.execute(request);
		    HttpEntity entity = response.getEntity();
		    if (entity != null) {
		    	json = EntityUtils.toString(entity,Consts.UTF_8);
		    }
		} finally {
			if(null!=response) {
				response.close();
			}
		}
		
		return json;
	}

	/**
	 * @param apiUrl
	 * @param clazz
	 * @param bodyMaps
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public <T> T post(String apiUrl, Class<T> clazz, Map<String, String> bodyMaps) throws ClientProtocolException, IOException {
		String json=post(apiUrl, bodyMaps);
		
		return JSON.parseObject(json, clazz);
	}
	
	/**
	 * @param apiUrl
	 * @param bodyMaps
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String post(String apiUrl, Map<String, String> bodyMaps) throws ClientProtocolException, IOException {

		HttpPost httpPost = new HttpPost(apiUrl);
//		httpPost.setHeader("Connection", "keep-alive");
		
		if (null != bodyMaps&&!bodyMaps.isEmpty()){
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			for(String key:bodyMaps.keySet()) {
				String vaule=bodyMaps.get(key);
				formparams.add(new BasicNameValuePair(key, vaule));
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, Consts.UTF_8);
			httpPost.setEntity(entity);
		}
		
		
		log.debug("apiUrl="+apiUrl);
		log.debug("postEntity="+httpPost.getEntity());
		log.debug("postStr:"+EntityUtils.toString(httpPost.getEntity()));
		
		String json=tryExecute(httpPost);
		
		return json;
	}
	
	/**
	 * build getUrl str
	 * URLEncodedUtils
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	private static String buildGetUrl(String url, Map<String, String> params) {
		StringBuffer uriStr = new StringBuffer(url);
		if (params != null) {
			List<NameValuePair> ps = new ArrayList<NameValuePair>();
			for (String key : params.keySet()) {
				ps.add(new BasicNameValuePair(key, params.get(key)));
			}
			uriStr.append("?");
			uriStr.append(URLEncodedUtils.format(ps, "UTF-8"));
		}
		return uriStr.toString();
	}

	public HttpConnectionManager getConnManager() {
		return connManager;
	}

}