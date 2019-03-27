/**
 * OcBizQ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zhengtong.service.ws;

public class OcBizQ  implements java.io.Serializable {
    private java.lang.String branchOrgCode;

    private java.lang.String endDate;

    private java.lang.String juridicalOrgCode;

    private java.lang.String licenseKey;

    private java.lang.String requestDate;

    private java.lang.String requestTime;

    private java.lang.String startDate;

    private java.lang.String userId;

    public OcBizQ() {
    }

    public OcBizQ(
           java.lang.String branchOrgCode,
           java.lang.String endDate,
           java.lang.String juridicalOrgCode,
           java.lang.String licenseKey,
           java.lang.String requestDate,
           java.lang.String requestTime,
           java.lang.String startDate,
           java.lang.String userId) {
           this.branchOrgCode = branchOrgCode;
           this.endDate = endDate;
           this.juridicalOrgCode = juridicalOrgCode;
           this.licenseKey = licenseKey;
           this.requestDate = requestDate;
           this.requestTime = requestTime;
           this.startDate = startDate;
           this.userId = userId;
    }


    /**
     * Gets the branchOrgCode value for this OcBizQ.
     * 
     * @return branchOrgCode
     */
    public java.lang.String getBranchOrgCode() {
        return branchOrgCode;
    }


    /**
     * Sets the branchOrgCode value for this OcBizQ.
     * 
     * @param branchOrgCode
     */
    public void setBranchOrgCode(java.lang.String branchOrgCode) {
        this.branchOrgCode = branchOrgCode;
    }


    /**
     * Gets the endDate value for this OcBizQ.
     * 
     * @return endDate
     */
    public java.lang.String getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this OcBizQ.
     * 
     * @param endDate
     */
    public void setEndDate(java.lang.String endDate) {
        this.endDate = endDate;
    }


    /**
     * Gets the juridicalOrgCode value for this OcBizQ.
     * 
     * @return juridicalOrgCode
     */
    public java.lang.String getJuridicalOrgCode() {
        return juridicalOrgCode;
    }


    /**
     * Sets the juridicalOrgCode value for this OcBizQ.
     * 
     * @param juridicalOrgCode
     */
    public void setJuridicalOrgCode(java.lang.String juridicalOrgCode) {
        this.juridicalOrgCode = juridicalOrgCode;
    }


    /**
     * Gets the licenseKey value for this OcBizQ.
     * 
     * @return licenseKey
     */
    public java.lang.String getLicenseKey() {
        return licenseKey;
    }


    /**
     * Sets the licenseKey value for this OcBizQ.
     * 
     * @param licenseKey
     */
    public void setLicenseKey(java.lang.String licenseKey) {
        this.licenseKey = licenseKey;
    }


    /**
     * Gets the requestDate value for this OcBizQ.
     * 
     * @return requestDate
     */
    public java.lang.String getRequestDate() {
        return requestDate;
    }


    /**
     * Sets the requestDate value for this OcBizQ.
     * 
     * @param requestDate
     */
    public void setRequestDate(java.lang.String requestDate) {
        this.requestDate = requestDate;
    }


    /**
     * Gets the requestTime value for this OcBizQ.
     * 
     * @return requestTime
     */
    public java.lang.String getRequestTime() {
        return requestTime;
    }


    /**
     * Sets the requestTime value for this OcBizQ.
     * 
     * @param requestTime
     */
    public void setRequestTime(java.lang.String requestTime) {
        this.requestTime = requestTime;
    }


    /**
     * Gets the startDate value for this OcBizQ.
     * 
     * @return startDate
     */
    public java.lang.String getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this OcBizQ.
     * 
     * @param startDate
     */
    public void setStartDate(java.lang.String startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the userId value for this OcBizQ.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this OcBizQ.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OcBizQ)) return false;
        OcBizQ other = (OcBizQ) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.branchOrgCode==null && other.getBranchOrgCode()==null) || 
             (this.branchOrgCode!=null &&
              this.branchOrgCode.equals(other.getBranchOrgCode()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate()))) &&
            ((this.juridicalOrgCode==null && other.getJuridicalOrgCode()==null) || 
             (this.juridicalOrgCode!=null &&
              this.juridicalOrgCode.equals(other.getJuridicalOrgCode()))) &&
            ((this.licenseKey==null && other.getLicenseKey()==null) || 
             (this.licenseKey!=null &&
              this.licenseKey.equals(other.getLicenseKey()))) &&
            ((this.requestDate==null && other.getRequestDate()==null) || 
             (this.requestDate!=null &&
              this.requestDate.equals(other.getRequestDate()))) &&
            ((this.requestTime==null && other.getRequestTime()==null) || 
             (this.requestTime!=null &&
              this.requestTime.equals(other.getRequestTime()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBranchOrgCode() != null) {
            _hashCode += getBranchOrgCode().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        if (getJuridicalOrgCode() != null) {
            _hashCode += getJuridicalOrgCode().hashCode();
        }
        if (getLicenseKey() != null) {
            _hashCode += getLicenseKey().hashCode();
        }
        if (getRequestDate() != null) {
            _hashCode += getRequestDate().hashCode();
        }
        if (getRequestTime() != null) {
            _hashCode += getRequestTime().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OcBizQ.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.service.zhengtong.com/", "ocBizQ"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("branchOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "branchOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("juridicalOrgCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "juridicalOrgCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("licenseKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "licenseKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "requestTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "userId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
