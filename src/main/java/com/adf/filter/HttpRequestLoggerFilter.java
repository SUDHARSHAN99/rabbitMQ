package com.adf.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.adf.filter.MultiReadHttpServletRequest;

@Component
public class HttpRequestLoggerFilter implements Filter {

  private final Logger LOG = LoggerFactory.getLogger(HttpRequestLoggerFilter.class);

 // private final static String[] NO_LOG_API = {"/de-service/api/ping", "/de-service/api/dps/lead-verify"};
  
  @Override
  public void destroy() {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
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
    LOG.info("Content-Type : " + httpServletRequest.getRemoteHost());
    LOG.info("Content-Type : " + httpServletRequest.getServerName());
    HttpServletResponseCopier responseCopier = new HttpServletResponseCopier(httpServletResponse);

    chain.doFilter(multiReadRequest, responseCopier);
    byte[] copy = responseCopier.getCopy();
    System.out.println(new String(copy, response.getCharacterEncoding()));
    LOG.info(longLine);
  }

  @Override
  public void init(FilterConfig arg0) throws ServletException {
	  System.out.println("sudharshan");
  }

}
