package com.challenge.email.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class ChallengeServiceImpl {
	public static final String NOT_VALID = "Wrong format";
	public static final String VALID = "Format OK";
	//approximate regex
	public static final String REGEX_EMAIL = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
	public static final String AT = "@";
	public static final String BAD_BEGIN_A = "^www.";
	public static final String BAD_BEGIN_B = "^.";
	
	/**
	 * Return a string with the result
	 * @param email
	 * @return
	 */
	public String checkEmail(String email){
		String result = VALID;
		Pattern p = Pattern.compile(REGEX_EMAIL);
	    Matcher s = p.matcher(email);

	    if (!s.find()){
	    	result = NOT_VALID;
	    	return result;
	    }
		return result;
	}
}
