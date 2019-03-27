/**
 * QueryCitizenResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class QueryCitizenResponse  extends org.zonrong.www.ResponseBase  implements java.io.Serializable {
    private org.zonrong.www.IdentifierData[] identifiers;

    public QueryCitizenResponse() {
    }

    public QueryCitizenResponse(
           org.zonrong.www.ResponseCode responseCode,
           org.zonrong.www.IdentifierData[] identifiers) {
        super(
            responseCode);
        this.identifiers = identifiers;
    }


    /**
     * Gets the identifiers value for this QueryCitizenResponse.
     * 
     * @return identifiers
     */
    public org.zonrong.www.IdentifierData[] getIdentifiers() {
        return identifiers;
    }


    /**
     * Sets the identifiers value for this QueryCitizenResponse.
     * 
     * @param identifiers
     */
    public void setIdentifiers(org.zonrong.www.IdentifierData[] identifiers) {
        this.identifiers = identifiers;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof QueryCitizenResponse)) return false;
        QueryCitizenResponse other = (QueryCitizenResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.identifiers==null && other.getIdentifiers()==null) || 
             (this.identifiers!=null &&
              java.util.Arrays.equals(this.identifiers, other.getIdentifiers())));
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
        if (getIdentifiers() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getIdentifiers());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getIdentifiers(), i);
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
        new org.apache.axis.description.TypeDesc(QueryCitizenResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "QueryCitizenResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifiers");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Identifiers"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentifierData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentifierData"));
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
