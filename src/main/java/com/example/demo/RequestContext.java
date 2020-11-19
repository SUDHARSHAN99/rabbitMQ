/**
 * 
 */
package com.example.demo;

import javax.annotation.ManagedBean;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author sudharshanreddy
 *
 */
@ManagedBean
@RequestScope
public class RequestContext {
	Object requestBody;

	public Object getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(Object requestBody) {
		this.requestBody = requestBody;
	}
	
}
