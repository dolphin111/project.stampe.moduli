package com.fideuram.stampe.exeption;

/**
 * Created by
 * User: emrossi
 * Date: 07/04/14
 * Time: 9:02
 */
@SuppressWarnings("serial")
public class CorrispondenzaException extends Exception{
    public CorrispondenzaException() {
        super();
    }

    public CorrispondenzaException(String message) {
        super(message);
    }

    public CorrispondenzaException(String message,  Throwable cause) {
        super(message, cause);
    }
}
