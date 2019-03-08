package com.ect888;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.ect888.bean.JsonCommon;
import com.ect888.config.Config;
import com.ect888.http.PoolClient;
import com.ect888.util.KeyHelp;

/**
 * 描述: 修改交易会话密钥接口
 * 
 * 发起交易只需要会话密钥。会话密钥需要客户端维护和保管
 * 注：调用200002步骤中生成的会话密钥是没有时效性的，一次调用产生会话密钥可以永久使用 。 
 *  
 * 调用200002和2000006两步一般只需要调用一次，后续有修改密码以及修改会话秘钥需要时可再次调用。
 * 
 * @author fanyj
 *
 */
public class Function2000002Test {
	
	private Log log = LogFactory.getLog(Function2000002Test.class);
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	public void doWork() throws Exception {
		
		//组装参数，会话密钥为随便大于16位小于64位的字符串（生成规则机构自定义，超过16位的字母数字组合）。注：发起交易只需要会话密钥。会话密钥设置后不更改则长久有效;
		String data = "ptyacct="+config.getPtyacct()
		+"&ptycd="+config.getPtycd()+"&ptypwd="+config.getNewPtyPwd()
		+"&encrykey="+config.getPtyKey();

		//公钥加密且做对应的base64，URLEncoder处理
		data = KeyHelp.getStrByPublic(config.getPublicKey(), data);

		//组装参数调用接口
		Map<String, String> map = new HashMap<String,String>();
		map.put("funcNo", "2000002");//修改会话密钥功能号
		map.put("reqdata", data);

		//发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
		String result =  client.post(config.getUrl(), map);
		log.info(result);
		//解析返回数据并处理
		processResult(result);
	}
	
	/**
	 * json结果result的解析并处理
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		JsonCommon json=JSON.parseObject(result,JsonCommon.class);
		
		if("0".equals(json.getError_no())) {//系统级调用成功
			//开始业务处理，此处示例打印提醒修改会话秘钥成功
			log.info("修改会话秘钥成功，新的会话秘钥为="+config.getPtyKey());
		}else{//修改会话秘钥失败，系统级调用失败，异常，查看入参或者联系服务端
			 
			//开始业务处理，此处示例打印提醒修改会话秘钥失败和服务端返回的失败信息
			log.info("修改会话秘钥失败，失败信息为="+json.getError_info());
			 
			throw new IllegalStateException("修改会话秘钥失败，失败信息为="+json.getError_info()+"，系统级调用失败，异常，查看入参或者联系服务端");
		}
	}
	
	@Test
	public void test() {

		try {
			doWork();
		} catch (Exception e) {
			log.error("",e);
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
