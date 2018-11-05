/**
 * StudentAcademicRegistrationService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class StudentAcademicRegistrationService_ServiceLocator extends org.apache.axis.client.Service implements za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_Service {

    public StudentAcademicRegistrationService_ServiceLocator() {
    }


    public StudentAcademicRegistrationService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public StudentAcademicRegistrationService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for StudentAcademicRegistrationServicePort
    private java.lang.String StudentAcademicRegistrationServicePort_address = "http://workflowprd.nwu.ac.za:80/sapi-vss-v4/StudentAcademicRegistrationService/StudentAcademicRegistrationService";

    public java.lang.String getStudentAcademicRegistrationServicePortAddress() {
        return StudentAcademicRegistrationServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String StudentAcademicRegistrationServicePortWSDDServiceName = "StudentAcademicRegistrationServicePort";

    public java.lang.String getStudentAcademicRegistrationServicePortWSDDServiceName() {
        return StudentAcademicRegistrationServicePortWSDDServiceName;
    }

    public void setStudentAcademicRegistrationServicePortWSDDServiceName(java.lang.String name) {
        StudentAcademicRegistrationServicePortWSDDServiceName = name;
    }

    public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType getStudentAcademicRegistrationServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(StudentAcademicRegistrationServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getStudentAcademicRegistrationServicePort(endpoint);
    }

    public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType getStudentAcademicRegistrationServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationServiceSoapBindingStub _stub = new za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getStudentAcademicRegistrationServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setStudentAcademicRegistrationServicePortEndpointAddress(java.lang.String address) {
        StudentAcademicRegistrationServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationServiceSoapBindingStub _stub = new za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationServiceSoapBindingStub(new java.net.URL(StudentAcademicRegistrationServicePort_address), this);
                _stub.setPortName(getStudentAcademicRegistrationServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("StudentAcademicRegistrationServicePort".equals(inputPortName)) {
            return getStudentAcademicRegistrationServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "StudentAcademicRegistrationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "StudentAcademicRegistrationServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("StudentAcademicRegistrationServicePort".equals(portName)) {
            setStudentAcademicRegistrationServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
