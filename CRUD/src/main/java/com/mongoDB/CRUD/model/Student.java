package com.mongoDB.CRUD.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter

@Document(collection = "Student")
public class Student {

	public Student() {
		super();
	}

	public Student(int stuId, String firstName, String lastName, String email) {
		super();
		this.stuId = stuId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Id
	private int stuId;
	private String firstName;
	private String lastName;
	private String email;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

}
