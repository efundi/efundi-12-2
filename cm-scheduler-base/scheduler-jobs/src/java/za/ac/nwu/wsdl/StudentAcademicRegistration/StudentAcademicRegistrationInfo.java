/**
 * StudentAcademicRegistrationInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class StudentAcademicRegistrationInfo  extends za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicQualificationInfo  implements java.io.Serializable {
    private za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicModuleRegistrationInfo studAcadModReg;

    private java.lang.String registrationStatusTypeKey;

    private int numberOfModulesEnrolled;

    private int numberOfRepeatModulesEnrolled;

    private int numberOfModulesDiscontinued;

    private int numberOfModulesExcempted;

    private int numberOfModulesRecognition;

    private java.lang.String entryLevel;

    private java.lang.String studyType;

    public StudentAcademicRegistrationInfo() {
    }

    public StudentAcademicRegistrationInfo(
           za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriod,
           int academicYears,
           int historicYears,
           boolean mainQualification,
           java.lang.String program,
           java.lang.String programDesc,
           java.lang.String programMethodOfDeliveryTypeKey,
           java.lang.String programPresentationCategoryTypeKey,
           java.lang.String qualification,
           java.lang.String qualificationDesc,
           java.util.Calendar qualificationDiscontinueDate,
           java.lang.String qualificationDiscontinueReasonTypeKey,
           java.lang.String qualificationFaculty,
           java.lang.String qualificationMethodOfDeliveryTypeKey,
           java.lang.String qualificationPresentationCategoryTypeKey,
           java.util.Calendar qualificationRegistrationDate,
           java.lang.String qualificationResultTypeKey,
           java.lang.String qualificationSite,
           java.util.Calendar qualificationStartDate,
           java.lang.String univNumber,
           za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicModuleRegistrationInfo studAcadModReg,
           java.lang.String registrationStatusTypeKey,
           int numberOfModulesEnrolled,
           int numberOfRepeatModulesEnrolled,
           int numberOfModulesDiscontinued,
           int numberOfModulesExcempted,
           int numberOfModulesRecognition,
           java.lang.String entryLevel,
           java.lang.String studyType) {
        super(
            academicPeriod,
            academicYears,
            historicYears,
            mainQualification,
            program,
            programDesc,
            programMethodOfDeliveryTypeKey,
            programPresentationCategoryTypeKey,
            qualification,
            qualificationDesc,
            qualificationDiscontinueDate,
            qualificationDiscontinueReasonTypeKey,
            qualificationFaculty,
            qualificationMethodOfDeliveryTypeKey,
            qualificationPresentationCategoryTypeKey,
            qualificationRegistrationDate,
            qualificationResultTypeKey,
            qualificationSite,
            qualificationStartDate,
            univNumber);
        this.studAcadModReg = studAcadModReg;
        this.registrationStatusTypeKey = registrationStatusTypeKey;
        this.numberOfModulesEnrolled = numberOfModulesEnrolled;
        this.numberOfRepeatModulesEnrolled = numberOfRepeatModulesEnrolled;
        this.numberOfModulesDiscontinued = numberOfModulesDiscontinued;
        this.numberOfModulesExcempted = numberOfModulesExcempted;
        this.numberOfModulesRecognition = numberOfModulesRecognition;
        this.entryLevel = entryLevel;
        this.studyType = studyType;
    }


    /**
     * Gets the studAcadModReg value for this StudentAcademicRegistrationInfo.
     * 
     * @return studAcadModReg
     */
    public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicModuleRegistrationInfo getStudAcadModReg() {
        return studAcadModReg;
    }


    /**
     * Sets the studAcadModReg value for this StudentAcademicRegistrationInfo.
     * 
     * @param studAcadModReg
     */
    public void setStudAcadModReg(za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicModuleRegistrationInfo studAcadModReg) {
        this.studAcadModReg = studAcadModReg;
    }


    /**
     * Gets the registrationStatusTypeKey value for this StudentAcademicRegistrationInfo.
     * 
     * @return registrationStatusTypeKey
     */
    public java.lang.String getRegistrationStatusTypeKey() {
        return registrationStatusTypeKey;
    }


    /**
     * Sets the registrationStatusTypeKey value for this StudentAcademicRegistrationInfo.
     * 
     * @param registrationStatusTypeKey
     */
    public void setRegistrationStatusTypeKey(java.lang.String registrationStatusTypeKey) {
        this.registrationStatusTypeKey = registrationStatusTypeKey;
    }


    /**
     * Gets the numberOfModulesEnrolled value for this StudentAcademicRegistrationInfo.
     * 
     * @return numberOfModulesEnrolled
     */
    public int getNumberOfModulesEnrolled() {
        return numberOfModulesEnrolled;
    }


    /**
     * Sets the numberOfModulesEnrolled value for this StudentAcademicRegistrationInfo.
     * 
     * @param numberOfModulesEnrolled
     */
    public void setNumberOfModulesEnrolled(int numberOfModulesEnrolled) {
        this.numberOfModulesEnrolled = numberOfModulesEnrolled;
    }


    /**
     * Gets the numberOfRepeatModulesEnrolled value for this StudentAcademicRegistrationInfo.
     * 
     * @return numberOfRepeatModulesEnrolled
     */
    public int getNumberOfRepeatModulesEnrolled() {
        return numberOfRepeatModulesEnrolled;
    }


    /**
     * Sets the numberOfRepeatModulesEnrolled value for this StudentAcademicRegistrationInfo.
     * 
     * @param numberOfRepeatModulesEnrolled
     */
    public void setNumberOfRepeatModulesEnrolled(int numberOfRepeatModulesEnrolled) {
        this.numberOfRepeatModulesEnrolled = numberOfRepeatModulesEnrolled;
    }


    /**
     * Gets the numberOfModulesDiscontinued value for this StudentAcademicRegistrationInfo.
     * 
     * @return numberOfModulesDiscontinued
     */
    public int getNumberOfModulesDiscontinued() {
        return numberOfModulesDiscontinued;
    }


    /**
     * Sets the numberOfModulesDiscontinued value for this StudentAcademicRegistrationInfo.
     * 
     * @param numberOfModulesDiscontinued
     */
    public void setNumberOfModulesDiscontinued(int numberOfModulesDiscontinued) {
        this.numberOfModulesDiscontinued = numberOfModulesDiscontinued;
    }


    /**
     * Gets the numberOfModulesExcempted value for this StudentAcademicRegistrationInfo.
     * 
     * @return numberOfModulesExcempted
     */
    public int getNumberOfModulesExcempted() {
        return numberOfModulesExcempted;
    }


    /**
     * Sets the numberOfModulesExcempted value for this StudentAcademicRegistrationInfo.
     * 
     * @param numberOfModulesExcempted
     */
    public void setNumberOfModulesExcempted(int numberOfModulesExcempted) {
        this.numberOfModulesExcempted = numberOfModulesExcempted;
    }


    /**
     * Gets the numberOfModulesRecognition value for this StudentAcademicRegistrationInfo.
     * 
     * @return numberOfModulesRecognition
     */
    public int getNumberOfModulesRecognition() {
        return numberOfModulesRecognition;
    }


    /**
     * Sets the numberOfModulesRecognition value for this StudentAcademicRegistrationInfo.
     * 
     * @param numberOfModulesRecognition
     */
    public void setNumberOfModulesRecognition(int numberOfModulesRecognition) {
        this.numberOfModulesRecognition = numberOfModulesRecognition;
    }


    /**
     * Gets the entryLevel value for this StudentAcademicRegistrationInfo.
     * 
     * @return entryLevel
     */
    public java.lang.String getEntryLevel() {
        return entryLevel;
    }


    /**
     * Sets the entryLevel value for this StudentAcademicRegistrationInfo.
     * 
     * @param entryLevel
     */
    public void setEntryLevel(java.lang.String entryLevel) {
        this.entryLevel = entryLevel;
    }


    /**
     * Gets the studyType value for this StudentAcademicRegistrationInfo.
     * 
     * @return studyType
     */
    public java.lang.String getStudyType() {
        return studyType;
    }


    /**
     * Sets the studyType value for this StudentAcademicRegistrationInfo.
     * 
     * @param studyType
     */
    public void setStudyType(java.lang.String studyType) {
        this.studyType = studyType;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StudentAcademicRegistrationInfo)) return false;
        StudentAcademicRegistrationInfo other = (StudentAcademicRegistrationInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.studAcadModReg==null && other.getStudAcadModReg()==null) || 
             (this.studAcadModReg!=null &&
              this.studAcadModReg.equals(other.getStudAcadModReg()))) &&
            ((this.registrationStatusTypeKey==null && other.getRegistrationStatusTypeKey()==null) || 
             (this.registrationStatusTypeKey!=null &&
              this.registrationStatusTypeKey.equals(other.getRegistrationStatusTypeKey()))) &&
            this.numberOfModulesEnrolled == other.getNumberOfModulesEnrolled() &&
            this.numberOfRepeatModulesEnrolled == other.getNumberOfRepeatModulesEnrolled() &&
            this.numberOfModulesDiscontinued == other.getNumberOfModulesDiscontinued() &&
            this.numberOfModulesExcempted == other.getNumberOfModulesExcempted() &&
            this.numberOfModulesRecognition == other.getNumberOfModulesRecognition() &&
            ((this.entryLevel==null && other.getEntryLevel()==null) || 
             (this.entryLevel!=null &&
              this.entryLevel.equals(other.getEntryLevel()))) &&
            ((this.studyType==null && other.getStudyType()==null) || 
             (this.studyType!=null &&
              this.studyType.equals(other.getStudyType())));
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
        if (getStudAcadModReg() != null) {
            _hashCode += getStudAcadModReg().hashCode();
        }
        if (getRegistrationStatusTypeKey() != null) {
            _hashCode += getRegistrationStatusTypeKey().hashCode();
        }
        _hashCode += getNumberOfModulesEnrolled();
        _hashCode += getNumberOfRepeatModulesEnrolled();
        _hashCode += getNumberOfModulesDiscontinued();
        _hashCode += getNumberOfModulesExcempted();
        _hashCode += getNumberOfModulesRecognition();
        if (getEntryLevel() != null) {
            _hashCode += getEntryLevel().hashCode();
        }
        if (getStudyType() != null) {
            _hashCode += getStudyType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StudentAcademicRegistrationInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicRegistrationInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("studAcadModReg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "studAcadModReg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicModuleRegistrationInfo"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("registrationStatusTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "registrationStatusTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfModulesEnrolled");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfModulesEnrolled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfRepeatModulesEnrolled");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfRepeatModulesEnrolled"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfModulesDiscontinued");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfModulesDiscontinued"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfModulesExcempted");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfModulesExcempted"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numberOfModulesRecognition");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numberOfModulesRecognition"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entryLevel");
        elemField.setXmlName(new javax.xml.namespace.QName("", "entryLevel"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("studyType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "studyType"));
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
