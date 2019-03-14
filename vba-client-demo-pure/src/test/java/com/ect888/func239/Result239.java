package com.ect888.func239;

/**
 * 
 * {
            "respinfo":"认证一致(通过)",
            "phoneProvCity":"",
            "status":"00",
            "phoneOperator":"移动",
            "biztyp":"A001",
            "respcd":"10000",
            "certseq":"341227198912173710",
            "resultdata":"0",
            "sysseqnb":"19103520190309801921280001",
            "name":"姓名",
            "ptyacct":"ect888_public_demo",
            "ptycd":"ect888_public",
            "phoneno":"15298386506"
        }
 * 
 * @author linyw
 *
 */
public class Result239 {
	
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
	 * 返回结果
	 */
	private String resultdata;
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
	 * 身份证号
	 */
	private String certseq;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 手机号所属地
	 */
	private String phoneProvCity;
	/**
	 * 手机运营商
	 */
	private String phoneOperator;
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
	public String getResultdata() {
		return resultdata;
	}
	public void setResultdata(String resultdata) {
		this.resultdata = resultdata;
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
	public String getPhoneProvCity() {
		return phoneProvCity;
	}
	public void setPhoneProvCity(String phoneProvCity) {
		this.phoneProvCity = phoneProvCity;
	}
	public String getPhoneOperator() {
		return phoneOperator;
	}
	public void setPhoneOperator(String phoneOperator) {
		this.phoneOperator = phoneOperator;
	}

}
