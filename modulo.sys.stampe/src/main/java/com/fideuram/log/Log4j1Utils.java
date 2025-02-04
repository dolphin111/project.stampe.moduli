package com.fideuram.log;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.utils.Chronometer;
import com.fideuram.utils.LoggingUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.config.XMLConfigurationFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * User: V801068
 * Date: 24/09/14
 * Time: 11.51
 */
public class Log4j1Utils extends LoggingAbstract{
    public static void main(String args[]){

            Log4j1Utils.trace("PROVACCIA");
            Log4j1Utils.info("PROVACCIA");
            Log4j1Utils.warn("PROVACCIA");
            Log4j1Utils.error("PROVACCIA");
            Log4j1Utils.fatal("PROVACCIA");
            Log4j1Utils.debug("PROVACCIA");

    }

    private static Log getLogger() {

        String callerClass=getCalletName();

        // Logger classe chiamante
        Log log = LogFactory.getLog(callerClass);

        if(!loggerConfigured){
            // Logger properties
            Properties logProperties = new Properties();
            String logPropertiesFile = CrmProperties.getProperty(Costanti.LOG4J_FILE);

            /*if(logPropertiesFile!=null){
                try {
                    logProperties.load(new FileInputStream(logPropertiesFile));
                    PropertyConfigurator.configure(logProperties);
                } catch (IOException e ) {
                    //todo elimina sta schifezza appena battello propaga le properties di sistema
                    try {

                        //per andare in produzione
                        //logProperties.load(new FileInputStream("//fvasowl03/BEA_files_config&logs/Fideuram/config/log4j.properties"));
                        logProperties.load(new FileInputStream("C:/Oracle/mw_home/BEA_files_config&logs/Fideuram/config/log4j.properties"));
                        PropertyConfigurator.configure(logProperties);
                        log.debug("Logging initialized, BUT LOCATION LOG4J_FILE" + logPropertiesFile + "è sbagliato-1");
                    } catch (IOException e1) {


                    }
                    //fine todo
                }
            }else{
                try {
                    //COLLAUDO --> logProperties.load(new FileInputStream("//fvasowl03c/BEA_files_config&logs/Fideuram/config/log4j.properties"));
                    //COLLAUDO --> NON FUNZIONA--logProperties.load(new FileInputStream("C:/Oracle/mw_home/files_config&logs/Fideuram/config/log4j.properties"));
                    //TEST     --> logProperties.load(new FileInputStream("//fvasowl02t/BEA_files_config&logs/Fideuram/config/log4j.properties"));
                    logProperties.load(new FileInputStream("//fvasowl03c/BEA_files_config&logs/Fideuram/config/log4j.properties"));
                    PropertyConfigurator.configure(logProperties);
                    log.debug("Logging initialized, BUT NOT FROM LOCATION LOG4J_FILE" + logPropertiesFile);
                } catch (IOException e) {

                }
            }*/

            if(logPropertiesFile!=null){
                try {
                    logProperties.load(new FileInputStream(logPropertiesFile));
                    PropertyConfigurator.configure(logProperties);
                } catch (IOException e ) {
                   log.error(e);
                }
            }else{
                log.info("LOGGER STAMPE NON CONFIGURATO");
            }
            loggerConfigured=true;
        }
        return log;
    }


    public static void trace(java.lang.Object o) {
        Log l = getLogger();
        l.trace(o);
    }
    public static void trace(java.lang.Object o, java.lang.Throwable throwable) {
        Log l = getLogger();
        l.trace(o, throwable);
    }
    public static void debug(java.lang.Object o) {
        Log l = getLogger();
        if(l.isDebugEnabled()) {
            l.debug(o);
        }
    }
    public static void debug(java.lang.Object o, java.lang.Throwable throwable) {
        Log l = getLogger();
        l.debug(o, throwable);
    }
    public static void info(java.lang.Object o) {
        Log l = getLogger();
        l.info(o);
    }
    public static void info(java.lang.Object o, java.lang.Throwable throwable) {
        Log l = getLogger();
        l.info(o, throwable);
    }
    public static void warn(java.lang.Object o) {
        Log l = getLogger();
        l.warn(o);
    }
    public static void warn(java.lang.Object o, java.lang.Throwable throwable) {
        Log l = getLogger();
        l.warn(o, throwable);
    }
    public static void error(java.lang.Object o) {
        Log l = getLogger();
        l.error(o);
    }
    public static void error(java.lang.Object o, java.lang.Throwable throwable) {
        Log l = getLogger();
        l.error(o, throwable);
    }
    public static void fatal(java.lang.Object o) {
        Log l = getLogger();
        l.fatal(o);
    }
    public static void fatal(java.lang.Object o, java.lang.Throwable throwable) {
        Log l = getLogger();
        l.fatal(o, throwable);
    }
}
