package com.self.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.self.email.config.model.EmailRequest;
import com.self.email.config.model.EmailResponse;
import com.self.email.constant.Constants;
import com.self.email.service.impl.EmailServiceImpl;

/**
 * 
 *
 * @author Rajan
 */

@RestController
@RequestMapping(value = Constants.BASE_URL)
public class EmailServiceController {

	@Autowired
	//@Qualifier("emailServiceImpl")
	private EmailServiceImpl emailService;

	@PostMapping(value = Constants.SEND_EMAIL_URL)
	public EmailResponse sendEmail(@RequestParam(value = "file", required = false) MultipartFile multiFile,
			EmailRequest reqeust) {
		reqeust.setFile(multiFile);
		return emailService.sendEmail(reqeust);
	}

}
