package com.fideuram.exception;

/**
 * Created by
 * User: logan
 * Date: 06/02/12
 * Time: 16.15
 */
public class TemplateLoaderExcepion extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = -1L;

    /**
     *
     */
    public TemplateLoaderExcepion() {
    }

    /**
     * @param arg0
     */
    public TemplateLoaderExcepion(String arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     */
    public TemplateLoaderExcepion(Throwable arg0) {
        super(arg0);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public TemplateLoaderExcepion(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }
}
