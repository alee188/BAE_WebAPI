package com.bae.springboot.service;

import org.springframework.stereotype.Service;

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
}
