package com.fideuram.servizi.ejb.mdb;

import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import javax.naming.Context;
import java.util.Properties;

/**
 * Created with
 * User: logan
 * Date: 14/05/13
 * Time: 9.26
 */
public class JmsBase {

    public JmsBase() {
    }

//    protected Properties getProperties(){
//        
//    	// G.C.-20170228 Commentata vecchia gestione per BEA
//    	/*
//    	Properties properties = new Properties();
//        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
//        properties.setProperty(Context.PROVIDER_URL, CrmProperties.getProperty("coda.collettive.provider.url"));
//        LoggingUtils.info("PROVIDER_URL ["+CrmProperties.getProperty("coda.collettive.provider.url")+"]");
//        properties.setProperty(Context.SECURITY_PRINCIPAL, CrmProperties.getProperty("coda.collettive.principal"));
//        LoggingUtils.info("SECURITY_PRINCIPAL ["+CrmProperties.getProperty("coda.collettive.principal")+"]");
//        properties.setProperty(Context.SECURITY_CREDENTIALS, CrmProperties.getProperty("coda.collettive.credentials"));
//        LoggingUtils.info("SECURITY_CREDENTIALS ["+CrmProperties.getProperty("coda.collettive.credentials")+"]");
//        return properties;
//        */
//    	
//    	// G.C.-20170228 Nuova gestione per JBOSS
//    	
//    	 Properties properties = new Properties();
//         properties.put(Context.INITIAL_CONTEXT_FACTORY, CrmProperties.getProperty("coda.collettive.java.naming.factory.initial"));
//         properties.put(Context.PROVIDER_URL, CrmProperties.getProperty("coda.collettive.provider.url"));
//         LoggingUtils.info("PROVIDER_URL ["+CrmProperties.getProperty("coda.collettive.provider.url")+"]");
//         properties.put(Context.SECURITY_PRINCIPAL, CrmProperties.getProperty("coda.collettive.principal"));
//         LoggingUtils.info("SECURITY_PRINCIPAL ["+CrmProperties.getProperty("coda.collettive.principal")+"]");
//         properties.put(Context.SECURITY_CREDENTIALS, CrmProperties.getProperty("coda.collettive.credentials"));
//         LoggingUtils.info("SECURITY_CREDENTIALS ["+CrmProperties.getProperty("coda.collettive.credentials")+"]");
//         properties.put("jboss.naming.client.ejb.context", true);
//         return properties;
//    }
}
