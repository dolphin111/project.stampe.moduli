package com.fideuram.log;

import com.fideuram.config.CrmProperties;
import com.fideuram.utils.Chronometer;
import com.fideuram.utils.LoggingUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.XMLConfigurationFactory;


/**
 * User: V801068
 * Date: 24/09/14
 * Time: 10.03
 */
public class Log4j2Utils extends LoggingAbstract{

    public static void main(String args[]){
        for (int i=0;i<3;i++){
            Log4j2Utils.trace("PROVACCIA");
            Log4j2Utils.info("PROVACCIA");
            Log4j2Utils.warn("PROVACCIA");
            Log4j2Utils.error("PROVACCIA");
            Log4j2Utils.fatal("PROVACCIA");
            Log4j2Utils.debug("PROVACCIA");
        }
    }



    private static Logger getLogger(){
        if(!freemarkerLogDisable)
            setPropertiesPerFreeMarker();
        if(!loggerConfigured){
            System.setProperty(XMLConfigurationFactory.CONFIGURATION_FILE_PROPERTY, CrmProperties.getProperty("log4j2.config.file"));
            loggerConfigured=true;
        }
        String callerClass = Log4j2Utils.class.getName();
        Logger logger = LogManager.getLogger(callerClass);
        return logger;
    }

    public static void trace(java.lang.Object o) {
        getLogger().trace(o);
    }
    public static void trace(java.lang.Object o, java.lang.Throwable throwable) {
        getLogger().trace(o, throwable);
    }
    public static void debug(java.lang.Object o) {
        Logger l = getLogger();
        if(l.isDebugEnabled()) {
            l.debug(o);
        }
    }
    public static void debug(java.lang.Object o, java.lang.Throwable throwable) {
        getLogger().debug(o, throwable);
    }
    public static void info(java.lang.Object o) {
        getLogger().info(o);
    }
    public static void info(java.lang.Object o, java.lang.Throwable throwable) {
        getLogger().info(o, throwable);
    }
    public static void warn(java.lang.Object o) {
        getLogger().warn(o);
    }
    public static void warn(java.lang.Object o, java.lang.Throwable throwable) {
        getLogger().warn(o, throwable);
    }
    public static void error(java.lang.Object o) {
        getLogger().error(o);
    }
    public static void error(java.lang.Object o, java.lang.Throwable throwable) {
        getLogger().error(o, throwable);
    }
    public static void fatal(java.lang.Object o) {
        getLogger().fatal(o);
    }
    public static void fatal(java.lang.Object o, java.lang.Throwable throwable) {
        getLogger().fatal(o, throwable);
    }
}
