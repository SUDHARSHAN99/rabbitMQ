package com.example.demo;

import java.io.Serializable;

import javax.annotation.ManagedBean;

import org.springframework.web.context.annotation.RequestScope;
@ManagedBean
@RequestScope
public class Person implements Serializable {

	private int Id;

	private String name;
	
	private Person requestBody;

	public Person() {
		super();
		
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Person requestBody) {
		this.requestBody = requestBody;
	}

}
