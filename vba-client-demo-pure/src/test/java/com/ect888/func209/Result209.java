package com.ect888.func209;

/**
 * 
 * {
            "cerkey":"",
            "respinfo":"认证一致(通过)",
            "status":"00",
            "mpssim":"0.0",
            "biztyp":"A001",
            "sysSeqNb":"19103520190308802006580001",
            "respcd":"5000",
            "certseq":"341227198912173710",
            "accountName":"",
            "name":"姓名",
            "ptyAcct":"ect888_public_demo",
            "ptycd":"ect888_public",
            "localsim":"",
            "telephone":""
        }
 * 
 * @author linyw
 *
 */
public class Result209 {
	
	/**
	 * 订单流水号
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
	 * 比对分值
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
