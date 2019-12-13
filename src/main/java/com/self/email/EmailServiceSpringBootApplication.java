package com.self.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.self.email" })
public class EmailServiceSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailServiceSpringBootApplication.class, args);
	}
}
