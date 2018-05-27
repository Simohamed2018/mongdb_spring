package com.kazale.crud.api.documents;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Student {

	@Id
	private String id;
	private String name;
	private String email;
	private String city;

	public Student() {
	}

	public Student(String name, String email, String city) {
		this.name=name;
		this.email=email;
		this.city=city;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "name not valid ")
	public String getName() {
		return name
				;
	}

	public void setName(String name
	) {
		this.name= name ;
	}

	@NotEmpty(message = "Email must be not empty")
	@Email(message = "Email invalid")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "City must be not null")

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
