package com.rana;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator   extends Authenticator
{
	final String sendGridUser ="NameUChoose";
	final String sendGridPassword="*****";
	   public PasswordAuthentication getPasswordAuthentication()
	   {
	        String username = sendGridUser;
	        String password = sendGridPassword;

	        return new PasswordAuthentication(username, password);   
	   }
	   
	
}
