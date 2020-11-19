package com.example.demo;

public class APIRequestValidationException extends RuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 497614120488832551L;

  private String message;
  
  public APIRequestValidationException(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
  
  
}
