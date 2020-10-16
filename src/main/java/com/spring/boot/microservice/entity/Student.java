package com.spring.boot.microservice.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.Setter;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport;

	@ManyToMany
	@JoinTable(name = "STUDENT_COURSE",
	joinColumns = @JoinColumn(name  = "STUDENT_ID"),
	inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
	private List<Course> courses = new ArrayList<>();

	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
}