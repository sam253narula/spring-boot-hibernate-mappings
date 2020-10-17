package com.spring.boot.microservice;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.spring.boot.microservice.entity.Employee;
import com.spring.boot.microservice.entity.FullTimeEmployee;
import com.spring.boot.microservice.entity.PartTimeEmployee;

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
		
		//Insert an employee
		Employee sam  = new PartTimeEmployee("Sam", new BigDecimal(5000));
		Employee aniket  = new FullTimeEmployee("Aniket", new BigDecimal(180000));
		
		
		em.persist(aniket);
		em.persist(sam);
		
		//Retrieve all employees
		List<Employee> employees  = em.createQuery("select e from Employee e", Employee.class).getResultList();
		log.info("Employees -> {}",employees);
		
	}

}
