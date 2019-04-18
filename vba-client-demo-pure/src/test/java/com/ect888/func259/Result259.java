package com.ect888.func259;

/**
 * 
 * 结果数据
 * 对应json
 * {
			"respcd": "53000",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611705190001",
			"phoneProvCity": "上海",
			"status": "00",
			"ptyacct": "ciasacct",
			"phoneOperator": "移动",
			"ptycd": "0000100000",
			"usernm": "姓名",
			"phoneno": "15121016666"
		}
 * 
 * @author fanyj
 *
 */
public class Result259 {
	
	
	/**
	 * 姓名
	 */
	private String usernm;
	
	
	/**
	 * 手机号码
	 */
	private String phoneno;
	
	
	/**
	 * 运营商信息
	 */
	private String phoneOperator;
	
	
	/**
	 * 归属地信息
	 */
	private String phoneProvCity;
	
	
	
	/**
	 * 订单流水号
	 */
	private String sysseqnb;
	/**
	 * 业务应答码
	 */
	private String respcd;
	/**
	 * 业务应答信息
	 */
	private String respinfo;
	/**
	 * 保留字段
	 */
	private String status;
	/**
	 * 机构代码
	 */
	private String ptycd;
	/**
	 * 机构账号
	 */
	private String ptyacct;
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getPhoneOperator() {
		return phoneOperator;
	}
	public void setPhoneOperator(String phoneOperator) {
		this.phoneOperator = phoneOperator;
	}
	public String getPhoneProvCity() {
		return phoneProvCity;
	}
	public void setPhoneProvCity(String phoneProvCity) {
		this.phoneProvCity = phoneProvCity;
	}
	public String getSysseqnb() {
		return sysseqnb;
	}
	public void setSysseqnb(String sysseqnb) {
		this.sysseqnb = sysseqnb;
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
	public String getPtyacct() {
		return ptyacct;
	}
	public void setPtyacct(String ptyacct) {
		this.ptyacct = ptyacct;
	}		
	
}
