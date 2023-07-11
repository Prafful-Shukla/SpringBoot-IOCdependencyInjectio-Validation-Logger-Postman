//employee model using this we can hold the data inn our hand

package com.example.api.thfeb.demoapi4thfeb;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Employee {

	
	private Integer id;
	
	@NotNull  //all these annotation will work after u add @valid in controller
	private String name;
	
	@Min(20)
	@Max(60)
	private int age;
	private String designation;
	
	@Email
	private String email;
	
	//enum i.e group of constant that cannot be changed nad used across application 
	private Gender gender;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

}
