package com.ect888.func224;

/**
 * 
	{
			"biztyp": "A001",
			"ptycd": "linyw",
			"ptyacct": "linyw",
			"respinfo": "认证不一致(不通过):身份证号:一致,姓名:一致,档案编号:不一致",
			"sysseqnb": "19103520190626220939200001",
			"respcd": "24001",
			"status": "00"
		}
 * 
 * @author linyw
 *
 */
public class Result224 {
	
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
	private String ptyAcct;		
	/**
	 * 业务类型
	 */
	private String biztyp;
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
}
