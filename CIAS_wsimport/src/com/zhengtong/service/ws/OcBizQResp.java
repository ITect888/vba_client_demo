
package com.zhengtong.service.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ocBizQResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ocBizQResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bizSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="branchOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="consistentSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="doubtSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="historicalSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inconsistentSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="juridicalOrgCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="noneSum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ocBizQResp", propOrder = {
    "bizSum",
    "branchOrgCode",
    "consistentSum",
    "doubtSum",
    "endDate",
    "historicalSum",
    "inconsistentSum",
    "juridicalOrgCode",
    "noneSum",
    "responseCode",
    "responseMessage",
    "startDate",
    "userId"
})
public class OcBizQResp {

    protected String bizSum;
    protected String branchOrgCode;
    protected String consistentSum;
    protected String doubtSum;
    protected String endDate;
    protected String historicalSum;
    protected String inconsistentSum;
    protected String juridicalOrgCode;
    protected String noneSum;
    protected String responseCode;
    protected String responseMessage;
    protected String startDate;
    protected String userId;

    /**
     * Gets the value of the bizSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBizSum() {
        return bizSum;
    }

    /**
     * Sets the value of the bizSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBizSum(String value) {
        this.bizSum = value;
    }

    /**
     * Gets the value of the branchOrgCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchOrgCode() {
        return branchOrgCode;
    }

    /**
     * Sets the value of the branchOrgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchOrgCode(String value) {
        this.branchOrgCode = value;
    }

    /**
     * Gets the value of the consistentSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConsistentSum() {
        return consistentSum;
    }

    /**
     * Sets the value of the consistentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConsistentSum(String value) {
        this.consistentSum = value;
    }

    /**
     * Gets the value of the doubtSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoubtSum() {
        return doubtSum;
    }

    /**
     * Sets the value of the doubtSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoubtSum(String value) {
        this.doubtSum = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the historicalSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHistoricalSum() {
        return historicalSum;
    }

    /**
     * Sets the value of the historicalSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHistoricalSum(String value) {
        this.historicalSum = value;
    }

    /**
     * Gets the value of the inconsistentSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInconsistentSum() {
        return inconsistentSum;
    }

    /**
     * Sets the value of the inconsistentSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInconsistentSum(String value) {
        this.inconsistentSum = value;
    }

    /**
     * Gets the value of the juridicalOrgCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJuridicalOrgCode() {
        return juridicalOrgCode;
    }

    /**
     * Sets the value of the juridicalOrgCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJuridicalOrgCode(String value) {
        this.juridicalOrgCode = value;
    }

    /**
     * Gets the value of the noneSum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoneSum() {
        return noneSum;
    }

    /**
     * Sets the value of the noneSum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoneSum(String value) {
        this.noneSum = value;
    }

    /**
     * Gets the value of the responseCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * Sets the value of the responseCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseCode(String value) {
        this.responseCode = value;
    }

    /**
     * Gets the value of the responseMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     * Sets the value of the responseMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponseMessage(String value) {
        this.responseMessage = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

}
