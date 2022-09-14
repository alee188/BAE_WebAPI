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

	// getters and setters
	public Movies(long id, String title, String genre, int releaseYear, float userRating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
		this.userRating = userRating;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public float getUserRating() {
		return userRating;
	}

	public void setUserRating(float userRating) {
		this.userRating = userRating;
	}

	// hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(genre, id, releaseYear, title, userRating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		return Objects.equals(genre, other.genre) && id == other.id && releaseYear == other.releaseYear
				&& Objects.equals(title, other.title)
				&& Float.floatToIntBits(userRating) == Float.floatToIntBits(other.userRating);
	}
	
	
	
}
