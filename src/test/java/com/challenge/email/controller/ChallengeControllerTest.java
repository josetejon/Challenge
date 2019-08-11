package com.challenge.email.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import javax.ws.rs.core.MediaType;
import com.challenge.email.domain.EmailRequest;
import com.challenge.email.service.ChallengeServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ChallengeControllerTest {
	private MockMvc mockMvc;
	
	@Mock
	private ChallengeServiceImpl challengeServiceImpl;
	private ChallengeController challengeController;
	private String endopointCheckEmail;
	private ObjectMapper objectMapper = new ObjectMapper();
	
	@Before
	public void setUp(){
		endopointCheckEmail="/validEmail";
		challengeServiceImpl =  Mockito.mock(ChallengeServiceImpl.class);
		challengeController = new ChallengeController(challengeServiceImpl,objectMapper );
		this.mockMvc = MockMvcBuilders.standaloneSetup(challengeController).build();
	}
	
	@Test
	public void shouldReturnResponseValid() throws JsonProcessingException, Exception{
		
		when(challengeServiceImpl.checkEmail(anyString())).thenReturn("Format OK");
		ResultActions result = mockMvc.perform(post(endopointCheckEmail)
				.content( new ObjectMapper().writeValueAsString(new EmailRequest("email4@mail.com")))
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		result.andReturn().equals("Format OK");
		
	}
	
	@Test
	public void shouldReturnNotValidResponse() throws JsonProcessingException, Exception{
		
		when(challengeServiceImpl.checkEmail(anyString())).thenReturn("Wrong Format");
		ResultActions result = mockMvc.perform(post(endopointCheckEmail)
				.content( new ObjectMapper().writeValueAsString(new EmailRequest("email4@mail.com")))
				.contentType(MediaType.APPLICATION_JSON)
			    .accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		result.andReturn().equals("Wrong Format");
	}
	
}
