package com.spring.boot.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	private ReviewRating rating;

	private String description;

	@ManyToOne
	private Course course;

	protected Review() {
	}

	public Review(ReviewRating rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description);
	}

}