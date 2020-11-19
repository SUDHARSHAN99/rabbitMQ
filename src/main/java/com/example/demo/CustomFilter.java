package com.example.demo;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.adf.filter.HttpRequestLoggerFilter;
import com.adf.filter.HttpServletResponseCopier;
import com.adf.filter.MultiReadHttpServletRequest;

@Component
public class CustomFilter implements Filter {
	private final Logger LOG = LoggerFactory.getLogger(HttpRequestLoggerFilter.class);
	 ExecutorService taskExecutor = Executors.newFixedThreadPool(10);
	@Autowired
	private ControllerHelper cntlrHelper;
	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response,
	        FilterChain chain) throws IOException, ServletException {
		  String longLine = "**==================================================================================================================**";
		    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		    MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest(httpServletRequest);
		    boolean doLog = true;
				/*
				 * for (String uri : NO_LOG_API) {
				 * if(httpServletRequest.getRequestURI().equals(uri)) { doLog = false; break; }
				 * }
				 */
		    if(doLog) {
		      LOG.info(longLine);
		      LOG.info("Request Recieved");
		      LOG.info("Request-URI : " + httpServletRequest.getRequestURI());
		      LOG.info("Method : " + httpServletRequest.getMethod());
		      LOG.info("Content-Type : " + httpServletRequest.getContentType());
		    }
		    HttpServletResponseCopier responseCopier = new HttpServletResponseCopier(httpServletResponse);
		    LOG.info("Content-Type : " + httpServletRequest.getRemoteHost());
		    LOG.info(" getRemoteAddr: " + httpServletRequest.getRemoteAddr());
		    LOG.info("Content-Type : " + httpServletRequest.getServerName());
		    chain.doFilter(multiReadRequest, responseCopier);
		    byte[] copy = responseCopier.getCopy();
		    String str = new String(copy, response.getCharacterEncoding());
		    Runnable runnable = () -> {
		        cntlrHelper.bindRespJsonToObj(str, Person2.class);
		    };
		    taskExecutor.submit(runnable);
		    //Person2 Person2 = cntlrHelper.bindRespJsonToObj(str, Person2.class);
		    //System.out.println(Person2.toString());
		   // System.out.println("Response" +new String(copy, response.getCharacterEncoding()));
		    LOG.info(longLine);
	  }
	}