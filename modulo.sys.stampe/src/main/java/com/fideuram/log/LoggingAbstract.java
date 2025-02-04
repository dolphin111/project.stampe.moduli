package com.fideuram.log;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 24/09/14
 * Time: 9.58
 */
public class LoggingAbstract {
    protected static boolean loggerConfigured;
    protected static boolean freemarkerLogDisable;

    protected static void setPropertiesPerFreeMarker(){
        try {
            freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_NONE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        freemarkerLogDisable=true;
    }

    protected static String getCalletName(){
        String callerClass = LoggingAbstract.class.getName();

        StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        for (int i = 1; i < elements.length; i++) {
            StackTraceElement e = elements[i];
            if (!callerClass.equals(e.getClassName())) {
                callerClass = e.getClassName();
                break;
            }
        }
        return callerClass;
    }
}
