package com.fideuram.stampe.quietanze;

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

	
//	public static void main(String[] args) {
//		 
//		final String username = "test@fideuramVita.it";
//		final String password = "password";
// 
//		Properties props = new Properties();
//		props.put("mail.smtp.auth", "false");
//		props.put("mail.smtp.starttls.enable", "true");
//		props.put("mail.smtp.host", "10.10.37.180");
//		props.put("mail.smtp.port", "25");
// 
//		Session session = Session.getInstance(props,
//		  new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(username, password);
//			}
//		  });
// 
//		try {
// 
//			Message message = new MimeMessage(session);
//			message.setFrom(new InternetAddress("test@fideuramVita.it"));
//			message.setRecipients(Message.RecipientType.TO,
//				InternetAddress.parse("riccardo.sabatiello.guest@fideuramVita.it"));
//			message.setSubject("Testing Subject");
//			message.setText("Dear Mail Crawler,"
//				+ "\n\n No spam to my email, please!");
// 
//			Transport.send(message);
// 
//			System.out.println("Done");
// 
//		} catch (MessagingException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
	public static void sendMailBucap(String[] listaFileInviati) {
		  LoggingUtils.info("sender email conferma invio a bucap --> start ...");
	      // Recipient's email ID needs to be mentioned.
	      String to = CrmProperties.getProperty(Costanti.QUIETANZE_MAIL_TO);

	      // Sender's email ID needs to be mentioned
	      String from = CrmProperties.getProperty(Costanti.QUIETANZE_MAIL_FROM);
	      
	      String cc = CrmProperties.getProperty(Costanti.QUIETANZE_MAIL_CC);

	      // Assuming you are sending email from localhost
	      String host = CrmProperties.getProperty(Costanti.QUIETANZE_MAIL_HOST);

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	         
	         message.addRecipients(Message.RecipientType.CC,
	        		 InternetAddress.parse(cc));

	         // Set To: header field of the header.
	         message.addRecipients(Message.RecipientType.TO,
	                                  InternetAddress.parse(to));

	         // Set Subject: header field
	         message.setSubject(CrmProperties.getProperty(Costanti.QUIETANZE_MAIL_OBJECT));

	         // Now set the actual message
	         String textMessage = "Salve, \n con la presente si autorizza la stampa e la spedizione dei lotti relativi alle rendite che possono essere prelevati nel seguente percorso: \n \n"+
	    	         " /ftp_bucap/CRMS/Bucap/Servgen/Documenti_in_uscita/LiquidazioneRendita \n \n";
	         
	         for(int i = 0; i<listaFileInviati.length; i++){
	        	 textMessage= textMessage + listaFileInviati[i]+"\n \n";
	         }
	         
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
