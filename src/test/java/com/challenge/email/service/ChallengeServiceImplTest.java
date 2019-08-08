package com.challenge.email.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ChallengeServiceImplTest {
	
	private ChallengeServiceImpl challengeServiceImpl;
	private String email;
	public static final String NOT_VALID = "Wrong format";
	public static final String VALID = "Format OK";
	
	@Before
	public void setUp(){
		challengeServiceImpl = new ChallengeServiceImpl();
		email = new String();
	}
	
	/**
	 * Return a string with the result valid
	 * @param email
	 * @return
	 */
	@Test
	public void shouldReturnValid(){
		email = "jose.tejon@gmail.com";
		String response = challengeServiceImpl.checkEmail(email);
		assertEquals(VALID, response);
	}
	
	@Test
	public void shouldNotReturnValid(){
		email = "jose.tejon@.com";
		String response = challengeServiceImpl.checkEmail(email);
		assertEquals(NOT_VALID, response);
	}
}
