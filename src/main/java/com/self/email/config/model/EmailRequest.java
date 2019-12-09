package com.self.email.config.model;

import org.springframework.web.multipart.MultipartFile;

public class EmailRequest {

	private String senderId;
	private String reciverId;
	private String mailSubject;
	private String mailBody;
	private String mailCC;
	private MultipartFile file;

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getReciverId() {
		return reciverId;
	}

	public void setReciverId(String reciverId) {
		this.reciverId = reciverId;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getMailBody() {
		return mailBody;
	}

	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}

	public String getMailCC() {
		return mailCC;
	}

	public void setMailCC(String mailCC) {
		this.mailCC = mailCC;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "EmailRequest [senderId=" + senderId + ", reciverId=" + reciverId + ", mailSubject=" + mailSubject
				+ ", mailBody=" + mailBody + ", mailCC=" + mailCC + ", file=" + file + "]";
	}

	
}
