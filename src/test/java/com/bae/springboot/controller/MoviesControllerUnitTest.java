package com.bae.springboot.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.springboot.entities.Movies;
import com.bae.springboot.service.MoviesServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class MoviesControllerUnitTest {

	//used for sending mock requests
	@Autowired
	private MockMvc mvc;
	
	//used for converting objects to JSON
		@Autowired
		private ObjectMapper mapper;
		
		@MockBean
		private MoviesServices service;

		@Test
		public void createTest() throws Exception {
			//An object for sending in the body of the request
			Movies input = new Movies(2L,"The Goonies", "Adventure", 1985, 7.7f);
			String inputAsJSON = mapper.writeValueAsString(input);
			
			// An Object for checking the response
			Movies response = new Movies(2L,"The Dark Knight", "Action", 2008, 9.0f);
			String responseAsJSON =mapper.writeValueAsString(response);
			
			Mockito.when(service.create(input)).thenReturn(response);
			
			mvc.perform(post("/movies/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(inputAsJSON))
				.andExpect(content().json(responseAsJSON));
		}
			
}
	

