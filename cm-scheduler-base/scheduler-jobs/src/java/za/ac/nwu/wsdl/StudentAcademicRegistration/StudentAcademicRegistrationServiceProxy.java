package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class StudentAcademicRegistrationServiceProxy implements za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType {
  private String _endpoint = null;
  private za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType studentAcademicRegistrationService_PortType = null;
  
  public StudentAcademicRegistrationServiceProxy() {
    _initStudentAcademicRegistrationServiceProxy();
  }
  
  public StudentAcademicRegistrationServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initStudentAcademicRegistrationServiceProxy();
  }
  
  private void _initStudentAcademicRegistrationServiceProxy() {
    try {
      studentAcademicRegistrationService_PortType = (new za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_ServiceLocator()).getStudentAcademicRegistrationServicePort();
      if (studentAcademicRegistrationService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)studentAcademicRegistrationService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)studentAcademicRegistrationService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (studentAcademicRegistrationService_PortType != null)
      ((javax.xml.rpc.Stub)studentAcademicRegistrationService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType getStudentAcademicRegistrationService_PortType() {
    if (studentAcademicRegistrationService_PortType == null)
      _initStudentAcademicRegistrationServiceProxy();
    return studentAcademicRegistrationService_PortType;
  }
  
  public java.lang.String[] getStudentAcademicRegistrationByModuleOffering(za.ac.nwu.wsdl.StudentAcademicRegistration.ModuleOfferingSearchCriteriaInfo moduleOfferingSearchCriteriaInfo, za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo contextInfo) throws java.rmi.RemoteException, za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist, za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed, za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied{
    if (studentAcademicRegistrationService_PortType == null)
      _initStudentAcademicRegistrationServiceProxy();
    return studentAcademicRegistrationService_PortType.getStudentAcademicRegistrationByModuleOffering(moduleOfferingSearchCriteriaInfo, contextInfo);
  }
  
  public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[] getStudentAcademicRegistration(java.lang.String univNumber, za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriodInfo, za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo contextInfo) throws java.rmi.RemoteException, za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist, za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed, za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied{
    if (studentAcademicRegistrationService_PortType == null)
      _initStudentAcademicRegistrationServiceProxy();
    return studentAcademicRegistrationService_PortType.getStudentAcademicRegistration(univNumber, academicPeriodInfo, contextInfo);
  }
  
  
}