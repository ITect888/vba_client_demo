/**
 * TransactionData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class TransactionData  implements java.io.Serializable {
    private java.lang.String orgId;

    private java.lang.String orgName;

    private java.lang.String secuId;

    private java.lang.String custId;

    private java.lang.String name;

    private java.lang.String identityCardNumber;

    private java.lang.String transactionSummary;

    private java.lang.String transactionTime;

    private java.lang.String operationTime;

    private java.lang.String result;

    private java.lang.String ext1;

    private java.lang.String ext2;

    public TransactionData() {
    }

    public TransactionData(
           java.lang.String orgId,
           java.lang.String orgName,
           java.lang.String secuId,
           java.lang.String custId,
           java.lang.String name,
           java.lang.String identityCardNumber,
           java.lang.String transactionSummary,
           java.lang.String transactionTime,
           java.lang.String operationTime,
           java.lang.String result,
           java.lang.String ext1,
           java.lang.String ext2) {
           this.orgId = orgId;
           this.orgName = orgName;
           this.secuId = secuId;
           this.custId = custId;
           this.name = name;
           this.identityCardNumber = identityCardNumber;
           this.transactionSummary = transactionSummary;
           this.transactionTime = transactionTime;
           this.operationTime = operationTime;
           this.result = result;
           this.ext1 = ext1;
           this.ext2 = ext2;
    }


    /**
     * Gets the orgId value for this TransactionData.
     * 
     * @return orgId
     */
    public java.lang.String getOrgId() {
        return orgId;
    }


    /**
     * Sets the orgId value for this TransactionData.
     * 
     * @param orgId
     */
    public void setOrgId(java.lang.String orgId) {
        this.orgId = orgId;
    }


    /**
     * Gets the orgName value for this TransactionData.
     * 
     * @return orgName
     */
    public java.lang.String getOrgName() {
        return orgName;
    }


    /**
     * Sets the orgName value for this TransactionData.
     * 
     * @param orgName
     */
    public void setOrgName(java.lang.String orgName) {
        this.orgName = orgName;
    }


    /**
     * Gets the secuId value for this TransactionData.
     * 
     * @return secuId
     */
    public java.lang.String getSecuId() {
        return secuId;
    }


    /**
     * Sets the secuId value for this TransactionData.
     * 
     * @param secuId
     */
    public void setSecuId(java.lang.String secuId) {
        this.secuId = secuId;
    }


    /**
     * Gets the custId value for this TransactionData.
     * 
     * @return custId
     */
    public java.lang.String getCustId() {
        return custId;
    }


    /**
     * Sets the custId value for this TransactionData.
     * 
     * @param custId
     */
    public void setCustId(java.lang.String custId) {
        this.custId = custId;
    }


    /**
     * Gets the name value for this TransactionData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this TransactionData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the identityCardNumber value for this TransactionData.
     * 
     * @return identityCardNumber
     */
    public java.lang.String getIdentityCardNumber() {
        return identityCardNumber;
    }


    /**
     * Sets the identityCardNumber value for this TransactionData.
     * 
     * @param identityCardNumber
     */
    public void setIdentityCardNumber(java.lang.String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }


    /**
     * Gets the transactionSummary value for this TransactionData.
     * 
     * @return transactionSummary
     */
    public java.lang.String getTransactionSummary() {
        return transactionSummary;
    }


    /**
     * Sets the transactionSummary value for this TransactionData.
     * 
     * @param transactionSummary
     */
    public void setTransactionSummary(java.lang.String transactionSummary) {
        this.transactionSummary = transactionSummary;
    }


    /**
     * Gets the transactionTime value for this TransactionData.
     * 
     * @return transactionTime
     */
    public java.lang.String getTransactionTime() {
        return transactionTime;
    }


    /**
     * Sets the transactionTime value for this TransactionData.
     * 
     * @param transactionTime
     */
    public void setTransactionTime(java.lang.String transactionTime) {
        this.transactionTime = transactionTime;
    }


    /**
     * Gets the operationTime value for this TransactionData.
     * 
     * @return operationTime
     */
    public java.lang.String getOperationTime() {
        return operationTime;
    }


    /**
     * Sets the operationTime value for this TransactionData.
     * 
     * @param operationTime
     */
    public void setOperationTime(java.lang.String operationTime) {
        this.operationTime = operationTime;
    }


    /**
     * Gets the result value for this TransactionData.
     * 
     * @return result
     */
    public java.lang.String getResult() {
        return result;
    }


    /**
     * Sets the result value for this TransactionData.
     * 
     * @param result
     */
    public void setResult(java.lang.String result) {
        this.result = result;
    }


    /**
     * Gets the ext1 value for this TransactionData.
     * 
     * @return ext1
     */
    public java.lang.String getExt1() {
        return ext1;
    }


    /**
     * Sets the ext1 value for this TransactionData.
     * 
     * @param ext1
     */
    public void setExt1(java.lang.String ext1) {
        this.ext1 = ext1;
    }


    /**
     * Gets the ext2 value for this TransactionData.
     * 
     * @return ext2
     */
    public java.lang.String getExt2() {
        return ext2;
    }


    /**
     * Sets the ext2 value for this TransactionData.
     * 
     * @param ext2
     */
    public void setExt2(java.lang.String ext2) {
        this.ext2 = ext2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TransactionData)) return false;
        TransactionData other = (TransactionData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
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
            ((this.transactionTime==null && other.getTransactionTime()==null) || 
             (this.transactionTime!=null &&
              this.transactionTime.equals(other.getTransactionTime()))) &&
            ((this.operationTime==null && other.getOperationTime()==null) || 
             (this.operationTime!=null &&
              this.operationTime.equals(other.getOperationTime()))) &&
            ((this.result==null && other.getResult()==null) || 
             (this.result!=null &&
              this.result.equals(other.getResult()))) &&
            ((this.ext1==null && other.getExt1()==null) || 
             (this.ext1!=null &&
              this.ext1.equals(other.getExt1()))) &&
            ((this.ext2==null && other.getExt2()==null) || 
             (this.ext2!=null &&
              this.ext2.equals(other.getExt2())));
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
        if (getTransactionTime() != null) {
            _hashCode += getTransactionTime().hashCode();
        }
        if (getOperationTime() != null) {
            _hashCode += getOperationTime().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        if (getExt1() != null) {
            _hashCode += getExt1().hashCode();
        }
        if (getExt2() != null) {
            _hashCode += getExt2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TransactionData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "TransactionData"));
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
        elemField.setFieldName("transactionTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "TransactionTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationTime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OperationTime"));
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
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ext1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Ext1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ext2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Ext2"));
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
