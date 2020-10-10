package com.spring.boot.microservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.boot.microservice.dto.MyIntroductionDTO;
import com.spring.boot.microservice.dto.Salary;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ExampleService {
	public String Hello() {
		return "Hello World";
	}
	
	public MyIntroductionDTO myInfo(@PathVariable String name, @PathVariable String experiance,
			@PathVariable String skills, String basePay) {
		// normal
		MyIntroductionDTO dto = new MyIntroductionDTO();
		dto.setExperiance("3");

		// normal builder salary
		MyIntroductionDTO.builder().name(name).experiance(experiance).skills(skills).build();

		// Builder inside Builder
		log.debug("builder log");
		return  MyIntroductionDTO.builder().name(name).experiance(experiance).skills(skills)
				.salary(Salary.builder().basePay("50000").vp("10000").build()).build();

	}
	
	public String HelloJenkins() {
		return "Hello Jenkins";
	}
}
