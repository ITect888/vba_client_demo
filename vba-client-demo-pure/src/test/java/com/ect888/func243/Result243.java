package com.ect888.func243;

/**
 * 
 *{
			"respcd": "43000",
			"respinfo": "识别成功",
			"status": "00",
			"name": "姓名",
			"ptycd": "xikanglan",
			"ptyAcct": "xikanglan",
			"res1": "{\"respCode\":\"4300000\",\"label\":[{\"position\":\"424,1193,520,1194,515,1774,421,1775\",\"item\":{\"address\":\"中国上海浦东新区锦康路308号 陆家嘴世纪金融广场 6号楼, 200127\",\"type\":[\"work\"]}}],\"url\":[{\"position\":\"240,1786,240,1786,240,1786,240,1786\",\"item\":\"http://www.ect888.com\"}],\"respInfo\":\"名片OCR单面提取成功\",\"rotation_angle\":\"90\",\"organization\":[{\"position\":\"769,1532,804,1532,800,1767,766,1768\",\"item\":{\"unit\":\"征信认证事业部\"}},{\"position\":\"542,1420,584,1420,580,1774,539,1774\",\"item\":{\"name\":\"证通股份有限公司\"}},{\"position\":\"247,604,277,605,277,776,247,775\",\"item\":{\"name\":\"证通官方网站\"}}],\"title\":[{\"position\":\"728,1602,762,1602,759,1768,726,1768\",\"item\":\"研发工程师\"}],\"formatted_name\":[{\"position\":\"824,1619,882,1618,879,1761,822,1762\",\"item\":\"姓名\"}],\"address\":[{\"position\":\"424,1193,520,1194,515,1774,421,1775\",\"item\":{\"street\":\"浦东新区锦康路308号 陆家嘴世纪金融广场 6号楼\",\"postal_code\":\"200127\",\"locality\":\"上海\",\"type\":[\"work\"],\"country\":\"中国\"}}],\"email\":[{\"position\":\"316,983,352,983,351,1399,315,1399\",\"item\":\"zhangwei@ec1888.com\"}],\"name\":[{\"position\":\"1082,404,1082,404,1082,404,1082,404\",\"item\":{\"family_name\":\"姓\",\"given_name\":\"名\"}}],\"origin_postcode\":[{\"position\":\"424,1193,464,1194,463,1333,424,1332\",\"item\":\"200127\"}],\"telephone\":[{\"position\":\"371,1045,398,1046,397,1399,370,1399\",\"item\":{\"number\":\"+8618616280052\",\"type\":[\"cellular\",\"voice\"]}},{\"position\":\"370,1454,397,1454,396,1777,369,1777\",\"item\":{\"number\":\"+8602120530141\",\"type\":[\"work\",\"voice\"]}},{\"position\":\"256,1308,293,1308,293,1777,256,1777\",\"item\":{\"number\":\"+8602120538888\",\"type\":[\"work\",\"voice\"]}},{\"position\":\"320,1452,350,1452,349,1775,319,1776\",\"item\":{\"number\":\"+8602120538999\",\"type\":[\"work\",\"facsimile\"]}}],\"origin_address\":[{\"position\":\"424,1252,520,1253,515,1774,421,1775\",\"item\":\"中国上海浦东新区锦康路308号 陆家嘴世纪金融广场 6号楼\"}]}",
			"sysSeqNb": "19103520190313621823560019",
			"biztyp": "0541",
			"phoneno": "18616280052"
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