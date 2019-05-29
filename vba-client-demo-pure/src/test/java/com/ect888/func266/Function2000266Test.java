package com.ect888.func266;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
 * 组合产品接口
 * 
 * 示例代码
 * 
 * @author fanyj
 *
 */
public class Function2000266Test {
	
	private static Log log = LogFactory.getLog(Function2000266Test.class);
	
	static final String FUNC_NO="2000266";
	
	String inSysSeqNb=UUID.randomUUID().toString().replaceAll("\\-", "");
	
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
	 * 必填
	 */
	String phoneno="15298386506";
	
	/**
	 * 套餐编号
	 * 必填
	 */
	String setNo="1";
	
	/**
	 * 正面人像图片路径
	 * 需用Base64编码
	 * 接口限制图片大小为30k，100k-1mb大小的图片将由证通进行压缩，不支持1MB以上的图片。
	 */
//	String videopic=Thread.currentThread().getContextClassLoader().getResource("").getPath()+File.separator+"30K高清案例.jpg";
	
	/**
	 * 身份证正面照的路径
	 * 需用Base64编码
	 * 
	 * 不支持1MB以上的图片
     *同时，提取出的小图片，接口限制图片大小为30k，30k-1mb大小的图片将由证通进行压缩。
	 * 
	 */
	String cerfront=Thread.currentThread().getContextClassLoader().getResource("").getPath()+File.separator+"30K高清抠图OCR案例.jpg";
	
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();
	
	/**
	 * 
	 * 将入参，按照http post上送和签名规则，放入map内
	 * 
	 * 签名规则:非图片base64编码后字符串和funcNo=2000266部分的入参都参加签名
	 * 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
	
//		params.put(FunctionCommon.TO_PIC_BASE64_HEAD+"videopic", videopic);
		params.put(FunctionCommon.TO_PIC_BASE64_HEAD+"cerfront", cerfront);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"certseq", certseq);
		params.put(FunctionCommon.TO_SIGN_HEAD+"acctno", acctno);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"phoneno", phoneno);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"usernm", usernm);
		params.put(FunctionCommon.TO_SIGN_HEAD+"setNo", setNo);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"inSysSeqNb", inSysSeqNb);
		
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
		 Json266 json=JSON.parseObject(result,Json266.class);
			
		 if("0".equals(json.getError_no())) {//系统级调用成功
			 if(null==json.getResults()||json.getResults().isEmpty()||null==json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");
			 
			 Result266 re=json.getResults().get(0);
			 log.info("业务应答码sysseqnb="+re.getSysseqnb());
			 log.info("业务应答信息level="+re.getLevel());
			 log.info("业务应答信息code="+re.getCode());
			 log.info("业务应答信息code="+re.getScore());
			 
			 if(null==json.getDetail_10()||json.getDetail_10().isEmpty()||null==json.getDetail_10().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无套餐中服务编号为1_0的结果，健壮性考虑，留此分支,联系服务端");
			 
			 Detail_10 d1=json.getDetail_10().get(0);
			 log.info("业务应答信息respcd="+d1.getRespcd());
			 log.info("业务应答信息auth="+d1.getAuth());
			 log.info("业务应答信息respinfo="+d1.getRespinfo());
			 log.info("业务应答信息phoneOperator="+d1.getPhoneOperator());
			 log.info("业务应答信息phoneProvCity="+d1.getPhoneProvCity());
				 
			 if(null==json.getDetail_2()||json.getDetail_2().isEmpty()||null==json.getDetail_2().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无套餐中服务编号为2的结果，健壮性考虑，留此分支,联系服务端");
			 
			 Detail_2 d2=json.getDetail_2().get(0);
			 log.info("业务应答信息respcd="+d2.getRespcd());
			 log.info("业务应答信息auth="+d2.getAuth());
			 log.info("业务应答信息respinfo="+d2.getRespinfo());
			 
			 if(null==json.getDetail_5()||json.getDetail_5().isEmpty()||null==json.getDetail_5().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无套餐中服务编号为5的结果，健壮性考虑，留此分支,联系服务端");
				 
			 Detail_5 d5=json.getDetail_5().get(0);
			 log.info("业务应答信息respcd="+d5.getRespcd());
			 log.info("业务应答信息auth="+d5.getAuth());
			 log.info("业务应答信息respinfo="+d5.getRespinfo());
			 
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
