package com.self.email.service.route;

import java.io.IOException;
import java.io.InputStream;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.self.email.config.EmailConfig;
import com.self.email.config.model.EmailRequest;
import com.self.email.config.model.EmailResponse;

@Component
public class EmailRouter {

	@Autowired
	private EmailConfig config;

	public EmailResponse sendEmail(EmailRequest request) {
		EmailResponse response = new EmailResponse();
		String cc = request.getMailCC();
		MultipartFile multipartFile = request.getFile();
		
		config.getInstance().send(getMimeMessageInstance(request, cc, multipartFile));
		response.setStatus("200");
		response.setMessage("Mail successfully Sent.");
		return response;
	}

	private MimeMessagePreparator getMimeMessageInstance(EmailRequest request, String cc, MultipartFile multipartFile) {
		return new MimeMessagePreparator() {
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				messageHelper.setFrom(request.getSenderId());
				messageHelper.setTo(request.getReciverId());
				messageHelper.setSubject(request.getMailSubject());
				messageHelper.setText(request.getMailBody(), true);

				if (cc != null && !cc.equals("")) {
					String ccArr[] = cc.split(",");
					messageHelper.setCc(ccArr);
				}
				// determines if there is an upload file, attach it to the e-mail
				if (multipartFile != null && !multipartFile.equals("")) {
					messageHelper.addAttachment(multipartFile.getOriginalFilename(), new InputStreamSource() {

						@Override
						public InputStream getInputStream() throws IOException {
							return multipartFile.getInputStream();
						}
					});
				}
			}
		};
	}
}
