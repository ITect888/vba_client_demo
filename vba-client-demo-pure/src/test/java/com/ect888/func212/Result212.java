package com.ect888.func212;

/**
 * 
 {
			"iscriminal": "",
			"caseType": "",
			"caseTime": "",
			"respinfo": "查询失败",
			"status": "03",
			"biztyp": "A001",
			"provinceNo": "",
			"respcd": "8001",
			"certseq": "422823199107192312",
			"sysseqnb": "19103520190312611501310083",
			"name": "张三",
			"newestDate": "",
			"badCnt": "",
			"ptyacct": "xikanglan",
			"ptycd": "xikanglan"
		}
 * 
 * @author fanyj
 *
 */
public class Result212 {
	
	/**
	 * 订单流水号
	 */
	private String sysseqnb;
	/**
	 * 业务类型
	 */
	private String biztyp;
	/**
	 * 订单处理状态
	 */
	private String status;
	/**
	 * 业务应答码
	 */
	private String respcd;
	/**
	 * 业务应答信息
	 */
	private String respinfo;
	
	/**
	 * 机构代码
	 */
	private String ptycd;
	/**
	 * 机构账号
	 */
	private String ptyacct;		
	/**
	 * 不良状态
	 */
	private String iscriminal;
	/**
	 * 前科事件数量
	 */
	private String badCnt;
	/**
	 * 最近一次前科事件时间段
	 */
	private String caseTime;
	/**
	 * 最近一次前科事件类别
	 */
	private String caseType;
	/**
	 * 最近一次不良时间
	 */
	private String newestDate;
	/**
	 * 省份
	 */
	private String provinceNo;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 身份证
	 */
	private String certseq;
	
	public String getSysseqnb() {
		return sysseqnb;
	}
	public void setSysseqnb(String sysseqnb) {
		this.sysseqnb = sysseqnb;
	}
	public String getBiztyp() {
		return biztyp;
	}
	public void setBiztyp(String biztyp) {
		this.biztyp = biztyp;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
	public String getIscriminal() {
		return iscriminal;
	}
	public void setIscriminal(String iscriminal) {
		this.iscriminal = iscriminal;
	}
	public String getBadCnt() {
		return badCnt;
	}
	public void setBadCnt(String badCnt) {
		this.badCnt = badCnt;
	}
	public String getCaseTime() {
		return caseTime;
	}
	public void setCaseTime(String caseTime) {
		this.caseTime = caseTime;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getNewestDate() {
		return newestDate;
	}
	public void setNewestDate(String newestDate) {
		this.newestDate = newestDate;
	}
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertseq() {
		return certseq;
	}
	public void setCertseq(String certseq) {
		this.certseq = certseq;
	}
}
