package com.challenge.email.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.challenge.email.domain.EmailRequest;

public interface ChallengeController {
	public ResponseEntity<String> validEmail(@RequestBody EmailRequest email);
}
