package com.fideuram.factory;

import com.fideuram.servizi.ejb.mdb.CollettiveMessage;
import com.fideuram.utils.LoggingUtils;

import javax.jms.JMSException;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 14/05/13
 * Time: 10.13
 */
public class JmsFactory {

    public static void send2Collettive(String file,int processo, boolean persistent) throws JMSException, Exception {
        LoggingUtils.info("JmsFactory send2Collettive");
        new CollettiveMessage().sendMessage(file,processo,persistent);
    }

}
