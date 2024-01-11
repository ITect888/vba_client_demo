package com.ect888.func380;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.func381.Json381;
import com.ect888.func381.Result381;
import com.ect888.http.PoolClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 出入境身份认证
 * 
 */
public class Function2000380Test {
	
	private static Log log = LogFactory.getLog(Function2000380Test.class);
	
	static final String FUNC_NO="2000380";
	
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
	 * 业务类型
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
	 * 证件类型编号
	 * 
	 * 414：定居国外的中国公民护照，普通护照	516：港澳居民来往内地通行证		553：外国人永久居留身份证
	 * 参与签名
	 */
	String idType = "";
	
	/**
	 * 证件号码	
	 * 签名的时候身份证号(即使值为空也需要如此处理)需要利用会话密钥进行AES加密
	 * post传参数时的身份证号要进行以下处理，
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode（[a]中加密串）;
	 * [c],base64（[b]中字符串） 
	 * 
	 */
	String idNumber="";
	
	/**
	 * 国籍代码
	 * 参与签名
	 */
	String nation = "";
	
	/**
	 *
	 * 参与签名
	 */
	String name = "";
	
	/**
	 * 正面人像图片路径
	 * 需用Base64编码
	 * 接口限制图片大小为30k，100k-1mb大小的图片将由证通进行压缩，不支持1MB以上的图片。
	 */
	String photoData=Thread.currentThread().getContextClassLoader().getResource("").getPath()+File.separator+"30K高清案例.jpg";
	
	
	/**
	 * 时间戳
	 * 
	 * 参与签名
	 */
	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();
	
	/**
	 * 
	 *
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams()  throws Exception{
		Map<String,String> params=new HashMap<String,String>();

		params.put(FunctionCommon.TO_SIGN_HEAD+"timestamp", timestamp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());	
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"idType",idType);
		params.put(FunctionCommon.TO_SIGN_HEAD+"nation",nation);
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"idNumber", idNumber);
		params.put(FunctionCommon.TO_SIGN_HEAD+"name",name);
		
		params.put(FunctionCommon.TO_PIC_BASE64_HEAD+"photoData", photoData);
		
		params.put("funcNo", FUNC_NO);
		
		return params;
	}
	
	/**
	 * 模拟调用
	 */
	public void doWork()  throws Exception{
			
		Map<String, String> params=buildParams();
		//加密加签,发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
		String result = funcCommon.invoke(params);
		log.info("result=>"+result);
		//解析返回数据并处理
		processResult(result);
	}
	
	/**
	 * json结果result的解析并处理
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		 Json381 json=JSON.parseObject(result, Json381.class);
		
		 if("0".equals(json.getError_no())) {//系统级调用成功
			 if(json.getResults().isEmpty()||null==json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");
			 
			 Result381 re=json.getResults().get(0);
			 log.info("订单成功结束");
			 }else {//异常，未知返回码，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，未知返回码,联系服务端");
			 }
		 }
		
	
	@Test
	public void test() throws Exception{

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
