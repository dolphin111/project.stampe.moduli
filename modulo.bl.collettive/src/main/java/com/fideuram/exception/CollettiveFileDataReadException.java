package com.fideuram.exception;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 09/05/13
 * Time: 9.43
 */
public class CollettiveFileDataReadException extends Exception{
    public CollettiveFileDataReadException() {
        super();
    }


    public CollettiveFileDataReadException(String message) {
        super(message);
    }

    public CollettiveFileDataReadException(String message,  Throwable cause) {
        super(message, cause);
    }
}
