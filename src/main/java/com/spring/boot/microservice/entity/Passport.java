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
public class Passport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String number;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
	private Student student;
	
	protected Passport() {
	}
	
	public Passport(String number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return String.format("Passport[%s]", number);
	}
}