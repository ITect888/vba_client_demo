package com.ect888.func1207;

import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 银行卡三四要素认证接口
 * 
 */
public class Function2001207Test {
	
	private static Log log = LogFactory.getLog(Function2001207Test.class);
	
	static final String FUNC_NO="2001207";
	
	
	/**
	 * 银行卡号	
	 * 签名的时候银行卡号要利用会话密钥进行AES加密
	 * post传参数时的身份证号要进行以下处理：
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode[a]中加密串;
	 * [c],base64[b]中字符串
	 * 
	 * 必填
	 */
	String acctno="1234567899";
	/**
	 * 证件号码	
	 * 签名的时候证件号码要利用会话密钥进行AES加密
	 * post传参数时的证件号码要进行以下处理：
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode[a]中加密串;
	 * [c],base64[b]中字符串
	 * 
	 * 必填
	 */
	String certseq="3333333333";

	String idType = "01";
	/**
	 * 姓名
	 * 必填
	 */
	String usernm="姓名";
	/**
	 * 手机号
	 * 选填
	 * 手机号为空时为三要素验证，非空时为四要素验证
	 */
	String phoneno="11111111111";
	
	/**
	 * 短信验证码，暂不使用，填空字符串""
	 * 
	 * 参与签名
	 */
	String code="";
	
	/**
	 * 业务流水号，暂不使用，填空字符串""
	 * 
	 * 参与签名
	 */
	String sysseqnb="";
	
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
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();
	
	/**
	 * 
	 * 将入参，按照http post上送和签名规则，放入map内
	 * 
	 * 加签说明：对参数（acctno，biztyp,biztypdesc,certseq,code，phoneno,placeid,ptyacct,ptycd,sourcechnl,sysseqnb,key(会话密钥)）进行 SHA512签名
	 * ，其中 key前面的参数按照字母排序，key放置在最后。银行卡号身份证号参与签名时需要利用会话密钥进行AES加密。签名生成签名密钥 sign作为输入参数上送
	 * 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"certseq", certseq);
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"acctno", acctno);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"phoneno", phoneno);
		params.put(FunctionCommon.TO_SIGN_HEAD+"code", code);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sysseqnb", sysseqnb);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		
		params.put("usernm", usernm);
		params.put("idType", idType);
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
