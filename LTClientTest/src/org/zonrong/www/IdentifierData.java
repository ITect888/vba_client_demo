/**
 * IdentifierData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class IdentifierData  implements java.io.Serializable {
    private java.lang.String citizenIdNumber;

    private java.lang.String citizenIdResult;

    private java.lang.String name;

    private java.lang.String sexCode;

    private java.lang.String nationCode;

    private java.lang.String birthDate;

    private java.lang.String photos;

    public IdentifierData() {
    }

    public IdentifierData(
           java.lang.String citizenIdNumber,
           java.lang.String citizenIdResult,
           java.lang.String name,
           java.lang.String sexCode,
           java.lang.String nationCode,
           java.lang.String birthDate,
           java.lang.String photos) {
           this.citizenIdNumber = citizenIdNumber;
           this.citizenIdResult = citizenIdResult;
           this.name = name;
           this.sexCode = sexCode;
           this.nationCode = nationCode;
           this.birthDate = birthDate;
           this.photos = photos;
    }


    /**
     * Gets the citizenIdNumber value for this IdentifierData.
     * 
     * @return citizenIdNumber
     */
    public java.lang.String getCitizenIdNumber() {
        return citizenIdNumber;
    }


    /**
     * Sets the citizenIdNumber value for this IdentifierData.
     * 
     * @param citizenIdNumber
     */
    public void setCitizenIdNumber(java.lang.String citizenIdNumber) {
        this.citizenIdNumber = citizenIdNumber;
    }


    /**
     * Gets the citizenIdResult value for this IdentifierData.
     * 
     * @return citizenIdResult
     */
    public java.lang.String getCitizenIdResult() {
        return citizenIdResult;
    }


    /**
     * Sets the citizenIdResult value for this IdentifierData.
     * 
     * @param citizenIdResult
     */
    public void setCitizenIdResult(java.lang.String citizenIdResult) {
        this.citizenIdResult = citizenIdResult;
    }


    /**
     * Gets the name value for this IdentifierData.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this IdentifierData.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the sexCode value for this IdentifierData.
     * 
     * @return sexCode
     */
    public java.lang.String getSexCode() {
        return sexCode;
    }


    /**
     * Sets the sexCode value for this IdentifierData.
     * 
     * @param sexCode
     */
    public void setSexCode(java.lang.String sexCode) {
        this.sexCode = sexCode;
    }


    /**
     * Gets the nationCode value for this IdentifierData.
     * 
     * @return nationCode
     */
    public java.lang.String getNationCode() {
        return nationCode;
    }


    /**
     * Sets the nationCode value for this IdentifierData.
     * 
     * @param nationCode
     */
    public void setNationCode(java.lang.String nationCode) {
        this.nationCode = nationCode;
    }


    /**
     * Gets the birthDate value for this IdentifierData.
     * 
     * @return birthDate
     */
    public java.lang.String getBirthDate() {
        return birthDate;
    }


    /**
     * Sets the birthDate value for this IdentifierData.
     * 
     * @param birthDate
     */
    public void setBirthDate(java.lang.String birthDate) {
        this.birthDate = birthDate;
    }


    /**
     * Gets the photos value for this IdentifierData.
     * 
     * @return photos
     */
    public java.lang.String getPhotos() {
        return photos;
    }


    /**
     * Sets the photos value for this IdentifierData.
     * 
     * @param photos
     */
    public void setPhotos(java.lang.String photos) {
        this.photos = photos;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof IdentifierData)) return false;
        IdentifierData other = (IdentifierData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.citizenIdNumber==null && other.getCitizenIdNumber()==null) || 
             (this.citizenIdNumber!=null &&
              this.citizenIdNumber.equals(other.getCitizenIdNumber()))) &&
            ((this.citizenIdResult==null && other.getCitizenIdResult()==null) || 
             (this.citizenIdResult!=null &&
              this.citizenIdResult.equals(other.getCitizenIdResult()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.sexCode==null && other.getSexCode()==null) || 
             (this.sexCode!=null &&
              this.sexCode.equals(other.getSexCode()))) &&
            ((this.nationCode==null && other.getNationCode()==null) || 
             (this.nationCode!=null &&
              this.nationCode.equals(other.getNationCode()))) &&
            ((this.birthDate==null && other.getBirthDate()==null) || 
             (this.birthDate!=null &&
              this.birthDate.equals(other.getBirthDate()))) &&
            ((this.photos==null && other.getPhotos()==null) || 
             (this.photos!=null &&
              this.photos.equals(other.getPhotos())));
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
        if (getCitizenIdNumber() != null) {
            _hashCode += getCitizenIdNumber().hashCode();
        }
        if (getCitizenIdResult() != null) {
            _hashCode += getCitizenIdResult().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getSexCode() != null) {
            _hashCode += getSexCode().hashCode();
        }
        if (getNationCode() != null) {
            _hashCode += getNationCode().hashCode();
        }
        if (getBirthDate() != null) {
            _hashCode += getBirthDate().hashCode();
        }
        if (getPhotos() != null) {
            _hashCode += getPhotos().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(IdentifierData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentifierData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citizenIdNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "CitizenIdNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("citizenIdResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "CitizenIdResult"));
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
        elemField.setFieldName("sexCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "SexCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nationCode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "NationCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("birthDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "BirthDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("photos");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Photos"));
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
