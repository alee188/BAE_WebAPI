package com.bae.springboot.controller;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.springboot.entities.Movies;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@Sql (scripts = {"classpath:testschema.sql", "classpath:testdata.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test") //changes prod to test in application properties
public class MoviesControllerIntegrationTest {
	//used for sending mock requests
	@Autowired
	private MockMvc mvc;
	
	//used for converting objects to JSON
	@Autowired
	private ObjectMapper mapper;
	
	// read all test
	@Test
	public void getAllTest() throws Exception{
		List<Movies> result = new ArrayList <> ();
		result.add(new Movies (1L, "Star Wars", "Sci-fi", 1977, 8.6f));
		// covert output(Java) to JSON
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(get("movies/getAll"))
			.contentType(MediaType.APPLICATION_JSON)
			.andExpect(status().isOk())
			.andExpect(content().json(resultAsJSON));
		
	}

	// create test
	@Test
	public void createTest() throws Exception{
		Movies entry = new Movies (2L, "Gladiator", "Action", 2000, 8.5f);
		String entryAsJSON = mapper.writeValueAsString(entry);
		
		Movies result = new Movies (2L,"Gladiator", "Action",2000,8.5f);
		String resultAsJSON = mapper.writeValueAsString(result);
		
		mvc.perform(post("/movies/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
	}
	
	//Update test
	@Test
	public void updateTest() throws Exception {
		Movies entry = new Movies (1L, "Star wars 2", "Action", 1980, 8.7f);
		Movies result = new Movies (1L, "Star wars 2", "Action", 1980, 8.7f);
		String entryAsJSON = this.mapper.writeValueAsString(entry);
		String resultAsJSON = this.mapper.writeValueAsString(result);
		
		mvc.perform(put("/movies/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryAsJSON))
				.andExpect(content().json(resultAsJSON));
		
	}
	
	// Delete test
	@Test
	public void deleteTest() throws Exception{
		mvc.perform(delete("/movies/delte/1"))
			.contentType(MediaType.APPLICATION_JSON)
			.andExpect(content().string("true"));
	}
}
