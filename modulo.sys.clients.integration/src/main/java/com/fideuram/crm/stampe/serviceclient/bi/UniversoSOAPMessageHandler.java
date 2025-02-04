/**
 * 
 */
package com.fideuram.crm.stampe.serviceclient.bi;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import localhost.wssoapauth64.srvauth.AccountInfoHeader;

import com.fideuram.utils.LoggingUtils;

/**
 * @author Giorgio Desideri
 *
 * Message handler per il WS di universo.
 * 
 * All'interno del <code><SOAPBody></code> deve essere aggiunto l'header di autenticazione
 * presso il servizio.
 */
public class UniversoSOAPMessageHandler implements SOAPHandler<SOAPMessageContext> {
	
	/**
	 * 
	 */
	private AccountInfoHeader authHeader = null;
	
	
	/**
	 * @param authHeader
	 */
	public UniversoSOAPMessageHandler(AccountInfoHeader authHeader) {
		this.authHeader = authHeader;
	}
	

	/* (non-Javadoc)
	 * @see javax.xml.ws_client.handler.Handler#handleMessage(javax.xml.ws_client.handler.MessageContext)
	 */
	public boolean handleMessage(SOAPMessageContext messageContext) {
		SOAPMessage msg = messageContext.getMessage();
		
		if ((Boolean) messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY)){
			
			try {
				SOAPEnvelope envelope = msg.getSOAPPart().getEnvelope();
				// Elimino l'header esistente
				if(envelope.getHeader() != null)
					envelope.getHeader().detachNode();
				
				SOAPHeader header = envelope.addHeader();
				//SOAPBody body = envelope.getBody();
				
				// Root element
				SOAPElement root = header.addHeaderElement(
						envelope.createName(
								"AccountInfoHeader",
								"", 
								"http://localhost/WSSOAPAUTH64/SrvAuth"));
				
				// USER
				SOAPElement user = root.addChildElement(
						envelope.createName(
								"UserName", "", "http://localhost/WSSOAPAUTH64/SrvAuth"));
				
				user.setValue(authHeader.getUserName());
				
				// PWD
				SOAPElement pwd = root.addChildElement(
						envelope.createName(
								"Password", "", "http://localhost/WSSOAPAUTH64/SrvAuth"));
				
				pwd.setValue(authHeader.getPassword());
				
				// DOMAIN
				SOAPElement domain = root.addChildElement(
						envelope.createName(
								"Domain", "", "http://localhost/WSSOAPAUTH64/SrvAuth"));
				
				domain.setValue(authHeader.getDomain());
				
				// AMBIENTE
				SOAPElement ambiente = root.addChildElement(
						envelope.createName(
								"Ambiente", "", "http://localhost/WSSOAPAUTH64/SrvAuth"));
				
				ambiente.setValue(authHeader.getAmbiente());
				
				
				// Salvataggio modifiche
				msg.saveChanges();
				
			} catch (SOAPException e) {
				LoggingUtils.error(e, e);
				return false;
			}
		}
		
		return true;		
	}

	/* (non-Javadoc)
	 * @see javax.xml.ws_client.handler.soap.SOAPHandler#getHeaders()
	 */
	public Set<QName> getHeaders() {
		Set<QName> headers = new HashSet<QName>();
		
		//headers.add(new QName("https://ws_client.service.com/", "TicketHeader"));
		
		return headers;
	}
	
	/* (non-Javadoc)
	 * @see javax.xml.ws_client.handler.Handler#close(javax.xml.ws_client.handler.MessageContext)
	 */
	public void close(MessageContext messageContext) {
	}

	/* (non-Javadoc)
	 * @see javax.xml.ws_client.handler.Handler#handleFault(javax.xml.ws_client.handler.MessageContext)
	 */
	public boolean handleFault(SOAPMessageContext messageContext) {
		return false;
	}

}