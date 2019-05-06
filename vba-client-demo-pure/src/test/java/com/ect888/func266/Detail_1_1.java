package com.ect888.func266;

/**
 * 
 * 
 * 
 * @author fanyj
 *
 */
public class Detail_1_1 extends Detail_1{
	
	/**
	 * 姓名
	 * 对应入参有值则为入参，否则为OCR出的
	 */
	private String usernm;
	/**
	 * 身份号码
	 * 对应入参有值则为入参，否则为OCR出的
	 */
	private String certseq;
	public String getUsernm() {
		return usernm;
	}
	public void setUsernm(String usernm) {
		this.usernm = usernm;
	}
	public String getCertseq() {
		return certseq;
	}
	public void setCertseq(String certseq) {
		this.certseq = certseq;
	}
	
	

}
