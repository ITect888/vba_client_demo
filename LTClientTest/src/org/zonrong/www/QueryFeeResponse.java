/**
 * QueryFeeResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class QueryFeeResponse  extends org.zonrong.www.ResponseBase  implements java.io.Serializable {
    private int totalQueryCount;

    private int remainQueryCount;

    private boolean shareSuper;

    public QueryFeeResponse() {
    }

    public QueryFeeResponse(
           org.zonrong.www.ResponseCode responseCode,
           int totalQueryCount,
           int remainQueryCount,
           boolean shareSuper) {
        super(
            responseCode);
        this.totalQueryCount = totalQueryCount;
        this.remainQueryCount = remainQueryCount;
        this.shareSuper = shareSuper;
    }


    /**
     * Gets the totalQueryCount value for this QueryFeeResponse.
     * 
     * @return totalQueryCount
     */
    public int getTotalQueryCount() {
        return totalQueryCount;
    }


    /**
     * Sets the totalQueryCount value for this QueryFeeResponse.
     * 
     * @param totalQueryCount
     */
    public void setTotalQueryCount(int totalQueryCount) {
        this.totalQueryCount = totalQueryCount;
    }


    /**
     * Gets the remainQueryCount value for this QueryFeeResponse.
     * 
     * @return remainQueryCount
     */
    public int getRemainQueryCount() {
        return remainQueryCount;
    }


    /**
     * Sets the remainQueryCount value for this QueryFeeResponse.
     * 
     * @param remainQueryCount
     */
    public void setRemainQueryCount(int remainQueryCount) {
        this.remainQueryCount = remainQueryCount;
    }


    /**
     * Gets the shareSuper value for this QueryFeeResponse.
     * 
     * @return shareSuper
     */
    public boolean isShareSuper() {
        return shareSuper;
    }


    /**
     * Sets the shareSuper value for this QueryFeeResponse.
     * 
     * @param shareSuper
     */
    public void setShareSuper(boolean shareSuper) {
        this.shareSuper = shareSuper;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryFeeResponse)) return false;
        QueryFeeResponse other = (QueryFeeResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.totalQueryCount == other.getTotalQueryCount() &&
            this.remainQueryCount == other.getRemainQueryCount() &&
            this.shareSuper == other.isShareSuper();
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
        _hashCode += getTotalQueryCount();
        _hashCode += getRemainQueryCount();
        _hashCode += (isShareSuper() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryFeeResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "QueryFeeResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("totalQueryCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "TotalQueryCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("remainQueryCount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "RemainQueryCount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("shareSuper");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "ShareSuper"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
