package com.bae.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.springboot.entities.Movies;
import com.bae.springboot.service.MoviesServices;

@RestController
@RequestMapping("/movies") // adds a prefix to the request URL
public class MoviesController {

	private MoviesServices service;
	
	public MoviesController(MoviesServices service) {
		super();
		this.service = service;
	}

	//get requests (Read - getall)
	
	@GetMapping("getAll")
	public List <Movies> getAll(){
		return this.service.getALL();
	}

	@GetMapping("/getByID/{id}")
	public Movies getById(@PathVariable Long id) {
		return this.service.getByID(id);
		
	}
	
	//Post request (CREATE)
	@PostMapping("/create")
	public Movies create(@RequestBody Movies movie) {
		return this.service.create(movie);
	}
	
	// Put request (UPDATE)
	@PutMapping("/update/{id}")
	public Movies update(@PathVariable long id,@RequestBody Movies movie) {
		return this.service.update(id, movie);
	}
	
	// Delete Request (Delete)
	@DeleteMapping("/delete/{id}")
		public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}
}
