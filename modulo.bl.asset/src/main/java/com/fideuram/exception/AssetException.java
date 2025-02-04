package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 18.01
 */
public class AssetException extends Exception{
    public AssetException() {
        super();
    }


    public AssetException(String message) {
        super(message);
    }

    public AssetException(String message,  Throwable cause) {
        super(message, cause);
    }
}
