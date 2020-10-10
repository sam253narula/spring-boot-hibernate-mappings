package com.spring.boot.microservice;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.microservice.entity.Course;
import com.spring.boot.microservice.entity.Review;
import com.spring.boot.microservice.entity.ReviewRating;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootMainApplication implements CommandLineRunner {

	@Autowired
	EntityManager em;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		//get the existing course where id =  1
		Course course = em.find(Course.class, 1L);
		log.info("course.getReviews() -> {}", course.getReviews());
		//add two reviews to it and set the relationship
		Review review1 = new Review(ReviewRating.FIVE, "Awesome Course");
		Review review2 = new Review(ReviewRating.FIVE, "Good Course");
		course.addReview(review1);
		review1.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);
		
		//save it to the database
		em.persist(review1);
		em.persist(review2);
		
	}

}
