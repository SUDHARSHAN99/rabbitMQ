package com.example.demo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ServiceStatusResponse {
  private boolean sellable;
  private String state;
  private String applicationID;
  @JsonFormat(timezone = "PST", shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date expiryDate;
  @JsonFormat(timezone = "PST", shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
  private Date updatedDate;
  private String decisionTreePath;
  private int noOfCustomers;
  private String emailToken;


  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
  
  public boolean isSellable() {
    return sellable;
  }

  public void setSellable(boolean sellable) {
    this.sellable = sellable;
  }

  private ServiceStatus status = new ServiceStatus();

  public ServiceStatusResponse() {}

  public ServiceStatusResponse(ServiceStatus status) {
    this.status = status;
  }

  public ServiceStatus getStatus() {
    return status;
  }

  public void setStatus(ServiceStatus status) {
    this.status = status;
  }


  public String getApplicationID() {
    return applicationID;
  }

  public void setApplicationID(String applicationID) {
    this.applicationID = applicationID;
  }

  public Date getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(Date expiryDate) {
    this.expiryDate = expiryDate;
  }

  public String getDecisionTreePath() {
    return decisionTreePath;
  }

  public void setDecisionTreePath(String decisionTreePath) {
    this.decisionTreePath = decisionTreePath;
  }

  public int getNoOfCustomers() {
    return noOfCustomers;
  }

  public void setNoOfCustomers(int noOfCustomers) {
    this.noOfCustomers = noOfCustomers;
  }

  public Date getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Date updatedDate) {
    this.updatedDate = updatedDate;
  }

  public String getEmailToken() {
		return emailToken;
	}

  public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}
  
  @Override
public String toString() {
	return "ServiceStatusResponse [sellable=" + sellable + ", state=" + state + ", applicationID=" + applicationID
			+ ", expiryDate=" + expiryDate + ", updatedDate=" + updatedDate + ", decisionTreePath=" + decisionTreePath
			+ ", noOfCustomers=" + noOfCustomers + ", emailToken=" + emailToken + ", status=" + status +"]";
}

}
