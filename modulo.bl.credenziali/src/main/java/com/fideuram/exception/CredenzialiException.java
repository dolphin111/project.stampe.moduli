package com.fideuram.exception;

/**
 * User: V801068
 * Date: 01/02/16
 * Time: 12.29
 */
public class CredenzialiException  extends Exception{
    public CredenzialiException() {
        super();
    }

    public CredenzialiException(Throwable arg0) {
        super(arg0);
    }


    public CredenzialiException(String message) {
        super(message);
    }

    public CredenzialiException(String message, Throwable cause) {
        super(message, cause);
    }
}
