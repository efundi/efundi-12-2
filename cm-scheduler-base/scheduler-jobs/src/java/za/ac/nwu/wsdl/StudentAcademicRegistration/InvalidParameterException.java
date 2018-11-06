
package za.ac.nwu.wsdl.StudentAcademicRegistration;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "InvalidParameter", targetNamespace = "http://nwu.ac.za/wsdl/StudentAcademicRegistration")
public class InvalidParameterException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private InvalidParameter faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public InvalidParameterException(String message, InvalidParameter faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public InvalidParameterException(String message, InvalidParameter faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: za.ac.nwu.wsdl.studentacademicregistration.InvalidParameter
     */
    public InvalidParameter getFaultInfo() {
        return faultInfo;
    }

}
