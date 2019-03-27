/**
 * ResponseCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class ResponseCode implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected ResponseCode(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _SUCCESS = "SUCCESS";
    public static final java.lang.String _NO_ENOUGH_MONEY = "NO_ENOUGH_MONEY";
    public static final java.lang.String _IDENTITY_DENIED = "IDENTITY_DENIED";
    public static final java.lang.String _PARAMETER_ERROR = "PARAMETER_ERROR";
    public static final java.lang.String _TOO_MANY_RECORD = "TOO_MANY_RECORD";
    public static final java.lang.String _SERVICE_ERROR = "SERVICE_ERROR";
    public static final ResponseCode SUCCESS = new ResponseCode(_SUCCESS);
    public static final ResponseCode NO_ENOUGH_MONEY = new ResponseCode(_NO_ENOUGH_MONEY);
    public static final ResponseCode IDENTITY_DENIED = new ResponseCode(_IDENTITY_DENIED);
    public static final ResponseCode PARAMETER_ERROR = new ResponseCode(_PARAMETER_ERROR);
    public static final ResponseCode TOO_MANY_RECORD = new ResponseCode(_TOO_MANY_RECORD);
    public static final ResponseCode SERVICE_ERROR = new ResponseCode(_SERVICE_ERROR);
    public java.lang.String getValue() { return _value_;}
    public static ResponseCode fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        ResponseCode enumeration = (ResponseCode)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static ResponseCode fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResponseCode.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "ResponseCode"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
