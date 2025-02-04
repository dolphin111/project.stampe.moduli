package exception;

import javax.xml.ws.WebFault;

/**
 * Created by
 * User: logan
 * Date: 28/02/12
 * Time: 19.02
 */
//@WebFault(name = "exception.ConverterException", targetNamespace = "http://exception/fault")

@WebFault(name="exception.GraficiWsException", faultBean = "exception.FaultBean")
public class GraficiWsException extends Exception {

    private static final long serialVersionUID = 1L;

    private FaultBean faultBean;

    public GraficiWsException() {
        super();
    }

    public GraficiWsException(String message, FaultBean faultBean, Throwable cause) {
        super(message, cause);
        this.faultBean = faultBean;
    }

    public GraficiWsException(String message, FaultBean faultBean) {
        super(message);
        this.faultBean = faultBean;
    }

    public FaultBean getFaultInfo() {
        return faultBean;
    }
}