package com.ect888.func242;

/**
 * 
 * {
			"visit_frequency_day_level": "高",
			"respinfo": "查得",
			"status": "00",
			"addr": "a_家庭_f_12_i_11_l_true_v_高",
			"sysSeqNb": "19103520181108801700040001",
			"biztyp": "A001",
			"inactive_day": "11",
			"respcd": "42000",
			"certseq": "341227198912173710",
			"fre_location": "true",
			"name": "测试姓名",
			"addr_label": "家庭",
			"frequency_day": "12",
			"ptyAcct": "ect888_public_demo",
			"ptycd": "ect888_public",
			"phoneno": "15121016666"
		}
 * 
 * @author fanyj
 *
 */
public class Result242 {
	
	/**
	 * 订单流水号
	 * 
	 * 证通以流水号维度进行对账，若后续有对账需求，请留存此字段值
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
	 * 身份证号
	 */
	private String certseq;
	/**
	 * 手机号
	 */
	private String phoneno;
	
	/**
	 * 地址
	 */
	private String addr;
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 活跃天数
	 * 
	 * 活跃天数。匹配到的家庭地址的连续访问连续最大天数 
	 */
	private String frequency_day;
	
	/**
	 * 不活跃天数
	 * 
	 * 不活跃天数，匹配到的家庭地址最后一次访问距离查询日期的不活跃天数
	 */
	private String inactive_day;
	
	/**
	 * 是否是常访地址
	 * 
	 * 是否是常访地址，true  是；false  否。如果匹配到无标
签用户常访地，会返回访问频次；如果匹配到的用户家
庭或工作地址，会返回地址标签以及活跃度  
	 */
	private String fre_location;
	
	/**
	 * 常访地址类型
	 * 
	 * 常访地址类型：家庭、工作。如果与用户的家庭和
工作地址都不匹配，返回“”
	 */
	private String addr_label ;
	
	/**
	 * 访问频次
	 * 
	 * 访问频次，高、低  。如果未传参数或者用户没有到过这个地方，都会返回“”
	 */
	private String visit_frequency_day_level;

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

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFrequency_day() {
		return frequency_day;
	}

	public void setFrequency_day(String frequency_day) {
		this.frequency_day = frequency_day;
	}

	public String getInactive_day() {
		return inactive_day;
	}

	public void setInactive_day(String inactive_day) {
		this.inactive_day = inactive_day;
	}

	public String getFre_location() {
		return fre_location;
	}

	public void setFre_location(String fre_location) {
		this.fre_location = fre_location;
	}

	public String getAddr_label() {
		return addr_label;
	}

	public void setAddr_label(String addr_label) {
		this.addr_label = addr_label;
	}

	public String getVisit_frequency_day_level() {
		return visit_frequency_day_level;
	}

	public void setVisit_frequency_day_level(String visit_frequency_day_level) {
		this.visit_frequency_day_level = visit_frequency_day_level;
	}
}