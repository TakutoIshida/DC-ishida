package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PrifData {
	@Id
	@GeneratedValue
	int id;
	
	String name;
	String products;
	public PrifData(String name, String products) {
		super();
		this.name = name;
		this.products = products;
	}
}
