package com.bae.springboot.service;

import org.springframework.stereotype.Service;

import com.bae.springboot.entities.Movies;

@Service
public class MoviesServices {
	
	private MoviesRepo repo;
	
	// dependency injection
	public MoviesServices (MoviesRepo repo) {
		this.repo = repo;
	}
	// post requests (CREATE)
	public Movies create(Movies movie) {
		return this.repo.saveAndFlush(movie);
	}
	// get requests (READ)
	public List<Movies> getALL(){
		return this.repo.findALL();
	}
}
