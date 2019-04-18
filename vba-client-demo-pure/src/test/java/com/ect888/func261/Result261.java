package com.ect888.func261;

/**
 * 
 * 结果数据
 * 对应json
 * {
		"platetype": "02",
		"carStatus": "G",
		"ptycd": "12500000",
		"ptyacct": "12500000",
		"respinfo": "查询成功-认证一致",
		"sysseqnb": "19103520190220221411550001",
		"respcd": "55000",
		"status": "00",
		"registerDate": "20161123"
	}
 * 
 * @author fanyj
 *
 */
public class Result261 {
	
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
	private String ptyacct;		
	
	/**
	 * 
	 * 号牌种类
	 * 
	 * 见接口文档数据字典'sheet'，认证一致才有值
	 */
	private String platetype;
	/**
	 * 
	 * 机动车状态
	 * 
	 * 见接口文档数据字典'sheet'，认证一致才有值
	 */
	private String carStatus;
	/**
	 * 
	 * 初次登记日期
	 * 
	 * 格式YYYYMMDD，认证一致才有值
	 */
	private String registerDate;
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
	public String getPtyacct() {
		return ptyacct;
	}
	public void setPtyacct(String ptyacct) {
		this.ptyacct = ptyacct;
	}
	public String getPlatetype() {
		return platetype;
	}
	public void setPlatetype(String platetype) {
		this.platetype = platetype;
	}
	public String getCarStatus() {
		return carStatus;
	}
	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	public String getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}
	
	
}
