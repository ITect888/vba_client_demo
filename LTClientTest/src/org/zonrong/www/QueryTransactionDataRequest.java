/**
 * QueryTransactionDataRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class QueryTransactionDataRequest  extends org.zonrong.www.PagedRequest  implements java.io.Serializable {
    private java.lang.String orgId;

    private java.lang.String orgName;

    private java.lang.String secuId;

    private java.lang.String custId;

    private java.lang.String name;

    private java.lang.String identityCardNumber;

    private java.lang.String transactionSummary;

    private java.lang.String dateStart;

    private java.lang.String dateEnd;

    private java.lang.String result;

    public QueryTransactionDataRequest() {
    }

    public QueryTransactionDataRequest(
           int startIndex,
           int endIndex,
           java.lang.String orgId,
           java.lang.String orgName,
           java.lang.String secuId,
           java.lang.String custId,
           java.lang.String name,
           java.lang.String identityCardNumber,
           java.lang.String transactionSummary,
           java.lang.String dateStart,
           java.lang.String dateEnd,
           java.lang.String result) {
        super(
            startIndex,
            endIndex);
        this.orgId = orgId;
        this.orgName = orgName;
        this.secuId = secuId;
        this.custId = custId;
        this.name = name;
        this.identityCardNumber = identityCardNumber;
        this.transactionSummary = transactionSummary;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.result = result;
    }


    /**
     * Gets the orgId value for this QueryTransactionDataRequest.
     * 
     * @return orgId
     */
    public java.lang.String getOrgId() {
        return orgId;
    }


    /**
     * Sets the orgId value for this QueryTransactionDataRequest.
     * 
     * @param orgId
     */
    public void setOrgId(java.lang.String orgId) {
        this.orgId = orgId;
    }


    /**
     * Gets the orgName value for this QueryTransactionDataRequest.
     * 
     * @return orgName
     */
    public java.lang.String getOrgName() {
        return orgName;
    }


    /**
     * Sets the orgName value for this QueryTransactionDataRequest.
     * 
     * @param orgName
     */
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }


    /**
     * Gets the secuId value for this QueryTransactionDataRequest.
     * 
     * @return secuId
     */
    public java.lang.String getSecuId() {
        return secuId;
    }


    /**
     * Sets the secuId value for this QueryTransactionDataRequest.
     * 
     * @param secuId
     */
    public void setSecuId(java.lang.String secuId) {
        this.secuId = secuId;
    }


    /**
     * Gets the custId value for this QueryTransactionDataRequest.
     * 
     * @return custId
     */
    public java.lang.String getCustId() {
        return custId;
    }


    /**
     * Sets the custId value for this QueryTransactionDataRequest.
     * 
     * @param custId
     */
    public void setCustId(java.lang.String custId) {
        this.custId = custId;
    }


    /**
     * Gets the name value for this QueryTransactionDataRequest.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this QueryTransactionDataRequest.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the identityCardNumber value for this QueryTransactionDataRequest.
     * 
     * @return identityCardNumber
     */
    public java.lang.String getIdentityCardNumber() {
        return identityCardNumber;
    }


    /**
     * Sets the identityCardNumber value for this QueryTransactionDataRequest.
     * 
     * @param identityCardNumber
     */
    public void setIdentityCardNumber(java.lang.String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }


    /**
     * Gets the transactionSummary value for this QueryTransactionDataRequest.
     * 
     * @return transactionSummary
     */
    public java.lang.String getTransactionSummary() {
        return transactionSummary;
    }


    /**
     * Sets the transactionSummary value for this QueryTransactionDataRequest.
     * 
     * @param transactionSummary
     */
    public void setTransactionSummary(java.lang.String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }


    /**
     * Gets the dateStart value for this QueryTransactionDataRequest.
     * 
     * @return dateStart
     */
    public java.lang.String getDateStart() {
        return dateStart;
    }


    /**
     * Sets the dateStart value for this QueryTransactionDataRequest.
     * 
     * @param dateStart
     */
    public void setDateStart(java.lang.String dateStart) {
        this.dateStart = dateStart;
    }


    /**
     * Gets the dateEnd value for this QueryTransactionDataRequest.
     * 
     * @return dateEnd
     */
    public java.lang.String getDateEnd() {
        return dateEnd;
    }


    /**
     * Sets the dateEnd value for this QueryTransactionDataRequest.
     * 
     * @param dateEnd
     */
    public void setDateEnd(java.lang.String dateEnd) {
        this.dateEnd = dateEnd;
    }


    /**
     * Gets the result value for this QueryTransactionDataRequest.
     * 
     * @return result
     */
    public java.lang.String getResult() {
        return result;
    }


    /**
     * Sets the result value for this QueryTransactionDataRequest.
     * 
     * @param result
     */
    public void setResult(java.lang.String result) {
        this.result = result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryTransactionDataRequest)) return false;
        QueryTransactionDataRequest other = (QueryTransactionDataRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.orgId==null && other.getOrgId()==null) || 
             (this.orgId!=null &&
              this.orgId.equals(other.getOrgId()))) &&
            ((this.orgName==null && other.getOrgName()==null) || 
             (this.orgName!=null &&
              this.orgName.equals(other.getOrgName()))) &&
            ((this.secuId==null && other.getSecuId()==null) || 
             (this.secuId!=null &&
              this.secuId.equals(other.getSecuId()))) &&
            ((this.custId==null && other.getCustId()==null) || 
             (this.custId!=null &&
              this.custId.equals(other.getCustId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.identityCardNumber==null && other.getIdentityCardNumber()==null) || 
             (this.identityCardNumber!=null &&
              this.identityCardNumber.equals(other.getIdentityCardNumber()))) &&
            ((this.transactionSummary==null && other.getTransactionSummary()==null) || 
             (this.transactionSummary!=null &&
              this.transactionSummary.equals(other.getTransactionSummary()))) &&
            ((this.dateStart==null && other.getDateStart()==null) || 
             (this.dateStart!=null &&
              this.dateStart.equals(other.getDateStart()))) &&
            ((this.dateEnd==null && other.getDateEnd()==null) || 
             (this.dateEnd!=null &&
              this.dateEnd.equals(other.getDateEnd()))) &&
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getOrgId() != null) {
            _hashCode += getOrgId().hashCode();
        }
        if (getOrgName() != null) {
            _hashCode += getOrgName().hashCode();
        }
        if (getSecuId() != null) {
            _hashCode += getSecuId().hashCode();
        }
        if (getCustId() != null) {
            _hashCode += getCustId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getIdentityCardNumber() != null) {
            _hashCode += getIdentityCardNumber().hashCode();
        }
        if (getTransactionSummary() != null) {
            _hashCode += getTransactionSummary().hashCode();
        }
        if (getDateStart() != null) {
            _hashCode += getDateStart().hashCode();
        }
        if (getDateEnd() != null) {
            _hashCode += getDateEnd().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryTransactionDataRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "QueryTransactionDataRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OrgId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OrgName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("secuId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "SecuId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("custId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "CustId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identityCardNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentityCardNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transactionSummary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "TransactionSummary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "DateStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateEnd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "DateEnd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Result"));
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
