package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 18.01
 */
public class DisplayPolizzaException extends Exception{
    public DisplayPolizzaException() {
        super();
    }


    public DisplayPolizzaException(String message) {
        super(message);
    }

    public DisplayPolizzaException(String message,  Throwable cause) {
        super(message, cause);
    }
}
