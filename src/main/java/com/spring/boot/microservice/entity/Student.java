package com.spring.boot.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

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

	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
}