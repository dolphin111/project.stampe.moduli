package com.fideuram.exceptions;

/**
 * User: V801068
 * Date: 21/01/15
 * Time: 11.28
 */
public class ValidationException extends Exception {
    public ValidationException() { }

    public ValidationException(String message) {
        super(message);
    }
  
    public ValidationException(Throwable cause) {
        super(cause);
    }
}
