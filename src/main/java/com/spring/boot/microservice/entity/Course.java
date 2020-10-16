package com.spring.boot.microservice.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Course {

	// private static Logger LOGGER = LoggerFactory.getLogger(Course.class);

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();
//	@OneToMany(mappedBy="course", fetch = FetchType.EAGER)
//	private List<Review> reviews = new ArrayList<>();

	@ManyToMany(mappedBy="courses")
	private List<Student> students = new ArrayList<>();

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	protected Course() {
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public Course(String name) {
		this.name = name;
	}

//	public List<Review> getReviews() {
//		return reviews;
//	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("Course[%s]", name);
	}
}
