/**
 * StudentModuleAcademicInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class StudentModuleAcademicInfo  implements java.io.Serializable {
    private za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod;

    private boolean exemption;

    private boolean exemptionTypeKey;

    private java.lang.String module;

    private java.lang.String moduleDescription;

    private java.util.Calendar moduleDiscontinueDate;

    private java.util.Calendar moduleDiscontinueReasonTypeKey;

    private java.util.Calendar moduleRegistrationDate;

    private java.util.Calendar moduleTypeTypeKey;

    private java.lang.String program;

    private java.lang.String qualification;

    private boolean repeatingModule;

    private java.lang.String univNumber;

    public StudentModuleAcademicInfo() {
    }

    public StudentModuleAcademicInfo(
           za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod,
           boolean exemption,
           boolean exemptionTypeKey,
           java.lang.String module,
           java.lang.String moduleDescription,
           java.util.Calendar moduleDiscontinueDate,
           java.util.Calendar moduleDiscontinueReasonTypeKey,
           java.util.Calendar moduleRegistrationDate,
           java.util.Calendar moduleTypeTypeKey,
           java.lang.String program,
           java.lang.String qualification,
           boolean repeatingModule,
           java.lang.String univNumber) {
           this.academicPeriod = academicPeriod;
           this.exemption = exemption;
           this.exemptionTypeKey = exemptionTypeKey;
           this.module = module;
           this.moduleDescription = moduleDescription;
           this.moduleDiscontinueDate = moduleDiscontinueDate;
           this.moduleDiscontinueReasonTypeKey = moduleDiscontinueReasonTypeKey;
           this.moduleRegistrationDate = moduleRegistrationDate;
           this.moduleTypeTypeKey = moduleTypeTypeKey;
           this.program = program;
           this.qualification = qualification;
           this.repeatingModule = repeatingModule;
           this.univNumber = univNumber;
    }


    /**
     * Gets the academicPeriod value for this StudentModuleAcademicInfo.
     * 
     * @return academicPeriod
     */
    public za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo getAcademicPeriod() {
        return academicPeriod;
    }


    /**
     * Sets the academicPeriod value for this StudentModuleAcademicInfo.
     * 
     * @param academicPeriod
     */
    public void setAcademicPeriod(za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod) {
        this.academicPeriod = academicPeriod;
    }


    /**
     * Gets the exemption value for this StudentModuleAcademicInfo.
     * 
     * @return exemption
     */
    public boolean isExemption() {
        return exemption;
    }


    /**
     * Sets the exemption value for this StudentModuleAcademicInfo.
     * 
     * @param exemption
     */
    public void setExemption(boolean exemption) {
        this.exemption = exemption;
    }


    /**
     * Gets the exemptionTypeKey value for this StudentModuleAcademicInfo.
     * 
     * @return exemptionTypeKey
     */
    public boolean isExemptionTypeKey() {
        return exemptionTypeKey;
    }


    /**
     * Sets the exemptionTypeKey value for this StudentModuleAcademicInfo.
     * 
     * @param exemptionTypeKey
     */
    public void setExemptionTypeKey(boolean exemptionTypeKey) {
        this.exemptionTypeKey = exemptionTypeKey;
    }


    /**
     * Gets the module value for this StudentModuleAcademicInfo.
     * 
     * @return module
     */
    public java.lang.String getModule() {
        return module;
    }


    /**
     * Sets the module value for this StudentModuleAcademicInfo.
     * 
     * @param module
     */
    public void setModule(java.lang.String module) {
        this.module = module;
    }


    /**
     * Gets the moduleDescription value for this StudentModuleAcademicInfo.
     * 
     * @return moduleDescription
     */
    public java.lang.String getModuleDescription() {
        return moduleDescription;
    }


    /**
     * Sets the moduleDescription value for this StudentModuleAcademicInfo.
     * 
     * @param moduleDescription
     */
    public void setModuleDescription(java.lang.String moduleDescription) {
        this.moduleDescription = moduleDescription;
    }


    /**
     * Gets the moduleDiscontinueDate value for this StudentModuleAcademicInfo.
     * 
     * @return moduleDiscontinueDate
     */
    public java.util.Calendar getModuleDiscontinueDate() {
        return moduleDiscontinueDate;
    }


    /**
     * Sets the moduleDiscontinueDate value for this StudentModuleAcademicInfo.
     * 
     * @param moduleDiscontinueDate
     */
    public void setModuleDiscontinueDate(java.util.Calendar moduleDiscontinueDate) {
        this.moduleDiscontinueDate = moduleDiscontinueDate;
    }


    /**
     * Gets the moduleDiscontinueReasonTypeKey value for this StudentModuleAcademicInfo.
     * 
     * @return moduleDiscontinueReasonTypeKey
     */
    public java.util.Calendar getModuleDiscontinueReasonTypeKey() {
        return moduleDiscontinueReasonTypeKey;
    }


    /**
     * Sets the moduleDiscontinueReasonTypeKey value for this StudentModuleAcademicInfo.
     * 
     * @param moduleDiscontinueReasonTypeKey
     */
    public void setModuleDiscontinueReasonTypeKey(java.util.Calendar moduleDiscontinueReasonTypeKey) {
        this.moduleDiscontinueReasonTypeKey = moduleDiscontinueReasonTypeKey;
    }


    /**
     * Gets the moduleRegistrationDate value for this StudentModuleAcademicInfo.
     * 
     * @return moduleRegistrationDate
     */
    public java.util.Calendar getModuleRegistrationDate() {
        return moduleRegistrationDate;
    }


    /**
     * Sets the moduleRegistrationDate value for this StudentModuleAcademicInfo.
     * 
     * @param moduleRegistrationDate
     */
    public void setModuleRegistrationDate(java.util.Calendar moduleRegistrationDate) {
        this.moduleRegistrationDate = moduleRegistrationDate;
    }


    /**
     * Gets the moduleTypeTypeKey value for this StudentModuleAcademicInfo.
     * 
     * @return moduleTypeTypeKey
     */
    public java.util.Calendar getModuleTypeTypeKey() {
        return moduleTypeTypeKey;
    }


    /**
     * Sets the moduleTypeTypeKey value for this StudentModuleAcademicInfo.
     * 
     * @param moduleTypeTypeKey
     */
    public void setModuleTypeTypeKey(java.util.Calendar moduleTypeTypeKey) {
        this.moduleTypeTypeKey = moduleTypeTypeKey;
    }


    /**
     * Gets the program value for this StudentModuleAcademicInfo.
     * 
     * @return program
     */
    public java.lang.String getProgram() {
        return program;
    }


    /**
     * Sets the program value for this StudentModuleAcademicInfo.
     * 
     * @param program
     */
    public void setProgram(java.lang.String program) {
        this.program = program;
    }


    /**
     * Gets the qualification value for this StudentModuleAcademicInfo.
     * 
     * @return qualification
     */
    public java.lang.String getQualification() {
        return qualification;
    }


    /**
     * Sets the qualification value for this StudentModuleAcademicInfo.
     * 
     * @param qualification
     */
    public void setQualification(java.lang.String qualification) {
        this.qualification = qualification;
    }


    /**
     * Gets the repeatingModule value for this StudentModuleAcademicInfo.
     * 
     * @return repeatingModule
     */
    public boolean isRepeatingModule() {
        return repeatingModule;
    }


    /**
     * Sets the repeatingModule value for this StudentModuleAcademicInfo.
     * 
     * @param repeatingModule
     */
    public void setRepeatingModule(boolean repeatingModule) {
        this.repeatingModule = repeatingModule;
    }


    /**
     * Gets the univNumber value for this StudentModuleAcademicInfo.
     * 
     * @return univNumber
     */
    public java.lang.String getUnivNumber() {
        return univNumber;
    }


    /**
     * Sets the univNumber value for this StudentModuleAcademicInfo.
     * 
     * @param univNumber
     */
    public void setUnivNumber(java.lang.String univNumber) {
        this.univNumber = univNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StudentModuleAcademicInfo)) return false;
        StudentModuleAcademicInfo other = (StudentModuleAcademicInfo) obj;
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
            this.exemption == other.isExemption() &&
            this.exemptionTypeKey == other.isExemptionTypeKey() &&
            ((this.module==null && other.getModule()==null) || 
             (this.module!=null &&
              this.module.equals(other.getModule()))) &&
            ((this.moduleDescription==null && other.getModuleDescription()==null) || 
             (this.moduleDescription!=null &&
              this.moduleDescription.equals(other.getModuleDescription()))) &&
            ((this.moduleDiscontinueDate==null && other.getModuleDiscontinueDate()==null) || 
             (this.moduleDiscontinueDate!=null &&
              this.moduleDiscontinueDate.equals(other.getModuleDiscontinueDate()))) &&
            ((this.moduleDiscontinueReasonTypeKey==null && other.getModuleDiscontinueReasonTypeKey()==null) || 
             (this.moduleDiscontinueReasonTypeKey!=null &&
              this.moduleDiscontinueReasonTypeKey.equals(other.getModuleDiscontinueReasonTypeKey()))) &&
            ((this.moduleRegistrationDate==null && other.getModuleRegistrationDate()==null) || 
             (this.moduleRegistrationDate!=null &&
              this.moduleRegistrationDate.equals(other.getModuleRegistrationDate()))) &&
            ((this.moduleTypeTypeKey==null && other.getModuleTypeTypeKey()==null) || 
             (this.moduleTypeTypeKey!=null &&
              this.moduleTypeTypeKey.equals(other.getModuleTypeTypeKey()))) &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            ((this.qualification==null && other.getQualification()==null) || 
             (this.qualification!=null &&
              this.qualification.equals(other.getQualification()))) &&
            this.repeatingModule == other.isRepeatingModule() &&
            ((this.univNumber==null && other.getUnivNumber()==null) || 
             (this.univNumber!=null &&
              this.univNumber.equals(other.getUnivNumber())));
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
        _hashCode += (isExemption() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        _hashCode += (isExemptionTypeKey() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getModule() != null) {
            _hashCode += getModule().hashCode();
        }
        if (getModuleDescription() != null) {
            _hashCode += getModuleDescription().hashCode();
        }
        if (getModuleDiscontinueDate() != null) {
            _hashCode += getModuleDiscontinueDate().hashCode();
        }
        if (getModuleDiscontinueReasonTypeKey() != null) {
            _hashCode += getModuleDiscontinueReasonTypeKey().hashCode();
        }
        if (getModuleRegistrationDate() != null) {
            _hashCode += getModuleRegistrationDate().hashCode();
        }
        if (getModuleTypeTypeKey() != null) {
            _hashCode += getModuleTypeTypeKey().hashCode();
        }
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        if (getQualification() != null) {
            _hashCode += getQualification().hashCode();
        }
        _hashCode += (isRepeatingModule() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getUnivNumber() != null) {
            _hashCode += getUnivNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StudentModuleAcademicInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentModuleAcademicInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("academicPeriod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "academicPeriod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "AcademicPeriodInfo"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exemption");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exemption"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("exemptionTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "exemptionTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("module");
        elemField.setXmlName(new javax.xml.namespace.QName("", "module"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleDescription");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleDescription"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleDiscontinueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleDiscontinueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleDiscontinueReasonTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleDiscontinueReasonTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleRegistrationDate");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleRegistrationDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleTypeTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleTypeTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("program");
        elemField.setXmlName(new javax.xml.namespace.QName("", "program"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("qualification");
        elemField.setXmlName(new javax.xml.namespace.QName("", "qualification"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("repeatingModule");
        elemField.setXmlName(new javax.xml.namespace.QName("", "repeatingModule"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("univNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("", "univNumber"));
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
