/**
 * 
 */
package com.example.demo;

/**
 * @author sudharshanreddy
 *
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
@Service
public class ServiceHelper {

  private final Logger LOG = LoggerFactory.getLogger(ServiceHelper.class);
  
  @Autowired
  private ObjectMapper objectMapper;
  
  @Autowired
 private RequestContext reqContext;

  public <T> T bindJsonToObj(String request, Class<T> clazz) {
    LOG.info("Request Body --> " + request);
    try {
      T t = objectMapper.readValue(request, clazz);
      return t;
    } catch (IOException e) {
      e.printStackTrace();
    }
	return null;
  }

  public <T> T bindJsonToObj(String request, Class<T> clazz, boolean log) {
    if(log) {
      LOG.info("Request Body --> " + request);
    }
    try {
      T t = objectMapper.readValue(request, clazz);
      return t;
    } catch (IOException e) {
    	e.printStackTrace();
    }
	return null;
  }

  public <T> List<T> bindJsonArrayToList(String request, Class<T> clazz) {
    LOG.info("Request Body --> " + request);
    try {
      List<T> t = objectMapper.readValue(request,
          TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, clazz));
      return t;
    } catch (IOException e) {
    	e.printStackTrace();
    }
	return null;
  }

  public String generateJsonFromObj(Object obj) {
    if(String.class.isInstance(obj)) {
      LOG.info("Response Body --> ");
      LOG.info("" + obj);
      return (String) obj;
    }
    String response="";
    try {
      response = objectMapper.writeValueAsString(obj);
    } catch (JsonProcessingException e) {
      LOG.info("Error while createing response, ", e);
      e.printStackTrace();
    }
    LOG.info("Response Body --> " + response);
    return response;
  }

public void method(Person2 person) {
	System.out.println("Testing Code");
	try {
		//System.out.println("testing person Sudharshan"+ reqContext.getRequestBody());
		int a = 99/99;
	}catch (Exception e) {
		System.out.println(e.getStackTrace().toString());
		
			/*
			 * HttpServletRequest currentRequest = ((ServletRequestAttributes)
			 * RequestContextHolder.currentRequestAttributes()) .getRequest();
			 * 
			 * 
			 * 
			 * HttpServletRequest pp = (HttpServletRequest) reqContext.getRequestBody();
			 */
	}
	
}
public Object savePerson(@RequestBody Object person, WebRequest webRequest) {
	//person2.setRequestBody(person);
    webRequest.setAttribute("person", person, RequestAttributes.SCOPE_REQUEST);
	return person;
}
}
