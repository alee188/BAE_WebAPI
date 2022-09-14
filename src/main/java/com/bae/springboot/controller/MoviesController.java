package com.bae.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Movies") // adds a prefix to the request URL
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
		return this.service.getByid(id);
		
	}
}
