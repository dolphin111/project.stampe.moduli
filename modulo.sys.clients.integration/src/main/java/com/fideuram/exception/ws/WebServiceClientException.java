package com.fideuram.exception.ws;

/**
 * Created by
 * User: logan
 * Date: 20/03/12
 * Time: 9.11
 */
public class WebServiceClientException  extends Exception {
    /**
     *
     */
    private static final long serialVersionUID = -4609883780927182467L;

    /**
     *
     */
    public WebServiceClientException() {
    }

    /**
     * @param arg0
     */
    public WebServiceClientException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public WebServiceClientException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public WebServiceClientException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }


}
