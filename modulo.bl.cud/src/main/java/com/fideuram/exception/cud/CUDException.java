package com.fideuram.exception.cud;

/**
 * Created by
 * User: logan
 * Date: 18/02/13
 * Time: 15.23
 */
public class CUDException extends Exception{
    public CUDException() {
        super();
    }

    public CUDException(String message) {
        super(message);
    }

    public CUDException(String message,  Throwable cause) {
        super(message, cause);
    }
}
