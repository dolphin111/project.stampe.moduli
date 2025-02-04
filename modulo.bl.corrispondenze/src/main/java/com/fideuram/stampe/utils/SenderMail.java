package com.fideuram.stampe.utils;

import java.util.Properties;

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

	
	public static void sendMail(String from, String to, String cc, String mailSubject, String mailText, String error) {
		  LoggingUtils.info("sendMail --> start ...");
		  LoggingUtils.info("Email destinatari from: "+from);
		  LoggingUtils.info("Email destinatari to: "+to);
	      LoggingUtils.info("Email destinatari cc: "+cc);

	    
	      String host = CrmProperties.getProperty(Costanti.MAIL_SMTP_HOST);
	      String port = CrmProperties.getProperty(Costanti.MAIL_SMTP_PORT);

	      // Get system properties
	      Properties properties = System.getProperties();

	      // Setup mail server
	      properties.setProperty("mail.smtp.host", host);
	      properties.setProperty("mail.smtp.port", port);
	      properties.put("mail.smtp.auth", "false");

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties);

	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));
	        
	         message.addRecipients(Message.RecipientType.TO,InternetAddress.parse(to));
	         message.addRecipients(Message.RecipientType.CC,InternetAddress.parse(cc));
		     message.setSubject(mailSubject);
		     
		     String textMessage = mailText +"\n \n" + "L'errore è riportato di seguito : "+"\n \n" + error + "\n \n";
	         textMessage = textMessage + "Email inviata dal sistema";
	         message.setText(textMessage);          

	         // Send message
	         Transport.send(message);
	         LoggingUtils.info("sendMail --> successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	         LoggingUtils.error(mex);
	      }
	   }
}
