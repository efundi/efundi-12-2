/**
 * StudentAcademicRegistrationService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public interface StudentAcademicRegistrationService_PortType extends java.rmi.Remote {
    public java.lang.String[] getStudentAcademicRegistrationByModuleOffering(za.ac.nwu.wsdl.StudentAcademicRegistration.ModuleOfferingSearchCriteriaInfo moduleOfferingSearchCriteriaInfo, za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo contextInfo) throws java.rmi.RemoteException, za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist, za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed, za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied;
    public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[] getStudentAcademicRegistration(java.lang.String univNumber, za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriodInfo, za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo contextInfo) throws java.rmi.RemoteException, za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist, za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed, za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied;
}
