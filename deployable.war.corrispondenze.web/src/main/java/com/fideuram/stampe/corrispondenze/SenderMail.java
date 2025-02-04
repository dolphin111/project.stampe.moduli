package com.fideuram.stampe.corrispondenze;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.fideuram.costanti.Costanti;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

public class SenderMail {

	
	public static void sendMailBucap(String[] listaFileInviati, String cOa) {
		  LoggingUtils.info("sender email conferma invio a bucap --> start ...");
	      LoggingUtils.info("Email destinatari to: "+CrmProperties.getProperty(Costanti.CORRISPONDENZE_GEN_MAIL_TO));
	      LoggingUtils.info("Email destinatari cc: "+CrmProperties.getProperty("corrispondenze.gen.mail.cc"));
	      // Recipient's email ID needs to be mentioned.

	      // Sender's email ID needs to be mentioned
	      String from = CrmProperties.getProperty(Costanti.CORRISPONDENZE_MAIL_FROM);
	      
	      String cc = "";
	      String to = "";

	      // Assuming you are sending email from localhost
	      String host = CrmProperties.getProperty(Costanti.CORRISPONDENZE_MAIL_HOST);

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.put("mail.smtp.auth", "false");

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         

	         // Now set the actual message
	         String textMessage ="";
	         if(cOa.equalsIgnoreCase("archivia")){
	   	      	cc = CrmProperties.getProperty(Costanti.CORRISPONDENZE_MAIL_CC);
	   	      	to = CrmProperties.getProperty(Costanti.CORRISPONDENZE_MAIL_TO);
		         // Set Subject: header field
		         message.setSubject(CrmProperties.getProperty(Costanti.CORRISPONDENZE_MAIL_OBJECT));
	            textMessage = "Salve, \n con la presente si autorizza la stampa e la spedizione dei lotti relativi alle rendite che possono essere prelevati nel seguente percorso: \n \n"+
	    	         " /ftp_bucap/CRMS/Bucap/Servgen/Documenti_in_uscita/CorrispondenzaRendita \n \n";
	         }
	         if(cOa.equalsIgnoreCase("creaPdf")){
	        	cc=CrmProperties.getProperty(Costanti.CORRISPONDENZE_GEN_MAIL_CC);
	        	to=CrmProperties.getProperty(Costanti.CORRISPONDENZE_GEN_MAIL_TO);

		         // Set Subject: header field
		         message.setSubject("Generato file pdf ");
	        	 textMessage = "Salve, \n con la presente Vi informiamo che è stato generato il seguente file zip contenente i file pdf da stampare e/o archiviare: \n";
	         }
	         
	         if(cOa.equalsIgnoreCase("errore")){
		        	cc=CrmProperties.getProperty(Costanti.CORRISPONDENZE_GEN_MAIL_CC);
		        	to=CrmProperties.getProperty(Costanti.CORRISPONDENZE_GEN_MAIL_TO);
		         message.addRecipients(Message.RecipientType.CC,
		        		 InternetAddress.parse(cc));
		         message.addRecipients(Message.RecipientType.TO,
		                                  InternetAddress.parse(to));
	        	 message.setSubject("Errore nella generazione del file pdf ");
	        	 textMessage = "Salve, \n con la presente Vi informiamo che è stato generato un errore nella generazione del pdf. \n";

	         }
	         
	         if(!cOa.equalsIgnoreCase("errore")){
		         for(int i = 0; i<listaFileInviati.length; i++){
		        	 textMessage= textMessage + listaFileInviati[i]+"\n \n";
		         }
	         }
	         
	         message.addRecipients(Message.RecipientType.CC,
	        		 InternetAddress.parse(cc));

	         // Set To: header field of the header.
	         message.addRecipients(Message.RecipientType.TO,
	                                  InternetAddress.parse(to));
	         
	         textMessage = textMessage + "Cordiali Saluti \n Laura Calamita";
	         message.setText(textMessage);          


	         // Send message
	         Transport.send(message);
	         LoggingUtils.info("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         LoggingUtils.error(mex);
	      }
	   }
}
