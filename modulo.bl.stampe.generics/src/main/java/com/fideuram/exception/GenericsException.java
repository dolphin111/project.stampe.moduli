package com.fideuram.exception;

/**
 * Created with
 * User: V801068
 * Date: 10/01/14
 * Time: 15.43
 */
public class GenericsException extends Exception  {

    public GenericsException() {
        super();
    }

    public GenericsException(Throwable arg0) {
        super(arg0);
    }


    public GenericsException(String message) {
        super(message);
    }

    public GenericsException(String message, Throwable cause) {
        super(message, cause);
    }
}
