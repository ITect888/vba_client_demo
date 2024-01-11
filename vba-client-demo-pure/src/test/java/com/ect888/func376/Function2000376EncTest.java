package com.ect888.func376;

import com.ect888.bus.FunctionCommon;
import com.ect888.bus.impl.FunctionCommonImpl;
import com.ect888.bus.impl.FunctionCommonImplV2;
import com.ect888.config.Config;
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


public class Function2000376EncTest {
	
	private static Log log = LogFactory.getLog(Function2000376EncTest.class);
	
	static final String FUNC_NO="2000376";
	
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
	 * 时间戳
	 * 
	 * 参与签名
	 */
	String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());


	String idType = "";


	String nation = "";

	String idNumber = "";

	String expiryDate = "";

	String name = "";

	String sex = "";

	String birthDate = "";

	String photoData=Thread.currentThread().getContextClassLoader().getResource("").getPath()+ File.separator+"30K高清案例.jpg";
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	private FunctionCommonImplV2 functionCommonImplV2= FunctionCommonImplV2.getInstance();
	
	/**
	 * 
	 *
	 * @return 将入参，按照http post上送和签名规则，放入map内
	 */
	private Map<String, String> buildParams() {
		Map<String,String> params=new HashMap<String,String>();
		params.put(FunctionCommon.TO_SIGN_HEAD+"timestamp", timestamp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztypdesc", biztypdesc);
		params.put(FunctionCommon.TO_SIGN_HEAD+"biztyp", biztyp);
		params.put(FunctionCommon.TO_SIGN_HEAD+"placeid", placeid);
		params.put(FunctionCommon.TO_SIGN_HEAD+"sourcechnl", sourcechnl);
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptyacct",config.getPtyacct());
		params.put(FunctionCommon.TO_SIGN_HEAD+"ptycd",config.getPtycd());
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"idType",idType);
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"nation",nation);
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"idNumber",idNumber);
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"expiryDate",expiryDate);
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"name",name);
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"sex",sex);
		params.put(FunctionCommon.TO_AES_DATA_HEAD+"birthDate",birthDate);
		params.put(FunctionCommon.TO_AES_PIC_BASE64_HEAD+"photoData", photoData);
		params.put(FunctionCommon.TO_SIGN_HEAD+"funcNo", FUNC_NO);
		
		return params;
	}
	
	/**
	 * 模拟调用
	 */
	public void doWork(){
			
		Map<String, String> params=buildParams();
		HashMap<String,String> header = new HashMap<>();
		//3.0,对data节点中的数据全部加密
		header.put("version", "3.0");
		header.put("enc", "1");
		//CONTENT-TYPE application/json
		String result = functionCommonImplV2.invoke(params,header);
		log.info(result);
		//解析返回数据并处理
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