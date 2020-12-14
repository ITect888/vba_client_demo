package com.ect888.func300;

/**
 * 
 * {
			"respinfo": "账户类型验证通过",
			"sysseqnb": "19103520190327221920340001",
			"respcd": "59000",
			"status": "00"
		}
 * 
 * @author fanyj
 *
 */
public class Result300 {
	
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
	 * 评分（一位数）
	 */
	private String score;

	/**
	 * 机构账号
	 */
	private String ptyacct;

	/**
	 * 机构号
	 */
	private String ptycd;

	/**
	 * 银行名称
	 */
	private String bankName;

	/**
	 * 手机号
	 */
	private String phoneno;

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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getPtyacct() {
		return ptyacct;
	}

	public void setPtyacct(String ptyacct) {
		this.ptyacct = ptyacct;
	}

	public String getPtycd() {
		return ptycd;
	}

	public void setPtycd(String ptycd) {
		this.ptycd = ptycd;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
}
