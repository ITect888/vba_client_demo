package com.ect888.func247;

/**
 * 
 *{
	"error_no": "0",
	"results": [{
			"respinfo": "交易异常",
			"status": "03",
			"cardNumberImage": "",
			"accountCard": "",
			"biztyp": "0",
			"sysSeqNb": "19103520190313621943230116",
			"cardType": "",
			"validate": "",
			"respcd": "47002",
			"accountName": "",
			"name": "",
			"ptycd": "xikanglan",
			"ptyAcct": "xikanglan"
		}
	],
	"dsName": ["results"],
	"error_info": ""
}
 * 
 * @author fanyj
 *
 */
public class Result247 {
	
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
	 * 银行卡切边照
	 */
	private String cardNumberImage;
	/**
	 * 银行卡类型
	 */
	private String cardType;
	/**
	 * 持卡人姓名（限信用卡）
	 */
	private String name;
	/**
	 * 信用卡上的有效期识别结果
	 */
	private String validate;
	/**
	 * 银行卡号
	 */
	private String accountCard;
	/**
	 * 发卡机构
	 */
	private String accountName;
	
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

	public String getCardNumberImage() {
		return cardNumberImage;
	}

	public void setCardNumberImage(String cardNumberImage) {
		this.cardNumberImage = cardNumberImage;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getValidate() {
		return validate;
	}

	public void setValidate(String validate) {
		this.validate = validate;
	}

	public String getAccountCard() {
		return accountCard;
	}

	public void setAccountCard(String accountCard) {
		this.accountCard = accountCard;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}