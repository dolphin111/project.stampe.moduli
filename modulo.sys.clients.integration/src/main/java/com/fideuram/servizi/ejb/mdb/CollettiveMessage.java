package com.fideuram.servizi.ejb.mdb;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 14/05/13
 * Time: 9.22
 */
public class CollettiveMessage /*extends JmsBase*/{

    public CollettiveMessage() {
        super();
    }

    /**
     * Spedisce il messaggio a una Queue
     * @param file
     */
    public void sendMessage(String file, int processo, boolean persistent) throws JMSException, Exception {
        LoggingUtils.info("CollettiveMessage sendMessage");
        try {
        	
        	// G.C.-20170228 Commentata vecchia gestione per BEA
        	
            /* InitialContext ctx = new InitialContext(getProperties());
            LoggingUtils.info("ctx initialcontext ...");
            QueueConnectionFactory qcf = (QueueConnectionFactory)ctx.lookup( "crm.jms.factory" );
            LoggingUtils.info("QueueConnectionFactory lookup ...");
            Queue destQueue = (Queue)ctx.lookup( "crm.jms.stampaBatchServiceQueue" );
            LoggingUtils.info("Queue lookup crm.jms.stampaBatchServiceQueue...");
            QueueConnection connection = qcf.createQueueConnection();
            LoggingUtils.info("QueueConnection createQueueConnection...");
            connection.start();
            LoggingUtils.info("START connection queue for file:["+file+"]");
            boolean transacted = false;
            QueueSession session = connection.createQueueSession( transacted, Session.AUTO_ACKNOWLEDGE);
            QueueSender queueSender = session.createSender(destQueue);

            if(persistent)
                queueSender.setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);
            else
                queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            TextMessage outMessage = session.createTextMessage("");
            outMessage.setStringProperty("ID_DESTINATARIO_KEY","Collettive");
            outMessage.setStringProperty("ID_FILE_KEY", file);
            outMessage.setIntProperty("ID_PROCESSO", processo);
            queueSender.send(outMessage);
            LoggingUtils.info("SEND message queue for file");
            queueSender.close();
            session.close();
            LoggingUtils.info("SESSION CLOSE");
            session = null;
            connection.close();
            LoggingUtils.info("CONNECTION CLOSE");
            connection = null;*/
        	
        	// G.C.-20170228 Nuova gestione per JBOSS
        	
        	Properties properties = new Properties();
            properties.put(Context.INITIAL_CONTEXT_FACTORY, CrmProperties.getProperty("coda.collettive.java.naming.factory.initial"));
            properties.put(Context.PROVIDER_URL, CrmProperties.getProperty("coda.collettive.provider.url"));
            properties.put(Context.SECURITY_PRINCIPAL, CrmProperties.getProperty("coda.collettive.principal"));
            properties.put(Context.SECURITY_CREDENTIALS, CrmProperties.getProperty("coda.collettive.credentials"));
     
            ConnectionFactory connection = null;
            Destination destQueue = null;
     
            try {
                Context context = new InitialContext(properties);
                connection = (ConnectionFactory) context.lookup(CrmProperties.getProperty("coda.collettive.jndi.jms.factoryName"));
                destQueue = (Destination) context.lookup(CrmProperties.getProperty("coda.collettive.jndi.jms.stampaBatchQueueName"));
     
                sendMessage(connection, destQueue, file, processo, persistent);
                
            } catch (NamingException e) {
            	LoggingUtils.error(e);
                LoggingUtils.error("NAMING ECCEZIONE IN CollettiveMessage"+e.getMessage());
                throw new JMSException(e.getMessage());
            }
     
        } catch (Exception e){
        	LoggingUtils.error(e);
        	LoggingUtils.error("ECCEZIONE GENERICA IN CollettiveMessage"+e.getMessage());
            throw new Exception(e.getMessage());
        }
    }
    
    private static void sendMessage(ConnectionFactory connectionFactory, Destination destination, String file, int processo, boolean persistent) {
        Connection connection = null;
        Session session = null;
        MessageProducer messageProducer = null;
 
        try {
            connection = connectionFactory.createConnection(CrmProperties.getProperty("coda.collettive.principal"), CrmProperties.getProperty("coda.collettive.credentials"));
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageProducer = session.createProducer(destination);
            
            if(persistent)
            	messageProducer.setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT);
            else
            	messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
 
            TextMessage text = session.createTextMessage();
           
            text.setStringProperty("ID_DESTINATARIO_KEY","Collettive");
            text.setStringProperty("ID_FILE_KEY", file);
            text.setIntProperty("ID_PROCESSO", processo);
            
            messageProducer.send(text);
            
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                	messageProducer.close();
                	session.close();
                    connection.close();  
                } catch (JMSException f) {
                    f.printStackTrace();
                }
            }
        }
 
    }   


    public static void main(String args[]) throws Exception{
        try {
            new CollettiveMessage().sendMessage("prova.csv",901,false);
        } catch (JMSException e) {
        	LoggingUtils.error("ECCEZIONE IN CollettiveMessage"+e.getMessage());
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
