package com.example.springMentoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringMentoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMentoringApplication.class, args);
	}

}
