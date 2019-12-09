package com.self.email.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.self.email.config.model.EmailRequest;
import com.self.email.config.model.EmailResponse;
import com.self.email.service.route.EmailRouter;

@Service()
public class EmailServiceImpl{// implements EmailService {

	@Autowired
	private EmailRouter emailRoute;

	//@Override
	public EmailResponse sendEmail(EmailRequest request) {
		return emailRoute.sendEmail(request);
	}

}
