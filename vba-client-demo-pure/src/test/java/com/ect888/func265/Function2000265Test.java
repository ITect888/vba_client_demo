package com.ect888.func265;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;

/**
 * 银行卡账户类型验证五要素认证接口
 * 
 * 示例代码
 * 
 * @author fanyj
 *
 */
public class Function2000265Test {
	
	private static Log log = LogFactory.getLog(Function2000265Test.class);
	
	static final String FUNC_NO="2000265";
	
	/**
	 * 账户类型
	 * 
	 * 传”1”,用于验证是否为1类账户; 
	 *传”2”,用于验证是否为2类账户; 
	 *传”3”,用于验证是否为3类账户;
	 * 
	 * 必填
	 * 参与签名
	 */
	String accountType="1";
	
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
	String acctno="6222024301077815239";
	/**
	 * 证件号码	
	 * 签名的时候身份证号要利用会话密钥进行AES加密
	 * post传参数时的身份证号要进行以下处理：
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode[a]中加密串;
	 * [c],base64[b]中字符串
	 * 
	 * 必填
	 */
	String certseq="341227198912173710";
	/**
	 * 姓名
	 * 必填
	 */
	String usernm="账户类型验证通过";
	/**
	 * 手机号
	 * 选填
	 * 手机号为空时为三要素验证，非空时为四要素验证
	 */
	String phoneno="15298386506";
	
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
	String biztypdesc="银行卡账户类型验证五要素认证";
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();
	
	/**
	 * 
	 * 将入参，按照http post上送和签名规则，放入map内
	 * 
	 * 加签说明：对参数（accountType,acctno,biztyp,biztypdesc,certseq,phoneno,placeid,ptyacct,ptycd,sourcechnl,key(会话密钥)）进行 SHA512签名，其中 key前面的参数按照字母排序，key放置在最后。
	 * 银行卡号身份证号参与签名时需要利用会话密钥进行AES加密。签名生成签名密钥 sign作为输入参数上送
	 * 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"certseq", certseq);
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"acctno", acctno);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"accountType", accountType);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"phoneno", phoneno);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		
		params.put("usernm", usernm);
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
		processResult(result);
	}
	
	/**
	 * json结果result的解析并处理
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		 Json265 json=JSON.parseObject(result,Json265.class);
			
		 if("0".equals(json.getError_no())) {//系统级调用成功
			 if(json.getResults().isEmpty()||null==json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");
			 
			 Result265 re=json.getResults().get(0);
			 String status=re.getStatus();
			 if("00".equals(status)) {//订单成功结束,开始业务处理，此处示例打印主要业务应答结果
				 log.info("订单成功结束");
				 log.info("业务应答码respcd="+re.getRespcd());
				 log.info("业务应答信息respinfo="+re.getRespinfo());
			 }else if("03".equals(status)) {//订单业务性失败结束,开始业务处理，此处示例打印主要业务应答结果
				 log.info("订单业务性失败结束");
				 log.info("业务应答码respcd="+re.getRespcd());
				 log.info("业务应答信息respinfo="+re.getRespinfo());
			 }else if("01".equals(status)){//订单处理中，请稍后再轮询查询
				 log.info("订单处理中，请稍后再轮询查询");
			 }else {//异常，未知返回码，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，未知返回码,联系服务端");
			 }
		 }else{//系统级调用失败，异常，查看入参或者联系服务端
			 throw new IllegalStateException("系统级调用失败，异常，查看入参或者联系服务端");
		 }
		
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
