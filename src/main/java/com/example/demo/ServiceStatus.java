package com.example.demo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "value"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceStatus {


  public ServiceStatus(String value, int id) {
    this.value = value;
    this.id = id;
    this.optionalValue = "";
    this.emailToken="";
  }

  public ServiceStatus(String value, int id, String optionalValue) {
    this.value = value;
    this.id = id;
    this.optionalValue = optionalValue;
    this.emailToken="";
  }

  public ServiceStatus() {
      this.value = "SUCCESS";
      this.id = 200;
      this.optionalValue = "";
      this.emailToken="";
    }

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Id", required = true)
    @XmlSchemaType(name = "int")
    protected int id;
   
    
    protected String optionalValue;
    protected String emailToken;
    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    public String getOptionalValue() {
      return optionalValue;
    }

    public void setOptionalValue(String optionalValue) {
      this.optionalValue = optionalValue;
    }   

    public String getEmailToken() {
		return emailToken;
	}

	public void setEmailToken(String emailToken) {
		this.emailToken = emailToken;
	}

	@Override
	public String toString() {
		return "ServiceStatus [value=" + value + ", id=" + id + ", optionalValue=" + optionalValue + ", emailToken="
				+ emailToken + "]";
	}
}