package com.ect888.func302;

/**
 * 
 * 结果数据
 * 对应json
 * {
			"respcd": "53000",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611705190001",
			"status": "00",
			"ptyacct": "ciasacct",
			"ptycd": "0000100000",
			"usernm": "姓名",
			"phoneno": "15121016666"
		}
 * 
 * @author fanyj
 *
 */
public class Result302 {

	
	/**
	 * 手机号码
	 */
	private String phoneno;
	
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


	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
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
