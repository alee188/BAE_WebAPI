package com.bae.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.springboot.entities.Movies;

@Repository

public interface MoviesRepo extends JpaRepository <Movies, Long>{
	List<Movies> findMovieByTitle(String title); 	
	}
