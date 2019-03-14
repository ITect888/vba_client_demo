package com.ect888.func202;

/**
 * 
 * {
			"birthday": "1974年3月24日",
			"certseq": "610104197403243450",
			"sex": "男",
			"issue": "西安市公安局莲湖分局",
			"addr": "西安市莲湖区工农路22号9号楼46号",
			"usernm": "申方敏",
			"expirydate": "2014.10.08-2034.10.08",
			"nation": ""
		}
 * 
 * @author linyw
 *
 */
public class Result202 {
	
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 身份证号
	 */
	private String certseq;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 签发机关
	 */
	private String issue;		
	/**
	 * 住址
	 */
	private String addr;
	
	/**
	 * 姓名
	 */
	private String usernm;
	/**
	 * 有效期限
	 */
	private String expirydate;
	/**
	 * 民族
	 */
	private String nation;
	/**
	 * 身份证正面切边照
	 */
	private String cerfront;
	/**
	 * 身份证反面切边照
	 */
	private String certnegative;
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCertseq() {
		return certseq;
	}
	public void setCertseq(String certseq) {
		this.certseq = certseq;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getExpirydate() {
		return expirydate;
	}
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getCerfront() {
		return cerfront;
	}
	public void setCerfront(String cerfront) {
		this.cerfront = cerfront;
	}
	public String getCertnegative() {
		return certnegative;
	}
	public void setCertnegative(String certnegative) {
		this.certnegative = certnegative;
	}
	
}
