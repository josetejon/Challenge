package com.challenge.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.challenge.email.controller")
@ComponentScan(basePackages="com.challenge.email.service")
public class ChallengeApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChallengeApplication.class, args);
	}
}
