package com.spring.boot.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.microservice.dto.MyIntroductionDTO;
import com.spring.boot.microservice.dto.Salary;
import com.spring.boot.microservice.service.ExampleService;

@RestController
@RequestMapping("/")
public class ExampleController {

	ExampleService example = new ExampleService();

	@GetMapping("/hello")
	public String Hello() {
		return example.Hello();
	}

	@GetMapping("/helloJenkins")
	public String HelloJenkins() {
		return example.HelloJenkins();
	}

	@PostMapping("/myInfo/{name}/{experiance}/{skills}")
	public MyIntroductionDTO myInfo(@PathVariable String name, @PathVariable String experiance,
			@PathVariable String skills, String basePay) {
		
		return  example.myInfo(name, experiance, skills, basePay);

	}
}
