
package com.rana;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendGridUtility  
{
	
	public static void sendGridSendMail(String msg,String recipient)
	{
		final String sendGridUser ="NameUChoose";
		//final String sendGridPassword="******";
		

		   try
		   {
			   // The SendGrid SMTP server.
			     String SMTP_HOST_NAME = "smtp.sendgrid.net";
			      
			      Properties   properties = new Properties();
			      // Specify SMTP values.
			      properties.put("mail.transport.protocol", "smtp");
			      properties.put("mail.smtp.host", SMTP_HOST_NAME);
			      properties.put("mail.smtp.port", 587);
			      properties.put("mail.smtp.auth", "true");
			      
			   // Create the authenticator object.
			      Authenticator authenticator = new SMTPAuthenticator();
			      
			      // Create the mail session object.
			      Session mailSession;
			      mailSession = Session.getDefaultInstance(properties, authenticator);
			      
			      Message message = new MimeMessage(mailSession);
					message.setFrom(new InternetAddress(sendGridUser));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(recipient));
					message.setSubject("Dear Customer");
					message.setText(msg);
					
				     Transport transport;
				     transport = mailSession.getTransport();
				     // Connect the transport object.
				     transport.connect();
				     // Send the message.
				     transport.sendMessage(message,  message.getRecipients(Message.RecipientType.TO));
				     // Close the connection.
				     transport.close();
		   }catch(Exception e)
		   {
			   System.out.println(e);
		   }
	}

}

