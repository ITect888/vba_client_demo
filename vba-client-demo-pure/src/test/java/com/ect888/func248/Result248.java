package com.ect888.func248;

/**
 * 
 * {
			"respcd": "48000",
			"certseq": "61030219910118512X",
			"cmpResult": "{\"resAddress\":\"省一致/市一致/县（区）一致\",\"resBirthday\":\"一致\",\"resCertSeq\":\"一致\",\"resCsdssx\":\"省一致/市不一致/县（区）不一致\",\"resCym\":\"\",\"resEducation\":\"一致\",\"resEthnicity\":\"一致\",\"resFwcs\":\"\",\"resJgssx\":\"省一致/市不一致/县（区）不一致\",\"resMarrige\":\"一致\",\"resName\":\"一致\",\"resSex\":\"一致\",\"resSsssxq\":\"\"}",
			"respinfo": "认证一致",
			"status": "00",
			"name": "姓名",
			"ptycd": "xikanglan",
			"ptyAcct": "xikanglan",
			"facePicMPS": "",
			"sysSeqNb": "19103520190313621654300001",
			"biztyp": "A001"
		}
 * 
 * @author fanyj
 *
 */
public class Result248 {
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
	 * 姓名
	 */
	private String name;
	
	/**
	 * 带水印照片
	 */
	private String facePicMPS;
	/**
	 * 比对结果详情
	 */
	private String cmpResult;
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFacePicMPS() {
		return facePicMPS;
	}
	public void setFacePicMPS(String facePicMPS) {
		this.facePicMPS = facePicMPS;
	}
	public String getCmpResult() {
		return cmpResult;
	}
	public void setCmpResult(String cmpResult) {
		this.cmpResult = cmpResult;
	}
	
}