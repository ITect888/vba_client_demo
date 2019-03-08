package com.ect888.func209;

/**
 * 
 * {
			"localsim": "",
			"biztyp": "A001",
			"certseq": "341227198912173710",
			"accountName": "",
			"mpssim": "88.0",
			"telephone": "",
			"respinfo": "认证�?�?(通过)",
			"sysSeqNb": "19103520181012221215290001",
			"ptycd": "12500000",
			"facePicMPS": "",
			"name": "系统判断为同�?�?",
			"cerkey": "",
			"ptyAcct": "12500000",
			"respcd": "1000",
			"status": "00"
		}
 * 
 * @author fanyj
 *
 */
public class Result209 {
	
	/**
	 * 订单流水�?
	 */
	private String sysSeqNb;
	/**
	 * 业务应答�?
	 */
	private String respcd;
	/**
	 * 业务应答信息
	 */
	private String respinfo;
	/**
	 * 订单处理状�??
	 */
	private String status;
	/**
	 * 公安比对分�??
	 */
	private String mpssim;
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
	 * 预留字段
	 */
	private String certseq;
	/**
	 * 预留字段
	 */
	private String accountName;
	/**
	 * 预留字段
	 */
	private String telephone;
	/**
	 * 预留字段
	 */
	private String facePicMPS;
	/**
	 * 预留字段
	 */
	private String name;
	/**
	 * 预留字段
	 */
	private String cerkey;
	/**
	 * 预留字段
	 */
	private String localsim;
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
	public String getMpssim() {
		return mpssim;
	}
	public void setMpssim(String mpssim) {
		this.mpssim = mpssim;
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
	public String getCertseq() {
		return certseq;
	}
	public void setCertseq(String certseq) {
		this.certseq = certseq;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFacePicMPS() {
		return facePicMPS;
	}
	public void setFacePicMPS(String facePicMPS) {
		this.facePicMPS = facePicMPS;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCerkey() {
		return cerkey;
	}
	public void setCerkey(String cerkey) {
		this.cerkey = cerkey;
	}
	public String getLocalsim() {
		return localsim;
	}
	public void setLocalsim(String localsim) {
		this.localsim = localsim;
	}
}
