/**
 * UnsureData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class UnsureData  implements java.io.Serializable {
    private java.lang.String ext2;

    private java.lang.String ext1;

    private java.lang.String requeryResult;

    private java.lang.String operationTime;

    private java.lang.String note;

    private java.lang.String name;

    private java.lang.String identityCardNumber;

    private java.lang.String operatorID;

    private java.lang.String loginName;

    private int ID;

    public UnsureData() {
    }

    public UnsureData(
           java.lang.String ext2,
           java.lang.String ext1,
           java.lang.String requeryResult,
           java.lang.String operationTime,
           java.lang.String note,
           java.lang.String name,
           java.lang.String identityCardNumber,
           java.lang.String operatorID,
           java.lang.String loginName,
           int ID) {
           this.ext2 = ext2;
           this.ext1 = ext1;
           this.requeryResult = requeryResult;
           this.operationTime = operationTime;
           this.note = note;
           this.name = name;
           this.identityCardNumber = identityCardNumber;
           this.operatorID = operatorID;
           this.loginName = loginName;
           this.ID = ID;
    }


    /**
     * Gets the ext2 value for this UnsureData.
     * 
     * @return ext2
     */
    public java.lang.String getExt2() {
        return ext2;
    }


    /**
     * Sets the ext2 value for this UnsureData.
     * 
     * @param ext2
     */
    public void setExt2(java.lang.String ext2) {
        this.ext2 = ext2;
    }


    /**
     * Gets the ext1 value for this UnsureData.
     * 
     * @return ext1
     */
    public java.lang.String getExt1() {
        return ext1;
    }


    /**
     * Sets the ext1 value for this UnsureData.
     * 
     * @param ext1
     */
    public void setExt1(java.lang.String ext1) {
        this.ext1 = ext1;
    }


    /**
     * Gets the requeryResult value for this UnsureData.
     * 
     * @return requeryResult
     */
    public java.lang.String getRequeryResult() {
        return requeryResult;
    }


    /**
     * Sets the requeryResult value for this UnsureData.
     * 
     * @param requeryResult
     */
    public void setRequeryResult(java.lang.String requeryResult) {
        this.requeryResult = requeryResult;
    }


    /**
     * Gets the operationTime value for this UnsureData.
     * 
     * @return operationTime
     */
    public java.lang.String getOperationTime() {
        return operationTime;
    }


    /**
     * Sets the operationTime value for this UnsureData.
     * 
     * @param operationTime
     */
    public void setOperationTime(java.lang.String operationTime) {
        this.operationTime = operationTime;
    }


    /**
     * Gets the note value for this UnsureData.
     * 
     * @return note
     */
    public java.lang.String getNote() {
        return note;
    }


    /**
     * Sets the note value for this UnsureData.
     * 
     * @param note
     */
    public void setNote(java.lang.String note) {
        this.note = note;
    }


    /**
     * Gets the name value for this UnsureData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this UnsureData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the identityCardNumber value for this UnsureData.
     * 
     * @return identityCardNumber
     */
    public java.lang.String getIdentityCardNumber() {
        return identityCardNumber;
    }


    /**
     * Sets the identityCardNumber value for this UnsureData.
     * 
     * @param identityCardNumber
     */
    public void setIdentityCardNumber(java.lang.String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }


    /**
     * Gets the operatorID value for this UnsureData.
     * 
     * @return operatorID
     */
    public java.lang.String getOperatorID() {
        return operatorID;
    }


    /**
     * Sets the operatorID value for this UnsureData.
     * 
     * @param operatorID
     */
    public void setOperatorID(java.lang.String operatorID) {
        this.operatorID = operatorID;
    }


    /**
     * Gets the loginName value for this UnsureData.
     * 
     * @return loginName
     */
    public java.lang.String getLoginName() {
        return loginName;
    }


    /**
     * Sets the loginName value for this UnsureData.
     * 
     * @param loginName
     */
    public void setLoginName(java.lang.String loginName) {
        this.loginName = loginName;
    }


    /**
     * Gets the ID value for this UnsureData.
     * 
     * @return ID
     */
    public int getID() {
        return ID;
    }


    /**
     * Sets the ID value for this UnsureData.
     * 
     * @param ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UnsureData)) return false;
        UnsureData other = (UnsureData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ext2==null && other.getExt2()==null) || 
             (this.ext2!=null &&
              this.ext2.equals(other.getExt2()))) &&
            ((this.ext1==null && other.getExt1()==null) || 
             (this.ext1!=null &&
              this.ext1.equals(other.getExt1()))) &&
            ((this.requeryResult==null && other.getRequeryResult()==null) || 
             (this.requeryResult!=null &&
              this.requeryResult.equals(other.getRequeryResult()))) &&
            ((this.operationTime==null && other.getOperationTime()==null) || 
             (this.operationTime!=null &&
              this.operationTime.equals(other.getOperationTime()))) &&
            ((this.note==null && other.getNote()==null) || 
             (this.note!=null &&
              this.note.equals(other.getNote()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.identityCardNumber==null && other.getIdentityCardNumber()==null) || 
             (this.identityCardNumber!=null &&
              this.identityCardNumber.equals(other.getIdentityCardNumber()))) &&
            ((this.operatorID==null && other.getOperatorID()==null) || 
             (this.operatorID!=null &&
              this.operatorID.equals(other.getOperatorID()))) &&
            ((this.loginName==null && other.getLoginName()==null) || 
             (this.loginName!=null &&
              this.loginName.equals(other.getLoginName()))) &&
            this.ID == other.getID();
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
        if (getExt2() != null) {
            _hashCode += getExt2().hashCode();
        }
        if (getExt1() != null) {
            _hashCode += getExt1().hashCode();
        }
        if (getRequeryResult() != null) {
            _hashCode += getRequeryResult().hashCode();
        }
        if (getOperationTime() != null) {
            _hashCode += getOperationTime().hashCode();
        }
        if (getNote() != null) {
            _hashCode += getNote().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getIdentityCardNumber() != null) {
            _hashCode += getIdentityCardNumber().hashCode();
        }
        if (getOperatorID() != null) {
            _hashCode += getOperatorID().hashCode();
        }
        if (getLoginName() != null) {
            _hashCode += getLoginName().hashCode();
        }
        _hashCode += getID();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UnsureData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "UnsureData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ext2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Ext2"));
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
        elemField.setFieldName("requeryResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "RequeryResult"));
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
        elemField.setFieldName("note");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Note"));
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
        elemField.setFieldName("operatorID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OperatorID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loginName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "LoginName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "ID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
