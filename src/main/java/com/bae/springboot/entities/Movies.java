package com.bae.springboot.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Movies {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column (nullable = false)
	private String title;
	
	@Column (nullable = false)
	private String genre;
	
	@Column (nullable = false)
	private int releaseYear;
	
	@Column (nullable = false)
	private float userRating;
	
	// default constructor
	public Movies () {}

	public Movies(long id, String title, String genre, int releaseYear, float userRating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.userRating = userRating;
	}
	
	
}
