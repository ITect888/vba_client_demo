/**
 * QueryUnsureDataResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class QueryUnsureDataResponse  extends org.zonrong.www.ResponseBase  implements java.io.Serializable {
    private org.zonrong.www.UnsureData[] unsureDatas;

    public QueryUnsureDataResponse() {
    }

    public QueryUnsureDataResponse(
           org.zonrong.www.ResponseCode responseCode,
           org.zonrong.www.UnsureData[] unsureDatas) {
        super(
            responseCode);
        this.unsureDatas = unsureDatas;
    }


    /**
     * Gets the unsureDatas value for this QueryUnsureDataResponse.
     * 
     * @return unsureDatas
     */
    public org.zonrong.www.UnsureData[] getUnsureDatas() {
        return unsureDatas;
    }


    /**
     * Sets the unsureDatas value for this QueryUnsureDataResponse.
     * 
     * @param unsureDatas
     */
    public void setUnsureDatas(org.zonrong.www.UnsureData[] unsureDatas) {
        this.unsureDatas = unsureDatas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryUnsureDataResponse)) return false;
        QueryUnsureDataResponse other = (QueryUnsureDataResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.unsureDatas==null && other.getUnsureDatas()==null) || 
             (this.unsureDatas!=null &&
              java.util.Arrays.equals(this.unsureDatas, other.getUnsureDatas())));
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
        if (getUnsureDatas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getUnsureDatas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getUnsureDatas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(QueryUnsureDataResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "QueryUnsureDataResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("unsureDatas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "UnsureDatas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "UnsureData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.zonrong.org/", "UnsureData"));
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
