/**
 * StudentAcademicModuleRegistrationInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class StudentAcademicModuleRegistrationInfo  extends za.ac.nwu.wsdl.StudentAcademicRegistration.StudentModuleAcademicInfo  implements java.io.Serializable {
    private java.util.Calendar moduleMethodOfDeliveryTypeKey;

    private java.util.Calendar modulePresentationCategoryTypeKey;

    public StudentAcademicModuleRegistrationInfo() {
    }

    public StudentAcademicModuleRegistrationInfo(
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
           java.lang.String univNumber,
           java.util.Calendar moduleMethodOfDeliveryTypeKey,
           java.util.Calendar modulePresentationCategoryTypeKey) {
        super(
            academicPeriod,
            exemption,
            exemptionTypeKey,
            module,
            moduleDescription,
            moduleDiscontinueDate,
            moduleDiscontinueReasonTypeKey,
            moduleRegistrationDate,
            moduleTypeTypeKey,
            program,
            qualification,
            repeatingModule,
            univNumber);
        this.moduleMethodOfDeliveryTypeKey = moduleMethodOfDeliveryTypeKey;
        this.modulePresentationCategoryTypeKey = modulePresentationCategoryTypeKey;
    }


    /**
     * Gets the moduleMethodOfDeliveryTypeKey value for this StudentAcademicModuleRegistrationInfo.
     * 
     * @return moduleMethodOfDeliveryTypeKey
     */
    public java.util.Calendar getModuleMethodOfDeliveryTypeKey() {
        return moduleMethodOfDeliveryTypeKey;
    }


    /**
     * Sets the moduleMethodOfDeliveryTypeKey value for this StudentAcademicModuleRegistrationInfo.
     * 
     * @param moduleMethodOfDeliveryTypeKey
     */
    public void setModuleMethodOfDeliveryTypeKey(java.util.Calendar moduleMethodOfDeliveryTypeKey) {
        this.moduleMethodOfDeliveryTypeKey = moduleMethodOfDeliveryTypeKey;
    }


    /**
     * Gets the modulePresentationCategoryTypeKey value for this StudentAcademicModuleRegistrationInfo.
     * 
     * @return modulePresentationCategoryTypeKey
     */
    public java.util.Calendar getModulePresentationCategoryTypeKey() {
        return modulePresentationCategoryTypeKey;
    }


    /**
     * Sets the modulePresentationCategoryTypeKey value for this StudentAcademicModuleRegistrationInfo.
     * 
     * @param modulePresentationCategoryTypeKey
     */
    public void setModulePresentationCategoryTypeKey(java.util.Calendar modulePresentationCategoryTypeKey) {
        this.modulePresentationCategoryTypeKey = modulePresentationCategoryTypeKey;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StudentAcademicModuleRegistrationInfo)) return false;
        StudentAcademicModuleRegistrationInfo other = (StudentAcademicModuleRegistrationInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.moduleMethodOfDeliveryTypeKey==null && other.getModuleMethodOfDeliveryTypeKey()==null) || 
             (this.moduleMethodOfDeliveryTypeKey!=null &&
              this.moduleMethodOfDeliveryTypeKey.equals(other.getModuleMethodOfDeliveryTypeKey()))) &&
            ((this.modulePresentationCategoryTypeKey==null && other.getModulePresentationCategoryTypeKey()==null) || 
             (this.modulePresentationCategoryTypeKey!=null &&
              this.modulePresentationCategoryTypeKey.equals(other.getModulePresentationCategoryTypeKey())));
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
        if (getModuleMethodOfDeliveryTypeKey() != null) {
            _hashCode += getModuleMethodOfDeliveryTypeKey().hashCode();
        }
        if (getModulePresentationCategoryTypeKey() != null) {
            _hashCode += getModulePresentationCategoryTypeKey().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StudentAcademicModuleRegistrationInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicModuleRegistrationInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("moduleMethodOfDeliveryTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "moduleMethodOfDeliveryTypeKey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modulePresentationCategoryTypeKey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modulePresentationCategoryTypeKey"));
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
