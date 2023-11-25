package com.markettingLeadApp.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

// @Component or @Service by using one of these two we are handing over class to spring
			// boot(spring IOC)
@Component
public class EmailServiceImlp implements EmailService {

	@Autowired
	private JavaMailSender sender;
	
	@Value("${spring.mail.username}")
    private String from;

	@Override
	public void sendSimpleMail(String to, String sub, String body) {
		
		SimpleMailMessage message=new SimpleMailMessage();
		message.setFrom(from);
		message.setTo(to);
		message.setSubject(sub);
		message.setText(body);
		
		sender.send(message);
		}
		
	
	
//		MimeMessage message = sender.createMimeMessage();
//		MimeMessageHelper helper = new MimeMessageHelper(message);
//		
//		try {
//			helper.setTo(to);
//			helper.setSubject(sub);
//			helper.setText(body);
//		} catch (MessagingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		sender.send(message);
		
	}

		
	
