package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 02/10/12
 * Time: 14.49
 */
public class ObjectOutOfTargetException extends Exception{


    public ObjectOutOfTargetException() {
        super();
    }


    public ObjectOutOfTargetException(String message) {
        super(message);
    }

    public ObjectOutOfTargetException(String message, Throwable cause) {
        super(message, cause);
    }

}
