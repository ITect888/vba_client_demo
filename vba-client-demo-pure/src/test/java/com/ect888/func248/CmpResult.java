package com.ect888.func248;

/**
 * 比对结果详情
 * {
	"resAddress": "省一致/市一致/县（区）一致",
	"resBirthday": "一致",
	"resCertSeq": "一致",
	"resCsdssx": "省一致/市不一致/县（区）不一致",
	"resCym": "",
	"resEducation": "一致",
	"resEthnicity": "一致",
	"resFwcs": "",
	"resJgssx": "省一致/市不一致/县（区）不一致",
	"resMarrige": "一致",
	"resName": "一致",
	"resSex": "一致",
	"resSsssxq": ""
	}
 * @author Wee
 *
 */
public class CmpResult {
	/**
	 * 身份证号认证结果
	 */
	private String resCertSeq;		
	/**
	 * 姓名认证结果
	 */
	private String resName;		
	/**
	 * 曾用名认证结果
	 */
	private String resCym;		
	/**
	 * 性别认证结果
	 */
	private String resSex;		
	/**
	 * 民族认证结果
	 */
	private String resEthnicity;		
	/**
	 * 出生日期认证结果
	 */
	private String resBirthday;		
	/**
	 * 文化程度认证结果
	 */
	private String resEducation;	
	/**
	 * 婚姻状况认证结果
	 */
	private String resMarrige;
	/**
	 * 服务处所认证结果
	 */
	private String resFwcs;
	/**
	 * 出生地省市县（区）认证结果
	 */
	private String resCsdssx;
	/**
	 * 籍贯省市县（区）认证结果
	 */
	private String resJgssx;
	/**
	 * 所属省市县（区）认证结果
	 */
	private String resSsssxq;
	/**
	 * 住址认证结果
	 */
	private String resAddress;
	
	public String getResCertSeq() {
		return resCertSeq;
	}
	public void setResCertSeq(String resCertSeq) {
		this.resCertSeq = resCertSeq;
	}
	public String getResName() {
		return resName;
	}
	public void setResName(String resName) {
		this.resName = resName;
	}
	public String getResCym() {
		return resCym;
	}
	public void setResCym(String resCym) {
		this.resCym = resCym;
	}
	public String getResSex() {
		return resSex;
	}
	public void setResSex(String resSex) {
		this.resSex = resSex;
	}
	public String getResEthnicity() {
		return resEthnicity;
	}
	public void setResEthnicity(String resEthnicity) {
		this.resEthnicity = resEthnicity;
	}
	public String getResBirthday() {
		return resBirthday;
	}
	public void setResBirthday(String resBirthday) {
		this.resBirthday = resBirthday;
	}
	public String getResEducation() {
		return resEducation;
	}
	public void setResEducation(String resEducation) {
		this.resEducation = resEducation;
	}
	public String getResMarrige() {
		return resMarrige;
	}
	public void setResMarrige(String resMarrige) {
		this.resMarrige = resMarrige;
	}
	public String getResFwcs() {
		return resFwcs;
	}
	public void setResFwcs(String resFwcs) {
		this.resFwcs = resFwcs;
	}
	public String getResCsdssx() {
		return resCsdssx;
	}
	public void setResCsdssx(String resCsdssx) {
		this.resCsdssx = resCsdssx;
	}
	public String getResJgssx() {
		return resJgssx;
	}
	public void setResJgssx(String resJgssx) {
		this.resJgssx = resJgssx;
	}
	public String getResSsssxq() {
		return resSsssxq;
	}
	public void setResSsssxq(String resSsssxq) {
		this.resSsssxq = resSsssxq;
	}
	public String getResAddress() {
		return resAddress;
	}
	public void setResAddress(String resAddress) {
		this.resAddress = resAddress;
	}
}
