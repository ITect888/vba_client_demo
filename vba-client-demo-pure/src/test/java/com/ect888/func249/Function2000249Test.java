package com.ect888.func249;

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
 * 行驶证查询 同步
 * 
 * 
 * @author fanyj
 *
 */
public class Function2000249Test {
	
static final String FUNC_NO="2000249";
	
	/**
	 * 车牌省份
	 * 
	 * 不参与签名
	 * 
	 * 以url编码再base64编码形式post发送
	 * 
	 */
	String province = "苏";

	/**
	 * 车牌号(无省份开头)
	 * 
	 * 车牌号入参校验：字符串中间不能有空格
	 * post传参数时要进行以下处理，
	 * 步骤为：[a]，用会话密钥加密(AES加密方法);
	 * [b].URLEncoder.encode（[a]中加密串）;
	 * [c],base64（[b]中字符串） 
	 * 
	 * 签名的时候车牌号(即使值为空也需要如此处理)需要利用会话密钥进行AES加密
	 */
	String platenumber="f80001";
	
	/**
	 * 号牌种类
	 * 必填
	 * 见接口文档数据字典说明
	 * 
	 */
	String platetype="01";
	
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
	 * 
	 * 签名过程：上送参数（sourcechnl,biztyp，biztypdesc，platetype，platenumber，placeid，ptyacct，ptycd，timestamp，key(会话密钥)），其中key前面的是按照字母排序的，key则是要最后附加上去。
	 * 其中在签名的时候车牌号platenumber需要用会话密钥进行AES加密。签名过程生成签名密钥sign  
	 * 
	 * 上送参数（sourcechnl,biztyp，biztypdesc，platetype，platenumber，province, placeid，ptyacct，ptycd，timestamp，funcNo，sign(会话密钥)）
	 * ，传上述参数时的车牌号platenumber要进行以下处理，步骤为：[a]，用会话密钥加密(AES加密方法);[b].URLEncoder.encode（[a]中加密串）;[c],base64（[b]中字符串） 
	 *  , 省份province要进行[b][c]两步处理，传上述参数的时候没有顺序要求的 
	 * 
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		
		params.put(FunctionCommon.TO_AES_TO_URL_TO_BASE64_HEAD+"platenumber", platenumber);
		params.put(FunctionCommon.TO_SIGN_HEAD+"platetype", platetype);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"timestamp", timestamp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		
		params.put(FunctionCommon.TO_URL_TO_BASE64_HEAD+"province", province);
		
		params.put("funcNo", FUNC_NO);
		
		return params;
	}

	/**
	 * json结果result的解析并处理
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		 Json249 json=JSON.parseObject(result,Json249.class);
			
		 if("0".equals(json.getError_no())) {//系统级调用成功
			 if(json.getResults().isEmpty()||null==json.getResults().get(0))//异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端
				 throw new IllegalStateException("异常，系统级调用成功，却无结果，健壮性考虑，留此分支,联系服务端");
			 
			 Result249 re=json.getResults().get(0);
			 String status=re.getStatus();
			 if("00".equals(status)) {//订单成功结束,开始业务处理，此处示例打印主要业务应答结果
				 log.info("订单成功结束");
				 log.info("业务应答码respcd="+re.getRespcd());
				 log.info("业务应答信息respinfo="+re.getRespinfo());
				 
				 //业务应答
				 log.info("车辆状态"+re.getCarStatus());
				 log.info("Vin 年份"+re.getVIN_year());
				 log.info("ROZ"+re.getROZ());
				 log.info("VIN"+re.getVIN());
				 log.info("...");
				 log.info(JSON.toJSONString(re));
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
	
}
