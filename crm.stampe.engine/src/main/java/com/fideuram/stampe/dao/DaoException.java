package com.fideuram.stampe.dao;

/**
 * Created with
 * User: v801068
 * Date: 20/11/13
 * Time: 19.36
 */
public class DaoException  extends Exception{

    private static final long serialVersionUID = -1L;

    public DaoException() {
    }

    /**
     * @param arg0
     */
    public DaoException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public DaoException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public DaoException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}

