package com.spring.boot.microservice;

import java.util.ArrayList;
import java.util.HashMap;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.microservice.entity.Passport;
import com.spring.boot.microservice.entity.Student;

import javassist.expr.NewArray;
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
		// Fetch passport from student
		Student s = em.find(Student.class, new Long(1));
		log.info("Retrieve Student -> {}", s);
		log.info("Retreive Passport -> {}", s.getPassport());
		// Fetch student from passport
		Passport p = em.find(Passport.class, new Long(2));
		log.info("Retrieve Passport -> {}", p);
		log.info("Retreive Student -> {}", p.getStudent());
	}

}
