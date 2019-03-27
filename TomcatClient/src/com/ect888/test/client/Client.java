package com.ect888.test.client;

import java.io.IOException;

import org.apache.axis.AxisProperties;
import org.apache.log4j.Logger;

import com.zhengtong.service.ws.ICServiceProxy;
import com.zhengtong.service.ws.Ic;
import com.zhengtong.service.ws.IcResp;

public class Client {

	Logger log = Logger.getLogger(Client.class);

	public Ic produceRequest(String customerName, String idNo) {

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

	// public static void main(String[] args) throws Exception {
	//
	// String keystorePath = "cert/serverCrt.keystore";
	// String password = "ect888";
	//
	// Client c = new Client(keystorePath, password);
	//
	// String customerName = "张三";//
	// String idNo = "430602201501013710";//
	//
	// c.invoke(customerName,idNo);
	//
	// }

	public Client( String endpoint) {

		log.info(endpoint);
		//核心思想是自己做一个不对证书做任何检查的SocketFactory，并用这个socket factory来替换Axis本身用的SocketFactory
		AxisProperties.setProperty("axis.socketSecureFactory","com.ect888.test.client.MySocketFactory");
		// 实例化服务调用,服务地址见ICServiceServiceLocator.ICServicePort_address
		serviceRunner = new ICServiceProxy();

		serviceRunner.setEndpoint(endpoint);
	}

	String truststorePath;
	String password;
	String endpoint;

	ICServiceProxy serviceRunner;

	public void invoke(String customerName, String idNo) throws IOException {
		log.info("customerName:" + customerName + ",idNo" + idNo);
		Ic request = produceRequest(customerName, idNo);
		IcResp result = serviceRunner.idCert(request);
		processResult(result);
	}



	IcResp result;

	public IcResp getResult() {
		return result;
	}

	public void setResult(IcResp result) {
		this.result = result;
	}

	private void processResult(IcResp result) throws IOException {
		this.result = result;

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
