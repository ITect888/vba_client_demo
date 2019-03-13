package com.ect888.func240;

/**
 * 
 * {
			"respinfo": "查得",
			"status": "00",
			"verify_result": "C",
			"addr": "c_高_f_11_i_2_m_WW_v_true_r_C",
			"sysSeqNb": "19103520181107801532480001",
			"biztyp": "A001",
			"confidence": "高",
			"inactive_day": "2",
			"respcd": "40000",
			"certseq": "341227198912173710",
			"validity": "true",
			"name": "测试姓名",
			"frequency_day": "11",
			"ptyAcct": "ect888_public_demo",
			"ptycd": "ect888_public",
			"phoneno": "15121016666"
		}
 * 
 * @author fanyj
 *
 */
/**
 * @author fanyj
 *
 */
public class Result240 {
	
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
	 * 地址有效性
	 * 
	 * 地址有效性，true  有效；false 无效；null  没有值 
	 */
	private String validity;
	
	/**
	 * 置信度等级
	 * 
	 * 置信度等级,>=80 分为高，>=60 为中，否则为低
	 */
	private String confidence;
	
	/**
	 * 距离等级
	 * 
	 * 距离等级，  A.5  公里内，B.20  公里内，C.50  公里内，D.50  公里外 
	 */
	private String verify_result;

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

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getConfidence() {
		return confidence;
	}

	public void setConfidence(String confidence) {
		this.confidence = confidence;
	}

	public String getVerify_result() {
		return verify_result;
	}

	public void setVerify_result(String verify_result) {
		this.verify_result = verify_result;
	}

}
