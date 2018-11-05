/**
 * StudentAcademicRegistrationServiceSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package za.ac.nwu.wsdl.StudentAcademicRegistration;

public class StudentAcademicRegistrationServiceSoapBindingStub extends org.apache.axis.client.Stub implements za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationService_PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[2];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getStudentAcademicRegistrationByModuleOffering");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "moduleOfferingSearchCriteriaInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "ModuleOfferingSearchCriteriaInfo"), za.ac.nwu.wsdl.StudentAcademicRegistration.ModuleOfferingSearchCriteriaInfo.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contextInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "ContextInfo"), za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "InvalidParameter"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "InvalidParameter"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "DoesNotExist"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "DoesNotExist"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "OperationFailed"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "OperationFailed"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "MissingParameter"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "MissingParameter"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "PermissionDenied"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "PermissionDenied"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getStudentAcademicRegistration");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "univNumber"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "academicPeriodInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "AcademicPeriodInfo"), za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "contextInfo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "ContextInfo"), za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicRegistrationInfo"));
        oper.setReturnClass(za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "InvalidParameter"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "InvalidParameter"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "DoesNotExist"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "DoesNotExist"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "OperationFailed"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "OperationFailed"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "MissingParameter"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "MissingParameter"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "PermissionDenied"),
                      "za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied",
                      new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "PermissionDenied"), 
                      true
                     ));
        _operations[1] = oper;

    }

    public StudentAcademicRegistrationServiceSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public StudentAcademicRegistrationServiceSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public StudentAcademicRegistrationServiceSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "AcademicPeriodInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "AttributeInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.AttributeInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "ContextInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "DoesNotExist");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "InvalidParameter");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "MissingParameter");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "ModuleOfferingSearchCriteriaInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.ModuleOfferingSearchCriteriaInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "OperationFailed");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "PermissionDenied");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicModuleRegistrationInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicModuleRegistrationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicQualificationInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicQualificationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentAcademicRegistrationInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "studentModuleAcademicInfo");
            cachedSerQNames.add(qName);
            cls = za.ac.nwu.wsdl.StudentAcademicRegistration.StudentModuleAcademicInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public java.lang.String[] getStudentAcademicRegistrationByModuleOffering(za.ac.nwu.wsdl.StudentAcademicRegistration.ModuleOfferingSearchCriteriaInfo moduleOfferingSearchCriteriaInfo, za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo contextInfo) throws java.rmi.RemoteException, za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist, za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed, za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "getStudentAcademicRegistrationByModuleOffering"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {moduleOfferingSearchCriteriaInfo, contextInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String[]) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[] getStudentAcademicRegistration(java.lang.String univNumber, za.ac.nwu.wsdl.StudentAcademicRegistration.AcademicPeriodInfo academicPeriodInfo, za.ac.nwu.wsdl.StudentAcademicRegistration.ContextInfo contextInfo) throws java.rmi.RemoteException, za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist, za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed, za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter, za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://nwu.ac.za/wsdl/StudentAcademicRegistration", "getStudentAcademicRegistration"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {univNumber, academicPeriodInfo, contextInfo});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[]) org.apache.axis.utils.JavaUtils.convert(_resp, za.ac.nwu.wsdl.StudentAcademicRegistration.StudentAcademicRegistrationInfo[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.InvalidParameter) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.DoesNotExist) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.OperationFailed) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.MissingParameter) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied) {
              throw (za.ac.nwu.wsdl.StudentAcademicRegistration.PermissionDenied) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
