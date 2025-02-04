package com.fideuram.exception;

public class ConguaglioException extends Exception{
    public ConguaglioException() {
        super();
    }

    public ConguaglioException(String message) {
        super(message);
    }

    public ConguaglioException(String message, Throwable cause) {
        super(message, cause);
    }
}
