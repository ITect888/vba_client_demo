/**
 * LoginResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class LoginResponse  implements java.io.Serializable {
    private org.zonrong.www.LoginResposeCode responseCode;

    private org.zonrong.www.LoginUserData userData;

    private java.lang.String serversXmlData;

    public LoginResponse() {
    }

    public LoginResponse(
           org.zonrong.www.LoginResposeCode responseCode,
           org.zonrong.www.LoginUserData userData,
           java.lang.String serversXmlData) {
           this.responseCode = responseCode;
           this.userData = userData;
           this.serversXmlData = serversXmlData;
    }


    /**
     * Gets the responseCode value for this LoginResponse.
     * 
     * @return responseCode
     */
    public org.zonrong.www.LoginResposeCode getResponseCode() {
        return responseCode;
    }


    /**
     * Sets the responseCode value for this LoginResponse.
     * 
     * @param responseCode
     */
    public void setResponseCode(org.zonrong.www.LoginResposeCode responseCode) {
        this.responseCode = responseCode;
    }


    /**
     * Gets the userData value for this LoginResponse.
     * 
     * @return userData
     */
    public org.zonrong.www.LoginUserData getUserData() {
        return userData;
    }


    /**
     * Sets the userData value for this LoginResponse.
     * 
     * @param userData
     */
    public void setUserData(org.zonrong.www.LoginUserData userData) {
        this.userData = userData;
    }


    /**
     * Gets the serversXmlData value for this LoginResponse.
     * 
     * @return serversXmlData
     */
    public java.lang.String getServersXmlData() {
        return serversXmlData;
    }


    /**
     * Sets the serversXmlData value for this LoginResponse.
     * 
     * @param serversXmlData
     */
    public void setServersXmlData(java.lang.String serversXmlData) {
        this.serversXmlData = serversXmlData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof LoginResponse)) return false;
        LoginResponse other = (LoginResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.responseCode==null && other.getResponseCode()==null) || 
             (this.responseCode!=null &&
              this.responseCode.equals(other.getResponseCode()))) &&
            ((this.userData==null && other.getUserData()==null) || 
             (this.userData!=null &&
              this.userData.equals(other.getUserData()))) &&
            ((this.serversXmlData==null && other.getServersXmlData()==null) || 
             (this.serversXmlData!=null &&
              this.serversXmlData.equals(other.getServersXmlData())));
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
        if (getResponseCode() != null) {
            _hashCode += getResponseCode().hashCode();
        }
        if (getUserData() != null) {
            _hashCode += getUserData().hashCode();
        }
        if (getServersXmlData() != null) {
            _hashCode += getServersXmlData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(LoginResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "LoginResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "ResponseCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "LoginResposeCode"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "UserData"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "LoginUserData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serversXmlData");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "ServersXmlData"));
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
