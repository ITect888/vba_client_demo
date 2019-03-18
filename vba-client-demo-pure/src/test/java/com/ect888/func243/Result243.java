package com.ect888.func243;

/**
 * 
 *{
			"respcd": "43000",
			"respinfo": "识别成功",
			"status": "00",
			"name": "范燕军",
			"ptycd": "0000100000",
			"ptyAcct": "ciasacct",
			"res1": "{\"respCode\":\"4300000\",\"label\":[{\"position\":\"458,829,554,829,548,1292,453,1290\",\"item\":{\"address\":\"中国上海市浦东新区 新金桥路27号1 号楼, 201206\",\"type\":[\"work\"]}}],\"url\":[{\"position\":\"301,463,331,463,327,758,298,758\",\"item\":\"www.ect888.com\"}],\"respInfo\":\"名片OCR单面提取成功\",\"rotation_angle\":\"90\",\"organization\":[{\"position\":\"805,1063,842,1063,837,1299,800,1298\",\"item\":{\"unit\":\"征信认证事业部\"}},{\"position\":\"576,944,618,944,612,1295,571,1294\",\"item\":{\"name\":\"证通股份有限公司\"}},{\"position\":\"300,156,326,156,324,315,298,315\",\"item\":{\"name\":\"证通官方网站\"}}],\"title\":[{\"position\":\"761,1166,796,1167,794,1298,758,1297\",\"item\":\"产品经理\"}],\"formatted_name\":[{\"position\":\"861,1122,919,1123,915,1299,857,1298\",\"item\":\"范燕军\"}],\"address\":[{\"position\":\"458,829,554,829,548,1292,453,1290\",\"item\":{\"street\":\"浦东新区 新金桥路27号1 号楼\",\"postal_code\":\"201206\",\"locality\":\"上海市\",\"type\":[\"work\"],\"country\":\"中国\"}}],\"email\":[{\"position\":\"358,582,391,582,386,918,354,918\",\"item\":\"fanyj@ect888.com\"}],\"name\":[{\"position\":\"1124,-80,1124,-80,1124,-80,1124,-80\",\"item\":{\"family_name\":\"范\",\"given_name\":\"燕军\"}}],\"origin_postcode\":[{\"position\":\"460,829,503,829,501,967,458,966\",\"item\":\"201206\"}],\"telephone\":[{\"position\":\"410,571,439,571,434,919,405,919\",\"item\":{\"number\":\"+8615121016002\",\"type\":[\"cellular\",\"voice\"]}},{\"position\":\"407,968,437,968,432,1290,403,1289\",\"item\":{\"number\":\"+8602120530182\",\"type\":[\"work\",\"voice\"]}},{\"position\":\"299,826,337,826,331,1284,294,1284\",\"item\":{\"number\":\"+8602120538888\",\"type\":[\"work\",\"voice\"]}},{\"position\":\"358,969,389,969,385,1288,354,1287\",\"item\":{\"number\":\"+8602120538999\",\"type\":[\"work\",\"facsimile\"]}}],\"origin_address\":[{\"position\":\"458,957,554,958,548,1292,453,1290\",\"item\":\"中国上海市浦东新区 新金桥路27号1 号楼\"}]}",
			"sysSeqNb": "19103520190318611036450001",
			"biztyp": "0",
			"phoneno": "15121016002"
		}
 * 
 * @author fanyj
 *
 */
public class Result243 {
	
	/**
	 * 订单流水号
	 * 
	 * 证通以流水号维度进行对账，若后续有对账需求，请留存此字段值
	 */
	private String sysSeqNb;
	/**
	 * 业务应答码
	 */
	private String respcd;
	/**
	 * 业务应答信息
	 */
	private String respinfo;
	/**
	 * 订单处理状态
	 */
	private String status;
	/**
	 * 机构代码
	 */
	private String ptycd;
	/**
	 * 机构账号
	 */
	private String ptyAcct;		
	/**
	 * 业务类型
	 */
	private String biztyp;
	
	/**
	 * 手机号
	 */
	private String phoneno;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * res
	 */
	private String res1;
	
	public String getRes1() {
		return res1;
	}

	public void setRes1(String res1) {
		this.res1 = res1;
	}

	public String getSysSeqNb() {
		return sysSeqNb;
	}

	public void setSysSeqNb(String sysSeqNb) {
		this.sysSeqNb = sysSeqNb;
	}

	public String getRespcd() {
		return respcd;
	}

	public void setRespcd(String respcd) {
		this.respcd = respcd;
	}

	public String getRespinfo() {
		return respinfo;
	}

	public void setRespinfo(String respinfo) {
		this.respinfo = respinfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPtycd() {
		return ptycd;
	}

	public void setPtycd(String ptycd) {
		this.ptycd = ptycd;
	}

	public String getPtyAcct() {
		return ptyAcct;
	}

	public void setPtyAcct(String ptyAcct) {
		this.ptyAcct = ptyAcct;
	}

	public String getBiztyp() {
		return biztyp;
	}

	public void setBiztyp(String biztyp) {
		this.biztyp = biztyp;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}