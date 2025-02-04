package com.fideuram.stampe.domande;

/**
 * Created with
 * User: v801068
 * Date: 27/11/13
 * Time: 15.10
 */
public class DomandaException extends Exception{
    private static final long serialVersionUID = -1L;

    public DomandaException() {
    }

    /**
     * @param arg0
     */
    public DomandaException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public DomandaException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DomandaException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
