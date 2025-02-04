package com.fideuram.stampeservice;

import javax.xml.ws.WebFault;

/**
 * Created by
 * User: logan
 * Date: 28/02/12
 * Time: 19.02
 */
//@WebFault(name = "com.fideuram.stampeservice.exception.ConverterException", targetNamespace = "http://com.fideuram.stampeservice.exception/fault")

@WebFault(name="com.fideuram.stampeservice.StampeWsException", faultBean = "com.fideuram.stampeservice.FaultBean")
public class StampeWsException extends Exception {

    private static final long serialVersionUID = 1L;

    private FaultBean faultBean;

    public StampeWsException() {
        super();
    }

    public StampeWsException(String message, FaultBean faultBean, Throwable cause) {
        super(message, cause);
        this.faultBean = faultBean;
    }

    public StampeWsException(String message, FaultBean faultBean) {
        super(message);
        this.faultBean = faultBean;
    }

    public FaultBean getFaultInfo() {
        return faultBean;
    }
}