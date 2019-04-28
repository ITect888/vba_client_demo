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
 * 描述: 修改账户密码接口
 * 
 * 账户密码需要客户端维护和保管。账户密码若遗失可申请证通进行重置
 * 重置后初始密码为空，需要设置为非空值。即第一次设置密码时，ptypwd为空，但是newptypwd不能为空（生成规则机构自定义，超过16位的字母数字组合）
 * 
 * 200002和2000006接口一般只需要调用一次，后续有修改密码以及修改会话秘钥需要时可再次调用。
 * 
 * @author fanyj
 *
 */
public class Function2000006Test {
	
	private Log log = LogFactory.getLog(Function2000006Test.class);
	
	private Config config=Config.getInstance();
	
	private PoolClient client=PoolClient.getInstance();
	
	public void doWork() throws Exception {
		//组装参数，第一次修改密码时ptypwd传空字符串，非第一次修改密码时ptypwd不能为空字符串或者不传。注：账户密码并不参与业务交易，只用于修改会话秘钥;
		String data = "ptyacct="+config.getPtyacct()
		+"&ptycd="+config.getPtycd()+"&newptypwd="+config.getNewPtyPwd()
		+"&ptypwd="+config.getPtyPwd();
		//公钥加密且做对应的base64，URLEncoder处理
		data = KeyHelp.getStrByPublic(config.getPublicKey(), data);

		//组装参数调用接口
		Map<String, String> map = new HashMap<String,String>();
		map.put("funcNo", "2000006");//修改密码功能号
		map.put("reqdata", data);

		//发起post请求，UrlEncodedFormEntity方式，选择相信服务端ssl证书，忽略证书认证
		String result = client.post(config.getUrl(), map);
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
			//开始业务处理，此处示例打印提醒修改密码成功
			log.info("修改密码成功，新的密码为="+config.getNewPtyPwd());
		}else{//修改会话秘钥失败，系统级调用失败，异常，查看入参或者联系服务端
			 
			//开始业务处理，此处示例打印提醒修改密码失败和服务端返回的失败信息
			log.info("修改会话秘钥失败，失败信息为="+json.getError_info());
			 
			throw new IllegalStateException("修改密码失败，失败信息为="+json.getError_info()+"，系统级调用失败，异常，查看入参或者联系服务端");
		}
	}
	
	@Test
	public void test() {

		try {
			doWork();
		} catch(Exception e) {
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
