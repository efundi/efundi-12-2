/**
 * ModuleOfferingSearchCriteriaInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class ModuleOfferingSearchCriteriaInfo  implements java.io.Serializable {
    private za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod;

    private java.lang.String moduleSubjectCode;

    private java.lang.String moduleNumber;

    private java.lang.String moduleSite;

    private java.lang.String moduleOrgEnt;

    private java.lang.String methodOfDeliveryTypeKey;

    private java.lang.String modeOfDeliveryTypeKey;

    private java.util.Calendar startDate;

    private java.util.Calendar endDate;

    public ModuleOfferingSearchCriteriaInfo() {
    }

    public ModuleOfferingSearchCriteriaInfo(
           za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod,
           java.lang.String moduleSubjectCode,
           java.lang.String moduleNumber,
           java.lang.String moduleSite,
           java.lang.String moduleOrgEnt,
           java.lang.String methodOfDeliveryTypeKey,
           java.lang.String modeOfDeliveryTypeKey,
           java.util.Calendar startDate,
           java.util.Calendar endDate) {
           this.academicPeriod = academicPeriod;
           this.moduleSubjectCode = moduleSubjectCode;
           this.moduleNumber = moduleNumber;
           this.moduleSite = moduleSite;
           this.moduleOrgEnt = moduleOrgEnt;
           this.methodOfDeliveryTypeKey = methodOfDeliveryTypeKey;
           this.modeOfDeliveryTypeKey = modeOfDeliveryTypeKey;
           this.startDate = startDate;
           this.endDate = endDate;
    }


    /**
     * Gets the academicPeriod value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return academicPeriod
     */
    public za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo getAcademicPeriod() {
        return academicPeriod;
    }


    /**
     * Sets the academicPeriod value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param academicPeriod
     */
    public void setAcademicPeriod(za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod) {
        this.academicPeriod = academicPeriod;
    }


    /**
     * Gets the moduleSubjectCode value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return moduleSubjectCode
     */
    public java.lang.String getModuleSubjectCode() {
        return moduleSubjectCode;
    }


    /**
     * Sets the moduleSubjectCode value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param moduleSubjectCode
     */
    public void setModuleSubjectCode(java.lang.String moduleSubjectCode) {
        this.moduleSubjectCode = moduleSubjectCode;
    }


    /**
     * Gets the moduleNumber value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return moduleNumber
     */
    public java.lang.String getModuleNumber() {
        return moduleNumber;
    }


    /**
     * Sets the moduleNumber value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param moduleNumber
     */
    public void setModuleNumber(java.lang.String moduleNumber) {
        this.moduleNumber = moduleNumber;
    }


    /**
     * Gets the moduleSite value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return moduleSite
     */
    public java.lang.String getModuleSite() {
        return moduleSite;
    }


    /**
     * Sets the moduleSite value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param moduleSite
     */
    public void setModuleSite(java.lang.String moduleSite) {
        this.moduleSite = moduleSite;
    }


    /**
     * Gets the moduleOrgEnt value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return moduleOrgEnt
     */
    public java.lang.String getModuleOrgEnt() {
        return moduleOrgEnt;
    }


    /**
     * Sets the moduleOrgEnt value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param moduleOrgEnt
     */
    public void setModuleOrgEnt(java.lang.String moduleOrgEnt) {
        this.moduleOrgEnt = moduleOrgEnt;
    }


    /**
     * Gets the methodOfDeliveryTypeKey value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return methodOfDeliveryTypeKey
     */
    public java.lang.String getMethodOfDeliveryTypeKey() {
        return methodOfDeliveryTypeKey;
    }


    /**
     * Sets the methodOfDeliveryTypeKey value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param methodOfDeliveryTypeKey
     */
    public void setMethodOfDeliveryTypeKey(java.lang.String methodOfDeliveryTypeKey) {
        this.methodOfDeliveryTypeKey = methodOfDeliveryTypeKey;
    }


    /**
     * Gets the modeOfDeliveryTypeKey value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return modeOfDeliveryTypeKey
     */
    public java.lang.String getModeOfDeliveryTypeKey() {
        return modeOfDeliveryTypeKey;
    }


    /**
     * Sets the modeOfDeliveryTypeKey value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param modeOfDeliveryTypeKey
     */
    public void setModeOfDeliveryTypeKey(java.lang.String modeOfDeliveryTypeKey) {
        this.modeOfDeliveryTypeKey = modeOfDeliveryTypeKey;
    }


    /**
     * Gets the startDate value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return startDate
     */
    public java.util.Calendar getStartDate() {
        return startDate;
    }


    /**
     * Sets the startDate value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param startDate
     */
    public void setStartDate(java.util.Calendar startDate) {
        this.startDate = startDate;
    }


    /**
     * Gets the endDate value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @return endDate
     */
    public java.util.Calendar getEndDate() {
        return endDate;
    }


    /**
     * Sets the endDate value for this ModuleOfferingSearchCriteriaInfo.
     * 
     * @param endDate
     */
    public void setEndDate(java.util.Calendar endDate) {
        this.endDate = endDate;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ModuleOfferingSearchCriteriaInfo)) return false;
        ModuleOfferingSearchCriteriaInfo other = (ModuleOfferingSearchCriteriaInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.academicPeriod==null && other.getAcademicPeriod()==null) || 
             (this.academicPeriod!=null &&
              this.academicPeriod.equals(other.getAcademicPeriod()))) &&
            ((this.moduleSubjectCode==null && other.getModuleSubjectCode()==null) || 
             (this.moduleSubjectCode!=null &&
              this.moduleSubjectCode.equals(other.getModuleSubjectCode()))) &&
            ((this.moduleNumber==null && other.getModuleNumber()==null) || 
             (this.moduleNumber!=null &&
              this.moduleNumber.equals(other.getModuleNumber()))) &&
            ((this.moduleSite==null && other.getModuleSite()==null) || 
             (this.moduleSite!=null &&
              this.moduleSite.equals(other.getModuleSite()))) &&
            ((this.moduleOrgEnt==null && other.getModuleOrgEnt()==null) || 
             (this.moduleOrgEnt!=null &&
              this.moduleOrgEnt.equals(other.getModuleOrgEnt()))) &&
            ((this.methodOfDeliveryTypeKey==null && other.getMethodOfDeliveryTypeKey()==null) || 
             (this.methodOfDeliveryTypeKey!=null &&
              this.methodOfDeliveryTypeKey.equals(other.getMethodOfDeliveryTypeKey()))) &&
            ((this.modeOfDeliveryTypeKey==null && other.getModeOfDeliveryTypeKey()==null) || 
             (this.modeOfDeliveryTypeKey!=null &&
              this.modeOfDeliveryTypeKey.equals(other.getModeOfDeliveryTypeKey()))) &&
            ((this.startDate==null && other.getStartDate()==null) || 
             (this.startDate!=null &&
              this.startDate.equals(other.getStartDate()))) &&
            ((this.endDate==null && other.getEndDate()==null) || 
             (this.endDate!=null &&
              this.endDate.equals(other.getEndDate())));
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
        if (getAcademicPeriod() != null) {
            _hashCode += getAcademicPeriod().hashCode();
        }
        if (getModuleSubjectCode() != null) {
            _hashCode += getModuleSubjectCode().hashCode();
        }
        if (getModuleNumber() != null) {
            _hashCode += getModuleNumber().hashCode();
        }
        if (getModuleSite() != null) {
            _hashCode += getModuleSite().hashCode();
        }
        if (getModuleOrgEnt() != null) {
            _hashCode += getModuleOrgEnt().hashCode();
        }
        if (getMethodOfDeliveryTypeKey() != null) {
            _hashCode += getMethodOfDeliveryTypeKey().hashCode();
        }
        if (getModeOfDeliveryTypeKey() != null) {
            _hashCode += getModeOfDeliveryTypeKey().hashCode();
        }
        if (getStartDate() != null) {
            _hashCode += getStartDate().hashCode();
        }
        if (getEndDate() != null) {
            _hashCode += getEndDate().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ModuleOfferingSearchCriteriaInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "ModuleOfferingSearchCriteriaInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("academicPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "academicPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "AcademicPeriodInfo"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleSubjectCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleSubjectCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleSite");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleSite"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleOrgEnt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleOrgEnt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("methodOfDeliveryTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "methodOfDeliveryTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modeOfDeliveryTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modeOfDeliveryTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("startDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "startDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("endDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "endDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
