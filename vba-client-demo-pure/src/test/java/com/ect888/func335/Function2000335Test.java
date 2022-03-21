package com.ect888.func335;

import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import com.ect888.util.MD5Utils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 实名认证服务-同步 
 * 
 * @author fanyj
 *
 */
public class Function2000335Test {
	
	private static Log log = LogFactory.getLog(Function2000335Test.class);
	
	static final String FUNC_NO="2000335";
	

	/**

	 * 必填
	 */
	String certseq= MD5Utils.md5("341227198912173710");

	String encry="2"; //2 md5 3 sha256

	/**
	 * 来源渠道，填固定值“0”
	 * 
	 * 参与签名
	 */
	String sourcechnl="0";
	/**
	 * 业务发生地
	 * 符合入参长度即可，不做技术限制
	 * 
	 * 参与签名
	 */
	String placeid="00";
	/**
	 * 服务类型
	 * 符合入参长度即可，不做技术限制
	 * 
	 * 参与签名
	 */
	String biztyp="A001";
	/**
	 * 服务描述
	 * 
	 * 符合入参长度即可，不做技术限制
	 * 
	 * 参与签名
	 */
	String biztypdesc="对比服务";
	/**
	 * 时间戳
	 * 
	 * 参与签名
	 */
	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();

	public Function2000335Test() throws UnsupportedEncodingException {
	}

	/**
	 * 
	 * 将入参，按照http post上送和签名规则，放入map内
	 *
	 * 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"certseq", certseq);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"timestamp", timestamp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		params.put(FunctionCommon.TO_SIGN_HEAD+"encry",encry);

		params.put("funcNo", FUNC_NO);
		
		return params;
	}
	
	/**
	 * 模拟调用
	 */
	public void doWork(){
			
		Map<String, String> params=buildParams();
		//加密加签,发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
		String result = funcCommon.invoke(params);
			
		//解析返回数据并处理
		System.out.println(result);
	}
	


	
	@Test
	public void test() {
		try {
			doWork();
		}catch(RuntimeException e){
			log.error("运行时异常",e);
		}finally {
			//应用结束，关闭长连接及其连接池
			client.destroy();
			client.getConnManager().destroy();
		}
	}
	
	@Before
	public void before() {
		String log4jFileStr = "log4j.properties";
		PropertyConfigurator.configure(log4jFileStr);
	}
}
