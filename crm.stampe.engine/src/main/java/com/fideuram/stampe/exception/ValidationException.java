package com.fideuram.stampe.exception;

/**
 * Created by V801068 on 09/05/14.
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
