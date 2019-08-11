package com.challenge.email.domain;

public class EmailRequest {	
	private String email;
	
	public EmailRequest(){
		super();
	}
	
	public EmailRequest(String email){
		this.setEmail(email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
