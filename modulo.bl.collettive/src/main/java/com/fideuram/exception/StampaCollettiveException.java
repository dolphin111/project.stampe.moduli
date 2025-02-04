package com.fideuram.exception;

/**
 * Created with
 * User: logan
 * Date: 15/05/13
 * Time: 11.49
 */
public class StampaCollettiveException extends Exception{
    public StampaCollettiveException() {
        super();
    }


    public StampaCollettiveException(String message) {
        super(message);
    }

    public StampaCollettiveException(String message,  Throwable cause) {
        super(message, cause);
    }
}
