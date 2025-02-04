package com.fideuram.soa.async;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.fideuram.FacadeCollettive;

/**
 * Created by
 * User: logan
 * Date: 20/09/12
 * Time: 15.11
 */
/*@MessageDriven(name = "MDBCollettive", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",  propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",  propertyValue="ID_DESTINATARIO_KEY = 'Collettive'")
})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)*/
public class MDBCollettive implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage m = (TextMessage)message;
        try {
           int processo = m.getIntProperty("ID_PROCESSO");
           String file=m.getStringProperty("ID_FILE_KEY");
           new FacadeCollettive().printCollettiva(file,processo);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
