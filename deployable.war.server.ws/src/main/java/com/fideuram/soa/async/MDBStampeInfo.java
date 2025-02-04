package com.fideuram.soa.async;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.engine.CrmStampeService;
import com.fideuram.utils.LoggingUtils;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Message-Driven bean implementation class for: StampaBatch
 * 
 */
@MessageDriven(name = "StampaBatchMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "messageSelector",  propertyValue="ID_DESTINATARIO_KEY = 'Info'"),
        @ActivationConfigProperty(propertyName="destination", propertyValue="java:/jboss/exported/crm.jms.stampaBatchServiceQueue")
})
@TransactionManagement(value = TransactionManagementType.CONTAINER)
@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
public class MDBStampeInfo implements MessageListener {

	private static final String CHECK_TEXT = "STAMPA_BATCH";
	private static final String ID_COMUNICAZIONE_KEY = "ID_COMUNICAZIONE_KEY";
	private static final String ID_DESTINATARIO_KEY = "ID_DESTINATARIO_KEY";

	@Resource
	private MessageDrivenContext context;

	/**
	 * 
	 */
	public MDBStampeInfo() {
	}

	public void setMessageDrivenContext(
			MessageDrivenContext messageDrivenContext) throws EJBException {
		context = messageDrivenContext;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
        public void onMessage(Message message) {
		String _debug = CrmProperties.getProperty(Costanti.CRM_STAMPE_TEST);
       
        
		if( !(message instanceof TextMessage) ) {
			LoggingUtils.error("Tipo di messaggio non valido");
			return;
		}

		TextMessage m = (TextMessage)message;


		String text = null;
		int idComunicazione = 0;

		try {
			text = m.getText();
            LoggingUtils.debug("STAMPE_INFO: "+m.getStringProperty(ID_DESTINATARIO_KEY));

			if("true".equals(_debug)&&(!CHECK_TEXT.equals(text))) {
				//text = "STAMPA_BATCH";
				//idComunicazione = 7661506;
                idComunicazione = Integer.parseInt(m.getText());
                text = "STAMPA_BATCH";
			}
			else {
				// Controllo testo del messaggio
				if(!CHECK_TEXT.equals(text))
					LoggingUtils.error("Messaggio di contenuto non valido"); 

				idComunicazione = m.getIntProperty(ID_COMUNICAZIONE_KEY);
			}
            LoggingUtils.info("INIZIO ELABORAZIONE PER COMID: " + idComunicazione);
			CrmStampeService service = new CrmStampeService();
    		service.elaboraMessaggio(idComunicazione);
    		LoggingUtils.info("FINE ELABORAZIONE PER COMID: " + idComunicazione);
		} catch(JMSException je) {
			LoggingUtils.error(je, je);
			return;
		}

 	}
}
