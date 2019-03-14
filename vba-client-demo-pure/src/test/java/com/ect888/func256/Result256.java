package com.ect888.func256;

/**
 *{
			"respcd": "51000",
			"respinfo": "比中失效身份证",
			"status": "00",
			"sysSeqNb": "19103520190313801524300001"
		}
 * 
 * @author fanyj
 *
 */
public class Result256 {
	
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
}