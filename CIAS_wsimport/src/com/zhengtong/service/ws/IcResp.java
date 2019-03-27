
package com.zhengtong.service.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for icResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="icResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="authResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="custUsedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="eduLevel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idAddr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="maritalStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="photos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reservedFd1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reservedFd2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reservedFd3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reservedFd4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reservedFd5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="responseMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="serialNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicePlace" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "icResp", propOrder = {
    "authResult",
    "birthDate",
    "custUsedName",
    "customerName",
    "eduLevel",
    "gender",
    "idAddr",
    "idNo",
    "maritalStatus",
    "nation",
    "photos",
    "reservedFd1",
    "reservedFd2",
    "reservedFd3",
    "reservedFd4",
    "reservedFd5",
    "responseCode",
    "responseMessage",
    "serialNo",
    "servicePlace"
})
public class IcResp {

    protected String authResult;
    protected String birthDate;
    protected String custUsedName;
    protected String customerName;
    protected String eduLevel;
    protected String gender;
    protected String idAddr;
    protected String idNo;
    protected String maritalStatus;
    protected String nation;
    protected String photos;
    protected String serialNo;
    protected String responseCode;
    protected String responseMessage;
    protected String reservedFd1;
    protected String reservedFd2;
    protected String reservedFd3;
    protected String reservedFd4;
    protected String reservedFd5;

    
    protected String servicePlace;

    /**
     * Gets the value of the authResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthResult() {
        return authResult;
    }

    /**
     * Sets the value of the authResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthResult(String value) {
        this.authResult = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the custUsedName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustUsedName() {
        return custUsedName;
    }

    /**
     * Sets the value of the custUsedName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustUsedName(String value) {
        this.custUsedName = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the eduLevel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEduLevel() {
        return eduLevel;
    }

    /**
     * Sets the value of the eduLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEduLevel(String value) {
        this.eduLevel = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGender(String value) {
        this.gender = value;
    }

    /**
     * Gets the value of the idAddr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAddr() {
        return idAddr;
    }

    /**
     * Sets the value of the idAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAddr(String value) {
        this.idAddr = value;
    }

    /**
     * Gets the value of the idNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdNo() {
        return idNo;
    }

    /**
     * Sets the value of the idNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdNo(String value) {
        this.idNo = value;
    }

    /**
     * Gets the value of the maritalStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * Sets the value of the maritalStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaritalStatus(String value) {
        this.maritalStatus = value;
    }

    /**
     * Gets the value of the nation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNation() {
        return nation;
    }

    /**
     * Sets the value of the nation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNation(String value) {
        this.nation = value;
    }

    /**
     * Gets the value of the photos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhotos() {
        return photos;
    }

    /**
     * Sets the value of the photos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhotos(String value) {
        this.photos = value;
    }

    /**
     * Gets the value of the reservedFd1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedFd1() {
        return reservedFd1;
    }

    /**
     * Sets the value of the reservedFd1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedFd1(String value) {
        this.reservedFd1 = value;
    }

    /**
     * Gets the value of the reservedFd2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedFd2() {
        return reservedFd2;
    }

    /**
     * Sets the value of the reservedFd2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedFd2(String value) {
        this.reservedFd2 = value;
    }

    /**
     * Gets the value of the reservedFd3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedFd3() {
        return reservedFd3;
    }

    /**
     * Sets the value of the reservedFd3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedFd3(String value) {
        this.reservedFd3 = value;
    }

    /**
     * Gets the value of the reservedFd4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedFd4() {
        return reservedFd4;
    }

    /**
     * Sets the value of the reservedFd4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedFd4(String value) {
        this.reservedFd4 = value;
    }

    /**
     * Gets the value of the reservedFd5 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReservedFd5() {
        return reservedFd5;
    }

    /**
     * Sets the value of the reservedFd5 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReservedFd5(String value) {
        this.reservedFd5 = value;
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
     * Gets the value of the serialNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialNo() {
        return serialNo;
    }

    /**
     * Sets the value of the serialNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialNo(String value) {
        this.serialNo = value;
    }

    /**
     * Gets the value of the servicePlace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServicePlace() {
        return servicePlace;
    }

    /**
     * Sets the value of the servicePlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServicePlace(String value) {
        this.servicePlace = value;
    }

}
