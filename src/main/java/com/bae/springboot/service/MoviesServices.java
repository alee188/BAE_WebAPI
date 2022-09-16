package com.bae.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.springboot.entities.Movies;
import com.bae.springboot.repo.MoviesRepo;

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
		return this.repo.findAll();
	}
	// get by ID (read)
	public Movies getByID(long id) {
		return repo.findById(id).get();
	}
	// Update requests
	public Movies update (long id, Movies movie) {
		Movies existing = this.repo.findById(id).get();
		existing.setTitle(movie.getTitle());
		existing.setGenre(movie.getGenre());
		existing.setReleaseYear(movie.getReleaseYear());
		existing.setUserRating(movie.getUserRating());
		
		return this.repo.saveAndFlush(existing);
	}
	// delete Request (Delete)
	public boolean delete (long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id); // returns true if an entry is deleted
	}
}
