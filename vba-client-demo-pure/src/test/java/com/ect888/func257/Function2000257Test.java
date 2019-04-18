package com.ect888.func257;

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
import com.ect888.func261.Function2000261Test;
import com.ect888.http.PoolClient;

/**
 * 
 * 身份证有效期核查
 * 
 * @author fanyj
 *
 */
public class Function2000257Test {
	
	static final String FUNC_NO="2000257";
	
	/**
	 * 有效期起始日期
	 * 
	 * 不参与签名
	 * 
	 * 格式为yyyymmdd
	 * 	 
	 */
	String validfrom="20180327";
	/**
	 * 有效期截止日期
	 * 
	 * 格式为yyyymmdd，
	 * 若为长期有效身份证，截止日期填00000000
	 * 
	 * 不参与签名
	 */
	String validto="20380327";
	
	/**
	 * 姓名
	 * 必填，姓名入参校验：全是中文或者·（中间不能有空格）
	 * 
	 * 不参与签名
	 */
	String usernm="姓名";
	/**
	 * 证件号码	
	 * 必填，身份号入参校验：是15或18位，最后一位校验位正确
	 * 签名的时候身份证号(即使值为空也需要如此处理)需要利用会话密钥进行AES加密
	 * post传参数时的身份证号要进行以下处理，
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode（[a]中加密串）;
	 * [c],base64（[b]中字符串） 
	 * 
	 */
	String certseq="341227198912173710";
	
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
	String biztyp="A001";
	/**
	 * 服务描述
	 * 
	 * 符合入参长度即可，不做技术限制
	 * 
	 * 参与签名
	 */
	String biztypdesc="身份证有效期核查";
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
	 * 上送参数（biztyp,biztypdesc,certseq,placeid,ptyacct,ptycd,sourcechnl,timestamp,usernm,validfrom,validto,funcNo,sign(会话密钥)）
	 * ，传上述参数时的身份证号要进行以下处理，步骤为：[a]，用会话密钥加密(AES加密方法);[b].URLEncoder.encode（[a]中加密串）;[c],base64（[b]中字符串）  ,传上述参数的时候没有顺序要求的  
	 * 
	 * 签名过程：对参数（biztyp,biztypdesc,certseq,placeid,ptyacct,ptycd,sourcechnl,timestamp,key(会话密钥)），其中key前面的是按照字母排序的，key则是要最后附加上去。其中在签名的时候身份证号要利用会话密钥进行AES加密。签名过程生成签名密钥sign 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"certseq", certseq);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"timestamp", timestamp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		
		params.put("usernm", usernm);
		params.put("validfrom", validfrom);
		params.put("validto", validto);
		params.put("funcNo", FUNC_NO);
		
		return params;
	}

	/**
	 * json结果result的解析并处理
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		 Json257 json=JSON.parseObject(result,Json257.class);
		 
		 if(null==json) {
			 log.error("返回报文解析为null,配置为"+JSON.toJSONString(config));
			 return;
		 }
		
		 if("0".equals(json.getError_no())) {//系统级调用成功
			 if(json.getResults().isEmpty()||null==json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");
			 
			 Result257 re=json.getResults().get(0);
			 log.info("业务应答码respcd="+re.getRespcd());
			 log.info("业务应答信息respinfo="+re.getRespinfo());
		 }else{//系统级调用失败，异常，查看入参或者联系服务端
			 throw new IllegalStateException("系统级调用失败，异常，查看入参或者联系服务端");
		 }
		
	}
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImpl funcCommon=FunctionCommonImpl.getInstance();
	
	private static Log log = LogFactory.getLog(Function2000261Test.class);
	
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
