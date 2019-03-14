package com.ect888.func256;

import java.text.SimpleDateFormat;
import java.util.Date;
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
 * 2000256证通失效身份证核查服务
 * 示例代码
 * 
 * @author fanyj
 *
 */
public class Function2000256Test {
	
	static final String FUNC_NO="2000256";
	/**
	 * 证件号码	
	 * 签名的时候身份证号需要利用会话密钥进行AES加密
	 * post传参数时的身份证号要进行以下处理，
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode（[a]中加密串）;
	 * [c],base64（[b]中字符串） 
	 */
	String certseq="341227198912173710";
	
	/**
	 * 姓名
	 * 符合入参长度即可，不做技术限制
	 * 参与签名
	 */
	String usernm="姓名";
	/**
	 * 身份证起始日期
	 * 符合入参长度即可，不做技术限制
	 * 参与签名
	 */
	String beginDate="20160429";
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
	 * 对照接口文档查看
	 * 符合入参长度即可，不做技术限制
	 * 
	 * 参与签名
	 */
	String biztyp="0";
	/**
	 * 服务描述
	 * 符合入参长度即可，不做技术限制
	 * 
	 * 参与签名
	 */
	String biztypdesc="失效身份证核查";
	
	/**
	 * 时间戳
	 * 
	 * 参与签名
	 */
	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	
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
	 * 
	 * 将入参，按照http post上送和签名规则，放入map内
	 * 
	 * 签名过程：上送参数（addr_typ，addr，biztyp，biztypdesc，certseq，phoneno，placeid，ptyacct，ptycd，sourcechnl，usernm，key(会话密钥)）
	 * ，其中key前面的是按照字母排序的，key则是要最后附加上去。其中在签名的时候身份证、姓名、手机号及地址需用会话密钥进行AES加密。
	 *
	 * 传上述参数时的证件号码、地址、手机号码、姓名要进行以下处理，步骤为：[a]用会话密钥加密(AES加密方法； [b]对a得到的结果进行URLEncoder.encode； [c]将b得到的结果转为base64字符串。 
	 * 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"certseq", certseq);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		params.put(FunctionCommon.TO_SIGN_HEAD+"timestamp", timestamp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"beginDate", beginDate);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		
		params.put("usernm", usernm);
		params.put("funcNo", FUNC_NO);
		
		return params;
	}

	/**
	 * json结果result的解析并处理
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		 Json256 json=JSON.parseObject(result,Json256.class);
		 
		 if(null==json) {
			 log.error("返回报文解析为null,配置为"+JSON.toJSONString(config));
			 return;
		 }
		
		 if("0".equals(json.getError_no())) {//系统级调用成功
			 if(json.getResults().isEmpty()||null==json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");
			 
			 Result256 re=json.getResults().get(0);
			 String status=re.getStatus();
			 if("00".equals(status)) {//订单成功结束,开始业务处理，此处示例打印主要业务应答结果
				 System.out.println("订单成功结束");
				 System.out.println("业务应答码respcd="+re.getRespcd());
				 System.out.println("业务应答信息respinfo="+re.getRespinfo());
			 }else if("03".equals(status)) {//订单业务性失败结束,开始业务处理，此处示例打印主要业务应答结果
				 System.out.println("订单业务性失败结束");
				 System.out.println("业务应答码respcd="+re.getRespcd());
				 System.out.println("业务应答信息respinfo="+re.getRespinfo());
			 }else if("01".equals(status)){//订单处理中，请稍后再轮询查询
				 log.info("订单处理中，请稍后再轮询查询");
			 }else {//异常，未知返回码，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，未知返回码,联系服务端");
			 }
		 }else{//系统级调用失败，异常，查看入参或者联系服务端
			 throw new IllegalStateException("系统级调用失败，异常，查看入参或者联系服务端");
		 }
		
	}
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();
	
	private static Log log = LogFactory.getLog(Function2000256Test.class);
	
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
