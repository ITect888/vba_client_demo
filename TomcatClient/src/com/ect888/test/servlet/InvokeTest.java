package com.ect888.test.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ect888.test.client.Client;
import com.zhengtong.service.ws.IcResp;

public class InvokeTest extends HttpServlet {
	
	@Override
	public void init(ServletConfig config) throws ServletException {

		String path = config.getServletContext().getRealPath("/");

		PropertyConfigurator.configure(path + "/log4j.properties");		
	}

		
    static String endpoint = "******************";//需要证通业务运营提供
		
	public static Client client=new Client(endpoint);

	Logger log = Logger.getLogger(InvokeTest.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	public String readJSONString(HttpServletRequest request) {
		StringBuffer json = new StringBuffer();
		String line = null;
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				json.append(line);
			}
		} catch (Exception e) {
			log.error("Exception:", e);
		}
		return json.toString();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String indName = request.getParameter("indName");// 获取身份证号码
		String certId = request.getParameter("certId");// 获取姓名
		
		log.info("indName:" + indName + ",certId" + certId);

		boolean flag = true;
		String responseMessage = null;
		if (null == indName) {
			log.error("null==indName");
			responseMessage = "姓名indName为空";
			flag = false;
		}

		if (null == certId) {
			log.error("null==certId");
			responseMessage = "身份号码certId为空";
			flag = false;
		}

		if (flag) {
			client.invoke(indName, certId);
			IcResp result=client.getResult();
			responseMessage="";
			responseMessage+="姓名："+result.getCustomerName()+"\r\n";
			responseMessage+="身份证件号码："+result.getIdNo()+"\r\n";
			responseMessage+="认证结果为："+result.getAuthResult()+"\r\n";
			responseMessage+="图片：\r\n";
			responseMessage+="<img src=\"data:image/png;base64,"+result.getPhotos()+"\"/>";
			
		} 			

		log.info(responseMessage);
		response.setContentType("text/html;charset=UTF-8");
		response.getOutputStream().write(responseMessage.getBytes("UTF-8"));
		response.getOutputStream().flush();
	}
}
