/**
 * HistoryData.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class HistoryData  implements java.io.Serializable {
    private java.lang.String seq;

    private java.lang.String time;

    private org.zonrong.www.IdentifierData identifier;

    private java.lang.String importType;

    private int isHistory;

    private java.lang.String operationId;

    private java.lang.String operatorName;

    public HistoryData() {
    }

    public HistoryData(
           java.lang.String seq,
           java.lang.String time,
           org.zonrong.www.IdentifierData identifier,
           java.lang.String importType,
           int isHistory,
           java.lang.String operationId,
           java.lang.String operatorName) {
           this.seq = seq;
           this.time = time;
           this.identifier = identifier;
           this.importType = importType;
           this.isHistory = isHistory;
           this.operationId = operationId;
           this.operatorName = operatorName;
    }


    /**
     * Gets the seq value for this HistoryData.
     * 
     * @return seq
     */
    public java.lang.String getSeq() {
        return seq;
    }


    /**
     * Sets the seq value for this HistoryData.
     * 
     * @param seq
     */
    public void setSeq(java.lang.String seq) {
        this.seq = seq;
    }


    /**
     * Gets the time value for this HistoryData.
     * 
     * @return time
     */
    public java.lang.String getTime() {
        return time;
    }


    /**
     * Sets the time value for this HistoryData.
     * 
     * @param time
     */
    public void setTime(java.lang.String time) {
        this.time = time;
    }


    /**
     * Gets the identifier value for this HistoryData.
     * 
     * @return identifier
     */
    public org.zonrong.www.IdentifierData getIdentifier() {
        return identifier;
    }


    /**
     * Sets the identifier value for this HistoryData.
     * 
     * @param identifier
     */
    public void setIdentifier(org.zonrong.www.IdentifierData identifier) {
        this.identifier = identifier;
    }


    /**
     * Gets the importType value for this HistoryData.
     * 
     * @return importType
     */
    public java.lang.String getImportType() {
        return importType;
    }


    /**
     * Sets the importType value for this HistoryData.
     * 
     * @param importType
     */
    public void setImportType(java.lang.String importType) {
        this.importType = importType;
    }


    /**
     * Gets the isHistory value for this HistoryData.
     * 
     * @return isHistory
     */
    public int getIsHistory() {
        return isHistory;
    }


    /**
     * Sets the isHistory value for this HistoryData.
     * 
     * @param isHistory
     */
    public void setIsHistory(int isHistory) {
        this.isHistory = isHistory;
    }


    /**
     * Gets the operationId value for this HistoryData.
     * 
     * @return operationId
     */
    public java.lang.String getOperationId() {
        return operationId;
    }


    /**
     * Sets the operationId value for this HistoryData.
     * 
     * @param operationId
     */
    public void setOperationId(java.lang.String operationId) {
        this.operationId = operationId;
    }


    /**
     * Gets the operatorName value for this HistoryData.
     * 
     * @return operatorName
     */
    public java.lang.String getOperatorName() {
        return operatorName;
    }


    /**
     * Sets the operatorName value for this HistoryData.
     * 
     * @param operatorName
     */
    public void setOperatorName(java.lang.String operatorName) {
        this.operatorName = operatorName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HistoryData)) return false;
        HistoryData other = (HistoryData) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.seq==null && other.getSeq()==null) || 
             (this.seq!=null &&
              this.seq.equals(other.getSeq()))) &&
            ((this.time==null && other.getTime()==null) || 
             (this.time!=null &&
              this.time.equals(other.getTime()))) &&
            ((this.identifier==null && other.getIdentifier()==null) || 
             (this.identifier!=null &&
              this.identifier.equals(other.getIdentifier()))) &&
            ((this.importType==null && other.getImportType()==null) || 
             (this.importType!=null &&
              this.importType.equals(other.getImportType()))) &&
            this.isHistory == other.getIsHistory() &&
            ((this.operationId==null && other.getOperationId()==null) || 
             (this.operationId!=null &&
              this.operationId.equals(other.getOperationId()))) &&
            ((this.operatorName==null && other.getOperatorName()==null) || 
             (this.operatorName!=null &&
              this.operatorName.equals(other.getOperatorName())));
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
        if (getSeq() != null) {
            _hashCode += getSeq().hashCode();
        }
        if (getTime() != null) {
            _hashCode += getTime().hashCode();
        }
        if (getIdentifier() != null) {
            _hashCode += getIdentifier().hashCode();
        }
        if (getImportType() != null) {
            _hashCode += getImportType().hashCode();
        }
        _hashCode += getIsHistory();
        if (getOperationId() != null) {
            _hashCode += getOperationId().hashCode();
        }
        if (getOperatorName() != null) {
            _hashCode += getOperatorName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HistoryData.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "HistoryData"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seq");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Seq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("time");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Time"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("identifier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "Identifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentifierData"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "ImportType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isHistory");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "IsHistory"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operationId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://www.zonrong.org/", "OperationId"));
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
