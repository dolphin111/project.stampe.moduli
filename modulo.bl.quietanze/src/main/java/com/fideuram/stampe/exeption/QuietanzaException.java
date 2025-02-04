package com.fideuram.stampe.exeption;

/**
 * Created by
 * User: logan
 * Date: 18/02/13
 * Time: 15.23
 */
public class QuietanzaException extends Exception{
    public QuietanzaException() {
        super();
    }

    public QuietanzaException(String message) {
        super(message);
    }

    public QuietanzaException(String message,  Throwable cause) {
        super(message, cause);
    }
}
