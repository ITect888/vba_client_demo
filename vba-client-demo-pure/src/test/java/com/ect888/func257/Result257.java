package com.ect888.func257;

/**
 * 
 * 结果数据
 * 对应json
 * {
			"respcd": "52000",
			"certseq": "341227198912173710",
			"respinfo": "认证一致(通过)",
			"sysseqnb": "19103520190307611530150001",
			"status": "00",
			"validto": "20380327",
			"ptyacct": "ciasacct",
			"ptycd": "0000100000",
			"usernm": "姓名",
			"validfrom": "20180327"
		}
 * 
 * @author fanyj
 *
 */
public class Result257 {
	
	/**
	 * 有效期起始日期
	 */
	private String validfrom;
	
	/**
	 * 有效期截止日期
	 */
	private String validto;
	
	/**
	 * 证件号码
	 */
	private String certseq;
	
	/**
	 * 姓名
	 */
	private String usernm;
	
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
	public String getValidfrom() {
		return validfrom;
	}
	public void setValidfrom(String validfrom) {
		this.validfrom = validfrom;
	}
	public String getValidto() {
		return validto;
	}
	public void setValidto(String validto) {
		this.validto = validto;
	}
	public String getCertseq() {
		return certseq;
	}
	public void setCertseq(String certseq) {
		this.certseq = certseq;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
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
