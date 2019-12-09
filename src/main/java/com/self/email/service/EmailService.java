package com.self.email.service;

import com.self.email.config.model.EmailRequest;
import com.self.email.config.model.EmailResponse;

public interface EmailService {

	public EmailResponse sendEmail(EmailRequest request);

}
