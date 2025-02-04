package com.fideuram.soa.async;

import com.fideuram.request.FacadeProspetti;
import com.fideuram.utils.LoggingUtils;

import javax.ejb.*;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by
 * User: logan
 * Date: 20/09/12
 * Time: 15.11
 */
@MessageDriven(name = "MDBProspettoDiOfferta", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",  propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",  propertyValue="ID_DESTINATARIO_KEY = 'Prospetto Di Offerta'"),
        @ActivationConfigProperty(propertyName="destination", propertyValue="java:/jboss/exported/crm.jms.stampaBatchServiceQueue")
})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class MDBProspettoDiOfferta implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage m = (TextMessage)message;
        try {
            LoggingUtils.debug("STAMPA_PROSPETTO DI OFFERTA: "+m.getStringProperty("ID_DESTINATARIO_KEY"));
            LoggingUtils.debug("PROSPETTO RICHIESTO: "+m.getIntProperty("ID_OFFERTA_KEY"));
            Object o= new FacadeProspetti().elaboraProcesso(m.getIntProperty("ID_OFFERTA_KEY"));
            if(o!=null)
                LoggingUtils.debug("richiesta terminata-->"+m.getStringProperty("ID_DESTINATARIO_KEY"));
            else
                LoggingUtils.debug("MMMM-->"+m.getStringProperty("ID_DESTINATARIO_KEY"));
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
