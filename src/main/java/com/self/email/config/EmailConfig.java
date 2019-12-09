package com.self.email.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.self.email.utils.StringUtil;

@Component("emailConfigBean")
public class EmailConfig {

	@Value("${email.smtp.host}")
	private String host;
	@Value("${email.smtp.port}")
	private String port;
	@Value("${email.smtp.user.name}")
	private String userName;
	@Value("${email.smtp.password}")
	private String password;
	@Value("${email.smtp.auth.key}")
	private String authKey;
	@Value("${email.smtp.ttls}")
	private String ttls;

	@Bean
	public JavaMailSenderImpl getInstance() {

		if (isEmpty().contains(false)) {
			return null;
		}
		return setProperties();
	}

	private JavaMailSenderImpl setProperties() {
		JavaMailSenderImpl instance = new JavaMailSenderImpl();
		instance.setHost(host);
		instance.setPort(Integer.parseInt(port));
		instance.setUsername(userName);
		instance.setPassword(password);
		instance.setJavaMailProperties(getmailProperties());
		return instance;
	}

	private Properties getmailProperties() {
		Properties properties = new Properties();
		properties.setProperty("mail.smtp.auth", authKey);
		properties.setProperty("mail.smtp.starttls.enable", authKey);
		return properties;
	}

	private List<Boolean> isEmpty() {

		List<Boolean> flagList = new ArrayList<>();

		flagList.add(StringUtil.isNull(host));
		flagList.add(StringUtil.isNull(port));
		flagList.add(StringUtil.isNull(userName));
		flagList.add(StringUtil.isNull(password));

		return flagList;

	}
}
