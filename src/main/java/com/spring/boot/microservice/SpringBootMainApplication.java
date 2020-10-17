package com.spring.boot.microservice;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.microservice.entity.Course;
import com.spring.boot.microservice.entity.Student;

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
		//Get a Student and his courses
		Student student = em.find(Student.class, 1L);

		log.info("student -> {}", student);
		log.info("courses -> {}", student.getCourses());
		
		// Insert a new Student and his Courses
		Student aniket  = new Student("Aniket");
		Course hibernate = new Course("Advance Hibernate");
		em.persist(aniket);
		em.persist(hibernate);
		
		//set relationship
		aniket.addCourse(hibernate);
		hibernate.addStudent(aniket);
		//persist
		em.persist(aniket);

	}

}
