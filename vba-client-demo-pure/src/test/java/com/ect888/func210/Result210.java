package com.ect888.func210;

/**
 * 
 * 结果数据
 * 对应json
 *{
			"respcd": "12000",
			"certseq": "",
			"cerkey": "",
			"accountname": "农业银行",
			"respinfo": "认证一致（通过）",
			"sysseqnb": "19103520190312611840110065",
			"status": "00",
			"name": "姓名",
			"ptyacct": "xikanglan",
			"ptycd": "xikanglan",
			"biztyp": "0541",
			"telephone": ""
 * @author fanyj
 *
 */
public class Result210 {
	
	
	/**
	 * 证件号码
	 */
	private String certseq;
	
	/**
	 * 姓名
	 */
	private String name;
	
	
	/**
	 * 手机号码
	 */
	private String telephone;
	
	
	/**
	 * 会话密钥
	 */
	private String cerkey;
	
	
	/**
	 * 发卡行
	 */
	private String accountname;
	
	
	
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
	
	public String getCertseq() {
		return certseq;
	}
	public void setCertseq(String certseq) {
		this.certseq = certseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCerkey() {
		return cerkey;
	}
	public void setCerkey(String cerkey) {
		this.cerkey = cerkey;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
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
