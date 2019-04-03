package com.ect888.cias;

import java.io.IOException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import org.w3c.dom.Document;

/**
 * 
 * 身份认证单笔查询示例
 * 
 * @author fanyj
 *
 */
public class IdCertExample {

	final static String NAMESPACE = "http://ws.service.zhengtong.com/";
	final static QName SERVICE_NAME = new QName(NAMESPACE, "ICService");
	final static QName PORT_NAME = new QName(NAMESPACE, "ICServicePort");
	final static String IP = "************";//需要证通运营提供
	final static String ENDPOINT_ADDRESS = "https://" + IP
			+ ":9105/CIAService/ICService";
	final static QName IDCERT_NAME = new QName(NAMESPACE, "idCert", "ns"); // 身份认证单笔查询idCert报文体信息，一定要加ns或ws前缀
	final static QName IDCERT_RESPONSE_NAME = new QName(NAMESPACE,
			"idCertResponse", "ns");

	static Dispatch<SOAPMessage> dispatch;

	static {
		// 解决由于证书来自IP地址而不是域名导致的 No subject alternative names present问题。
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				// ip address of the service URL
				if (hostname.equals(IP))
					return true;
				return false;
			}
		});
		// 使用keytool -import -alias serverkey -file localhost.localdomain.crt
		// -keystore
		// serverCrt.keystore从服务器证书localhost.localdomain.crt中生成truststore
		System.setProperty("javax.net.ssl.trustStore", "serverCrt.keystore");
		
		// 设置密钥密码，否则会:NoSuchAlgorithmExceptions are often cause by other
		// underlying exceptions (file not found, wrong password, wrong keystore
		// type, ...)
		System.setProperty("javax.net.ssl.trustStorePassword", "ect888");
		
		//支持配置TLSv1.2的版本
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
	}

	static {
		Service service = Service.create(SERVICE_NAME);
		service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING,
				ENDPOINT_ADDRESS);
		dispatch = service.createDispatch(PORT_NAME, SOAPMessage.class,
				Service.Mode.MESSAGE);
	}

	public static void main(String[] args) throws Exception {

		SOAPMessage msg = produceSOAPMessage();// 构造soap报文
		msg.writeTo(System.out); // 发送前将soap消息打印出来
		System.out.println();

		SOAPMessage resultMsg = dispatch.invoke(msg);// 发送soap报文

		System.out.println("----------------relult---------------");
		resultMsg.writeTo(System.out); // 将返回的soap消息打印出来
		System.out.println();

		processSOAPMessage(resultMsg);
	}

	private static SOAPMessage produceSOAPMessage() throws SOAPException,
			IOException {
		SOAPMessage msg = MessageFactory.newInstance().createMessage();
		SOAPBody body = msg.getSOAPPart().getEnvelope().getBody();
		SOAPBodyElement bodyEle = body.addBodyElement(IDCERT_NAME); // 添加Body信息

		addBodyMessage(bodyEle);

		return msg;
	}

	private static SOAPElement addBodyMessage(SOAPBodyElement bodyEle)
			throws SOAPException {
		SOAPElement message = bodyEle.addChildElement("message");

		String customerName = "张三";//姓名 中文全角中文半角英文全角英文半角的键盘上特殊字符除外
		String idNo = "430602201501013710";// 身份证号 符合15或18位 身份证号规则

		//需要证通运营提供以下参数信息
		String userId = "******";// 用户号 成员机构操作 人员代码, 规则参见《身 份认证服务平 台成员机构业 务需求指南》
		String branchOrgCode = "*******";// 分支机构代码 操作人员所属 分支机构代码
		String juridicalOrgCode = "*********";// 法人机构代码 操作人员所属法人机构代码
		String licenseKey = "************************";// 授权码（身份 认证服务平台 提供）

		String bizSendChannel = "01";// 业务办理渠道 00: 临柜 01: PC端 02：移动端
		String businessType = "10";// 业务类型 10: 普通类业 务 20: 信用类业 务 30: 其他业务 三类
		String queryFlow = "00";// 查询方式 00：实时查询 身份中心系统 01：重复查询
		String queryType = "00";// 查询类型 00：基本查询 01：详细查 询。 注： 01：详 细查询未启用

		message.addChildElement("customerName").setValue(customerName);
		message.addChildElement("idNo").setValue(idNo);
		message.addChildElement("userId").setValue(userId);
		message.addChildElement("branchOrgCode").setValue(branchOrgCode);
		message.addChildElement("juridicalOrgCode").setValue(juridicalOrgCode);
		message.addChildElement("licenseKey").setValue(licenseKey);
		message.addChildElement("bizSendChannel").setValue(bizSendChannel);
		message.addChildElement("businessType").setValue(businessType);
		message.addChildElement("queryFlow").setValue(queryFlow);
		message.addChildElement("queryType").setValue(queryType);

		return message;
	}

	private static void processSOAPMessage(SOAPMessage resultMsg)
			throws IOException, SOAPException {
		Document doc = resultMsg.getSOAPPart().getEnvelope().getBody()
				.extractContentAsDocument();

		String authResult = doc.getElementsByTagName("authResult").item(0)
				.getTextContent();
		String customerName = doc.getElementsByTagName("customerName").item(0)
				.getTextContent();
		String idNo = doc.getElementsByTagName("idNo").item(0).getTextContent();
		String serialNo = doc.getElementsByTagName("serialNo").item(0)
				.getTextContent();
		String responseCode = doc.getElementsByTagName("responseCode").item(0)
				.getTextContent();
		String responseMessage = doc.getElementsByTagName("responseMessage")
				.item(0).getTextContent();

		System.out.println(authResult);
		System.out.println(idNo);
		System.out.println(customerName);
		System.out.println(responseCode);
		System.out.println(responseMessage);
		System.out.println(serialNo);

		//返回成功且认证结果为一致。
		if (responseCode.equals("00") && authResult.equals("00")) {
			String birthDate = doc.getElementsByTagName("birthDate").item(0)
					.getTextContent();
			String gender = doc.getElementsByTagName("gender").item(0)
					.getTextContent();

			System.out.println(gender);
			System.out.println(birthDate);
		}
	}

}
