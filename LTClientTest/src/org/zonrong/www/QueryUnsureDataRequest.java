/**
 * QueryUnsureDataRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class QueryUnsureDataRequest  extends org.zonrong.www.PagedRequest  implements java.io.Serializable {
    private java.lang.String dateStart;

    private java.lang.String dateEnd;

    private java.lang.String operatorName;

    private java.lang.String identityCardNumber;

    private java.lang.String name;

    private java.lang.String requeryResult;

    public QueryUnsureDataRequest() {
    }

    public QueryUnsureDataRequest(
           int startIndex,
           int endIndex,
           java.lang.String dateStart,
           java.lang.String dateEnd,
           java.lang.String operatorName,
           java.lang.String identityCardNumber,
           java.lang.String name,
           java.lang.String requeryResult) {
        super(
            startIndex,
            endIndex);
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.operatorName = operatorName;
        this.identityCardNumber = identityCardNumber;
        this.name = name;
        this.requeryResult = requeryResult;
    }


    /**
     * Gets the dateStart value for this QueryUnsureDataRequest.
     * 
     * @return dateStart
     */
    public java.lang.String getDateStart() {
        return dateStart;
    }


    /**
     * Sets the dateStart value for this QueryUnsureDataRequest.
     * 
     * @param dateStart
     */
    public void setDateStart(java.lang.String dateStart) {
        this.dateStart = dateStart;
    }


    /**
     * Gets the dateEnd value for this QueryUnsureDataRequest.
     * 
     * @return dateEnd
     */
    public java.lang.String getDateEnd() {
        return dateEnd;
    }


    /**
     * Sets the dateEnd value for this QueryUnsureDataRequest.
     * 
     * @param dateEnd
     */
    public void setDateEnd(java.lang.String dateEnd) {
        this.dateEnd = dateEnd;
    }


    /**
     * Gets the operatorName value for this QueryUnsureDataRequest.
     * 
     * @return operatorName
     */
    public java.lang.String getOperatorName() {
        return operatorName;
    }


    /**
     * Sets the operatorName value for this QueryUnsureDataRequest.
     * 
     * @param operatorName
     */
    public void setOperatorName(java.lang.String operatorName) {
        this.operatorName = operatorName;
    }


    /**
     * Gets the identityCardNumber value for this QueryUnsureDataRequest.
     * 
     * @return identityCardNumber
     */
    public java.lang.String getIdentityCardNumber() {
        return identityCardNumber;
    }


    /**
     * Sets the identityCardNumber value for this QueryUnsureDataRequest.
     * 
     * @param identityCardNumber
     */
    public void setIdentityCardNumber(java.lang.String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }


    /**
     * Gets the name value for this QueryUnsureDataRequest.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this QueryUnsureDataRequest.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the requeryResult value for this QueryUnsureDataRequest.
     * 
     * @return requeryResult
     */
    public java.lang.String getRequeryResult() {
        return requeryResult;
    }


    /**
     * Sets the requeryResult value for this QueryUnsureDataRequest.
     * 
     * @param requeryResult
     */
    public void setRequeryResult(java.lang.String requeryResult) {
        this.requeryResult = requeryResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryUnsureDataRequest)) return false;
        QueryUnsureDataRequest other = (QueryUnsureDataRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.dateStart==null && other.getDateStart()==null) || 
             (this.dateStart!=null &&
              this.dateStart.equals(other.getDateStart()))) &&
            ((this.dateEnd==null && other.getDateEnd()==null) || 
             (this.dateEnd!=null &&
              this.dateEnd.equals(other.getDateEnd()))) &&
            ((this.operatorName==null && other.getOperatorName()==null) || 
             (this.operatorName!=null &&
              this.operatorName.equals(other.getOperatorName()))) &&
            ((this.identityCardNumber==null && other.getIdentityCardNumber()==null) || 
             (this.identityCardNumber!=null &&
              this.identityCardNumber.equals(other.getIdentityCardNumber()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.requeryResult==null && other.getRequeryResult()==null) || 
             (this.requeryResult!=null &&
              this.requeryResult.equals(other.getRequeryResult())));
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
        if (getDateStart() != null) {
            _hashCode += getDateStart().hashCode();
        }
        if (getDateEnd() != null) {
            _hashCode += getDateEnd().hashCode();
        }
        if (getOperatorName() != null) {
            _hashCode += getOperatorName().hashCode();
        }
        if (getIdentityCardNumber() != null) {
            _hashCode += getIdentityCardNumber().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRequeryResult() != null) {
            _hashCode += getRequeryResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryUnsureDataRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "QueryUnsureDataRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("operatorName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OperatorName"));
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
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requeryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "RequeryResult"));
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
