package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 02/10/12
 * Time: 16.28
 */
public class ProspettoDiOffertaException extends Exception{

    public ProspettoDiOffertaException() {
        super();
    }


    public ProspettoDiOffertaException(String message) {
        super(message);
    }

    public ProspettoDiOffertaException(String message,  Throwable cause) {
        super(message, cause);
    }
}
