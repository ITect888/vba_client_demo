package com.ect888.func262;

/**
 * 
 * 结果数据
 * 对应json
 * {
			"respcd": "56000",
			"birthday": "20190222",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611615230001",
			"status": "00",
			"validity": "20190222",
			"ptyacct": "ciasacct",
			"ptycd": "0000100000",
			"usernm": "证件上中文名",
			"passport": "341227198912173710"
		}
 * 
 * @author fanyj
 *
 */
public class Result262 {
	
	/**
	 * 订单流水号
	 */
	private String birthday;
	
	/**
	 * 订单流水号
	 */
	private String validity;
	
	/**
	 * 订单流水号
	 */
	private String usernm;
	
	/**
	 * 订单流水号
	 */
	private String passport;
	
	
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
	private String ptyacct;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getValidity() {
		return validity;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
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
