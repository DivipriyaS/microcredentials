package com.cognizant.microcredentials.process.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class EmailService {

	private JavaMailSender javaMailSender;

	@Autowired
	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}


	public void sendEmail(String emailRequest, String message) throws MailException {


		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(emailRequest);
		mail.setSubject("Claim Approval Notification");
		mail.setText(message);

		javaMailSender.send(mail);
	}
	
}
