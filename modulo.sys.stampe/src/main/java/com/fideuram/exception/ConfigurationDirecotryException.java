package com.fideuram.exception;


/**
 * Created by
 * User: logan
 * Date: 19/06/12
 * Time: 10.20
 */
public class ConfigurationDirecotryException  extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     *
     */
    public ConfigurationDirecotryException() {
    }

    /**
     * @param arg0
     */
    public ConfigurationDirecotryException(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public ConfigurationDirecotryException(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public ConfigurationDirecotryException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
