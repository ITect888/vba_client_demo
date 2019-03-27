package com.ect888.cias;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.xml.namespace.QName;

import com.zhengtong.service.ws.ICService;
import com.zhengtong.service.ws.ICService_Service;
import com.zhengtong.service.ws.Ic;
import com.zhengtong.service.ws.IcResp;

/**
 * 
 * 身份认证单笔查询示例:使用从WSDL文件ICService.xml中生成com.zhengtong.service.ws的Stub代码
 * 
 * @author fanyj
 *
 */
public class IdCertExample {

	final static QName SERVICE_NAME = new QName(
			"http://ws.service.zhengtong.com/", "ICService");
	final static String ICSERVICE_WSDL_LOCATION = "**********************";//需要证通运营提供

	private static ICService port;

	static {
		// 解决由于证书来自IP地址而不是域名导致的 No subject alternative names present问题。
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
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

		// wsimport -keep ICService.xml
		// 从WSDL文件ICService.xml中生成com.zhengtong.service.ws的Stub代码
		ICService_Service ss;
		try {
			ss = new ICService_Service(new URL(ICSERVICE_WSDL_LOCATION),
					SERVICE_NAME);
			port = ss.getICServicePort();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private static Ic produceRequest() {
		String customerName = "张三";//
		String idNo = "430602201501013710";//

		//需要证通运营提供以下参数信息
		String userId = "******";// 用户号 成员机构操作 人员代码, 规则参见《身 份认证服务平 台成员机构业 务需求指南》
		String branchOrgCode = "*******";// 分支机构代码 操作人员所属 分支机构代码
		String juridicalOrgCode = "*********";// 法人机构代码 操作人员所属法人机构代码
		String licenseKey = "************************";// 授权码（身份 认证服务平台 提供）

		String bizSendChannel = "01";//
		String businessType = "10";//
		String queryFlow = "00";//
		String queryType = "00";//

		Ic request = new Ic();

		request.setBizSendChannel(bizSendChannel);
		request.setBranchOrgCode(branchOrgCode);
		request.setBusinessType(businessType);
		request.setIdNo(idNo);
		request.setJuridicalOrgCode(juridicalOrgCode);
		request.setLicenseKey(licenseKey);
		request.setQueryFlow(queryFlow);
		request.setQueryType(queryType);
		request.setUserId(userId);
		request.setCustomerName(customerName);
		return request;
	}

	public static void main(String[] args) throws Exception {
		Ic request = produceRequest();

		IcResp result = port.idCert(request);

		processResult(result);
	}

	private static void processResult(IcResp result) throws IOException {

		System.out.println("----------------relult---------------");

		System.out.println(result.getAuthResult());
		System.out.println(result.getCustomerName());
		System.out.println(result.getIdNo());
		System.out.println(result.getResponseCode());
		System.out.println(result.getResponseMessage());
		System.out.println(result.getSerialNo());

		// 返回成功且认证结果为一致。
		if (result.getResponseCode().equals("00")
				&& result.getAuthResult().equals("00")) {
			System.out.println(result.getGender());
			System.out.println(result.getBirthDate());
		}
	}
}
