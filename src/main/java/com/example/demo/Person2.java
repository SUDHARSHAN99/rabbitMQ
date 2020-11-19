package com.example.demo;

import java.io.Serializable;

import javax.annotation.ManagedBean;

import org.springframework.web.context.annotation.RequestScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@ManagedBean
@RequestScope
@JsonInclude(Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person2  {

	private int Id;
	private int lead_id;
	private int lead_identifier;
	private String name;
	
	private String contact;
	@JsonInclude(Include.NON_EMPTY)
	private Person2 requestBody;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Person2() {
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

	public Person2 getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Person2 requestBody) {
		this.requestBody = requestBody;
	}

	@Override
	public String toString() {
		return "Person2 [Id=" + Id + ", name=" + name + ", contact=" + contact + ", requestBody=" + requestBody + "]";
	}

}
