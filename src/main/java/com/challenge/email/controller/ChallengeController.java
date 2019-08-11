package com.challenge.email.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.email.domain.EmailRequest;
import com.challenge.email.service.ChallengeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ChallengeController {
	private ObjectMapper objectMapper;
	private ChallengeServiceImpl challengeServiceImpl;
	
	public ChallengeController(final ChallengeServiceImpl challengeServiceImpl, ObjectMapper objectMapper){
		this.objectMapper = objectMapper;
		this.challengeServiceImpl = challengeServiceImpl;
	}
	
	@RequestMapping(value = "/validEmail", method = RequestMethod.POST)
	public ResponseEntity<String> validEmail(@RequestBody EmailRequest email) {
		String response;
		
		try {
			response = objectMapper.writeValueAsString(challengeServiceImpl.checkEmail(email.getEmail()));
		} catch (JsonProcessingException e) {
			return ResponseEntity
		            .status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("Error processing request");		
		}
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}
}
