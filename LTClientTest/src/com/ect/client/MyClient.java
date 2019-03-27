package com.ect.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.zonrong.www.Branch;
import org.zonrong.www.BranchResponse;
import org.zonrong.www.CheckRequest;
import org.zonrong.www.CheckResponse;
import org.zonrong.www.GetCitizenResponse;
import org.zonrong.www.IdentifierData;
import org.zonrong.www.IdentifierServiceBranchLocator;
import org.zonrong.www.IdentifierServiceBranchSoap;
import org.zonrong.www.IsCitizenExistsResponseCode;
import org.zonrong.www.LoginResponse;
import org.zonrong.www.LoginResposeCode;
import org.zonrong.www.LoginUserData;
import org.zonrong.www.ModifyPwdRequest;
import org.zonrong.www.ResponseCode;

public class MyClient {

	// 访问地址需要证通运营提供
	public static final String ENDPOINT_STR = "**********************";
	static IdentifierServiceBranchSoap port;
	private static URL endpoint;

	static {
		try {
			endpoint = new java.net.URL(ENDPOINT_STR);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			port = (new IdentifierServiceBranchLocator())
					.getIdentifierServiceBranchSoap(endpoint);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws RemoteException {
		// 需要证通运营提供以下参数信息
		String loginName = "********";
		String password = "********";
		String uniqueId = "888888";

		MyClient mc = new MyClient();

		// 登录
		LoginResponse res = mc.login(loginName, password, uniqueId);
		LoginUserData userData = res.getUserData();
		System.out.println("登录:" + res.getResponseCode());
		if (res.getResponseCode() != LoginResposeCode.SUCCESS) {
			return;
		}

		String id = "341227198912173710";
		String name = "证通测试";

		Branch branchIn = new Branch();

		branchIn.setBranchName("branchName");
		branchIn.setBranchNo("0001");

		// 单笔认证带机构信息
		BranchResponse bres = mc
				.singleCheckBranch(id, name, branchIn, userData);
		System.out.println("单笔认证带机构:" + bres.getResponseCode());
		if (bres.getResponseCode() == ResponseCode.SUCCESS) {
			IdentifierData data = bres.getIdentifier();
			System.out.println(data.getCitizenIdResult());
			System.out.println(data.getPhotos());
			Branch branchOunt = bres.getBranch();
			System.out.println(branchOunt.getBranchNo());
			System.out.println(branchOunt.getBranchName());
		}

		// 单笔认证不带机构信息
		CheckResponse cres = mc.singleCheck(id, name, userData);
		System.out.println("单笔认证不带机构:" + cres.getResponseCode());
		if (cres.getResponseCode() == ResponseCode.SUCCESS) {
			IdentifierData data = cres.getIdentifier();
			System.out.println(data.getCitizenIdResult());
			System.out.println(data.getPhotos());
		}

		// 历史重复查询
		GetCitizenResponse result = mc.getCitizenData(id, name, userData);
		System.out.println("历史重复查询:" + result.getResponseCode());
		if (result.getResponseCode() == ResponseCode.SUCCESS) {
			IdentifierData data = result.getIdentifier();
			System.out.println(data.getCitizenIdResult());
			System.out.println(data.getPhotos());
		}

		// 修改密码
		LoginResposeCode mres = mc.modifyPassword(password, password, userData);
		System.out.println("修改密码:" + mres);

	}

	public GetCitizenResponse getCitizenData(String id, String name,
			LoginUserData userData) throws RemoteException {

		CheckRequest request = new CheckRequest();

		request.setCitizId(id);
		request.setName(name);

		IsCitizenExistsResponseCode exists = port.isCitizenExists(request,
				userData);
		GetCitizenResponse response;
		if (IsCitizenExistsResponseCode.EXIST == exists) {

			response = port.getCitizenData(request, userData);
		} else {
			System.err.println("历史上未查询过" + name + id);
			response = null;
		}

		return response;

	}

	public LoginResponse login(String loginName, String password,
			String uniqueId) throws RemoteException {
		LoginUserData reqeust = new LoginUserData();

		reqeust.setLoginName(loginName);
		reqeust.setPassword(password);
		reqeust.setUniqueId(uniqueId);

		LoginResponse response = port.login(reqeust);

		return response;

	}

	public CheckResponse singleCheck(String id, String name,
			LoginUserData userData) throws RemoteException {
		CheckRequest request = new CheckRequest();

		request.setCitizId(id);
		request.setName(name);
		CheckResponse response = port.singleCheck(request, userData);

		return response;
	}

	public BranchResponse singleCheckBranch(String id, String name,
			Branch branch, LoginUserData userData) throws RemoteException {
		CheckRequest request = new CheckRequest();

		request.setCitizId(id);
		request.setName(name);

		BranchResponse response = port.singleCheckBranch(request, branch,
				userData);

		return response;

	}

	public LoginResposeCode modifyPassword(String newPwd, String orgPwd,
			LoginUserData userData) throws RemoteException {
		ModifyPwdRequest request = new ModifyPwdRequest();

		request.setNewPwd(newPwd);
		request.setOrgPwd(orgPwd);

		return port.modifyPassword(request, userData);
	}

}
