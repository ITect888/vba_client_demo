/**
 * ModifyPwdRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class ModifyPwdRequest  implements java.io.Serializable {
    private java.lang.String newPwd;

    private java.lang.String orgPwd;

    private java.lang.String userId;

    public ModifyPwdRequest() {
    }

    public ModifyPwdRequest(
           java.lang.String newPwd,
           java.lang.String orgPwd,
           java.lang.String userId) {
           this.newPwd = newPwd;
           this.orgPwd = orgPwd;
           this.userId = userId;
    }


    /**
     * Gets the newPwd value for this ModifyPwdRequest.
     * 
     * @return newPwd
     */
    public java.lang.String getNewPwd() {
        return newPwd;
    }


    /**
     * Sets the newPwd value for this ModifyPwdRequest.
     * 
     * @param newPwd
     */
    public void setNewPwd(java.lang.String newPwd) {
        this.newPwd = newPwd;
    }


    /**
     * Gets the orgPwd value for this ModifyPwdRequest.
     * 
     * @return orgPwd
     */
    public java.lang.String getOrgPwd() {
        return orgPwd;
    }


    /**
     * Sets the orgPwd value for this ModifyPwdRequest.
     * 
     * @param orgPwd
     */
    public void setOrgPwd(java.lang.String orgPwd) {
        this.orgPwd = orgPwd;
    }


    /**
     * Gets the userId value for this ModifyPwdRequest.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this ModifyPwdRequest.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModifyPwdRequest)) return false;
        ModifyPwdRequest other = (ModifyPwdRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.newPwd==null && other.getNewPwd()==null) || 
             (this.newPwd!=null &&
              this.newPwd.equals(other.getNewPwd()))) &&
            ((this.orgPwd==null && other.getOrgPwd()==null) || 
             (this.orgPwd!=null &&
              this.orgPwd.equals(other.getOrgPwd()))) &&
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
        if (getNewPwd() != null) {
            _hashCode += getNewPwd().hashCode();
        }
        if (getOrgPwd() != null) {
            _hashCode += getOrgPwd().hashCode();
        }
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModifyPwdRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "ModifyPwdRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("newPwd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "NewPwd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("orgPwd");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OrgPwd"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "UserId"));
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
