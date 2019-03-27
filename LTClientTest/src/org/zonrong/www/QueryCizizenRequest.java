/**
 * QueryCizizenRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class QueryCizizenRequest  extends org.zonrong.www.PagedRequest  implements java.io.Serializable {
    private java.lang.String dateStart;

    private java.lang.String citizId;

    private java.lang.String name;

    private java.lang.String dateEnd;

    private java.lang.String operatorName;

    private java.lang.String result;

    public QueryCizizenRequest() {
    }

    public QueryCizizenRequest(
           int startIndex,
           int endIndex,
           java.lang.String dateStart,
           java.lang.String citizId,
           java.lang.String name,
           java.lang.String dateEnd,
           java.lang.String operatorName,
           java.lang.String result) {
        super(
            startIndex,
            endIndex);
        this.dateStart = dateStart;
        this.citizId = citizId;
        this.name = name;
        this.dateEnd = dateEnd;
        this.operatorName = operatorName;
        this.result = result;
    }


    /**
     * Gets the dateStart value for this QueryCizizenRequest.
     * 
     * @return dateStart
     */
    public java.lang.String getDateStart() {
        return dateStart;
    }


    /**
     * Sets the dateStart value for this QueryCizizenRequest.
     * 
     * @param dateStart
     */
    public void setDateStart(java.lang.String dateStart) {
        this.dateStart = dateStart;
    }


    /**
     * Gets the citizId value for this QueryCizizenRequest.
     * 
     * @return citizId
     */
    public java.lang.String getCitizId() {
        return citizId;
    }


    /**
     * Sets the citizId value for this QueryCizizenRequest.
     * 
     * @param citizId
     */
    public void setCitizId(java.lang.String citizId) {
        this.citizId = citizId;
    }


    /**
     * Gets the name value for this QueryCizizenRequest.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this QueryCizizenRequest.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the dateEnd value for this QueryCizizenRequest.
     * 
     * @return dateEnd
     */
    public java.lang.String getDateEnd() {
        return dateEnd;
    }


    /**
     * Sets the dateEnd value for this QueryCizizenRequest.
     * 
     * @param dateEnd
     */
    public void setDateEnd(java.lang.String dateEnd) {
        this.dateEnd = dateEnd;
    }


    /**
     * Gets the operatorName value for this QueryCizizenRequest.
     * 
     * @return operatorName
     */
    public java.lang.String getOperatorName() {
        return operatorName;
    }


    /**
     * Sets the operatorName value for this QueryCizizenRequest.
     * 
     * @param operatorName
     */
    public void setOperatorName(java.lang.String operatorName) {
        this.operatorName = operatorName;
    }


    /**
     * Gets the result value for this QueryCizizenRequest.
     * 
     * @return result
     */
    public java.lang.String getResult() {
        return result;
    }


    /**
     * Sets the result value for this QueryCizizenRequest.
     * 
     * @param result
     */
    public void setResult(java.lang.String result) {
        this.result = result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryCizizenRequest)) return false;
        QueryCizizenRequest other = (QueryCizizenRequest) obj;
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
            ((this.citizId==null && other.getCitizId()==null) || 
             (this.citizId!=null &&
              this.citizId.equals(other.getCitizId()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.dateEnd==null && other.getDateEnd()==null) || 
             (this.dateEnd!=null &&
              this.dateEnd.equals(other.getDateEnd()))) &&
            ((this.operatorName==null && other.getOperatorName()==null) || 
             (this.operatorName!=null &&
              this.operatorName.equals(other.getOperatorName()))) &&
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
        if (getDateStart() != null) {
            _hashCode += getDateStart().hashCode();
        }
        if (getCitizId() != null) {
            _hashCode += getCitizId().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getDateEnd() != null) {
            _hashCode += getDateEnd().hashCode();
        }
        if (getOperatorName() != null) {
            _hashCode += getOperatorName().hashCode();
        }
        if (getResult() != null) {
            _hashCode += getResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryCizizenRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "QueryCizizenRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateStart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "DateStart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citizId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "CitizId"));
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
