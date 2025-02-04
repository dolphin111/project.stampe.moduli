package com.fideuram.preventivo.exception;

/**
 * Created by
 * User: logan
 * Date: 15/03/13
 * Time: 15.24
 */
public class PreventivoException  extends Exception{
    public PreventivoException() {
        super();
    }

    public PreventivoException(String message) {
        super(message);
    }

    public PreventivoException(String message,  Throwable cause) {
        super(message, cause);
    }
}
