package mail_or_sms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Java_sms_httprequest {
	
	public static void main(String[] args) {

		try{
		String smtpHostServer = "smtp.example.com";
	    String emailID = "email_me@example.com";
	    final String username = "email.demoeracal@gmail.com"; // Admin Email
		final String password = "email5678"; // Admin Password
		
		List<String> mailAddressTo= new ArrayList();
		mailAddressTo.add("pratikdimble10@gmail.com");
		mailAddressTo.add("pratikdimble2238@gmail.com");
		mailAddressTo.add("dimble73@gmail.com");
		InternetAddress[] mailAddress_TO = new InternetAddress[mailAddressTo.size()];

		System.out.println("==> For Loop Example.");
		for (int i = 0; i < mailAddressTo.size(); i++) {
			mailAddress_TO[i] = new InternetAddress(mailAddressTo.get(i));
		}
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com"); // for smtp credinshital
		props.put("mail.smtp.port", "587"); // for smtp credinshital
		Session session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		String newline =System.getProperty("line.separator"); 
		String message="Dear Ma’am/Sir,"+newline+""
					+ "A very good day to you!"+newline+""
					+ "Did you forget to keep sufficient balance in your bank? "
		 			+ "These days, with so much going on, it is easy to let something slip. "
		 			+ "We are yet to receive your current/previous month’s instalment. "
		 			+ "So, please clear your payment today to avoid penal charges. "
		 			+ "And, if it is already on its way to us."	+newline+""
		 			+ "kindly accept our sincere thanks."; 
		
		 MimeMessage msg = new MimeMessage(session);
	      //set message headers
	      msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
	      msg.addHeader("format", "flowed");
	      msg.addHeader("Content-Transfer-Encoding", "8bit");
	      msg.setFrom(new InternetAddress("email.demoeracal@gmail.com", "NoReply"));
	      msg.setReplyTo(InternetAddress.parse("no_reply@eracal.com", false));
	      msg.setSubject("We’re waiting for your FINAL PAYMENT ", "UTF-8");
	      msg.setText(message, "UTF-8");
	      
         msg.setSentDate(new Date());
         msg.setRecipients(Message.RecipientType.TO,mailAddress_TO);
	      Transport.send(msg);  
	    System.out.println("SUCCESS"+mailAddressTo.size());
	}
	catch(Exception ex){
		System.out.println("ERROR");
		ex.printStackTrace();
		System.out.println("ERROR");
	}
	}
	 
}
