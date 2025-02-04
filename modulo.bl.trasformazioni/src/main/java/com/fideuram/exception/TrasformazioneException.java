package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 25/02/13
 * Time: 18.28
 */
public class TrasformazioneException extends Exception{
    public TrasformazioneException() {
        super();
    }

    public TrasformazioneException(String message) {
        super(message);
    }

    public TrasformazioneException(String message,  Throwable cause) {
        super(message, cause);
    }
}
