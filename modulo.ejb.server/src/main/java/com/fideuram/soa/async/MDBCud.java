package com.fideuram.soa.async;


import com.fideuram.config.CrmProperties;
import com.fideuram.file.io.writer.XmlWriter;
import com.fideuram.processo.FacadeCu2015;
import com.fideuram.processo.FacadeCu2016;
import com.fideuram.utils.LoggingUtils;

import javax.ejb.*;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import java.io.File;
import java.io.IOException;


/**
 * Created with
 * User: v801068
 * Date: 20/02/14
 * Time: 18.11
 */
@MessageDriven(name = "MDBCud", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",  propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",  propertyValue="ID_DESTINATARIO_KEY = 'Cud730'"),
        @ActivationConfigProperty(propertyName="destination", propertyValue="java:/jboss/exported/crm.jms.stampaBatchServiceQueue")
})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class MDBCud implements MessageListener {

    @Override
    public void onMessage(Message message) {
        String fsErrori=null;
        TextMessage m = (TextMessage)message;
        String xml=null;
        String filename=null;
        Integer anno=null;
        try {
            if(null!=m.getStringProperty("XML_OBJECT")){
                filename=m.getStringProperty("FILE_XML_NAME");
                xml=m.getStringProperty("XML_OBJECT");
                anno=m.getIntProperty("ANNO");
                LoggingUtils.debug("Attivato il Cud Per: "+filename);
                switch (anno){
                    case 2015:
                        fsErrori= CrmProperties.getProperty("cud.errori")+"2015"+File.separator;
                        new FacadeCu2015().generaCu2015(xml);
                        break;
                    case 2016:
                        fsErrori= CrmProperties.getProperty("cud.errori")+"2016"+File.separator;
                        new FacadeCu2016().generaCu2016(xml);
                        break;
                    default:
                       // new FacadeCu2015().generaCu2015(xml);
                        break;
                }

            }
        } catch (Exception e) {
            LoggingUtils.error(e);
            LoggingUtils.error("Xml IN ERRORE: \n" +xml);
            try {
                //XmlWriter.scriviStoXml(xml,filename, CrmProperties.getProperty("cud.errori"));
                XmlWriter.scriviStoXml(xml,filename, fsErrori);
            } catch (IOException e1) {
                LoggingUtils.error(e);
                LoggingUtils.error("SONO ANDATO IN ERRORE SCRIVENDO IL FILE XML:  \n" +xml);
            }
        }
    }
}
