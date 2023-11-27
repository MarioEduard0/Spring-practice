package com.example.demo.model;

import java.sql.Date;

public class User {

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Integer phone;
	private Integer creationDate;
	
	public User() {
	}
	
	public User(Integer id, String firstName, String lastName, Integer age, Integer phone, Integer creationDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.phone = phone;
		this.creationDate = creationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Integer creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone="
				+ phone + ", creationDate=" + creationDate + "]";
	}
	
	
	

}