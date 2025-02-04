package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 15/02/12
 * Time: 18.20
 */
public class ClassOriginException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     *
     */
    public ClassOriginException() {
    }

    /**
     * @param arg0
     */
    public ClassOriginException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public ClassOriginException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public ClassOriginException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
