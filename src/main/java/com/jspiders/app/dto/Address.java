package com.jspiders.app.dto;

import javax.persistence.Embeddable;



@Embeddable
public class Address {
	
	public String pincode;
	public String street;
	public String city;
	public String state;
	
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(String pincode, String street, String city, String state) {
		super();
		this.pincode = pincode;
		this.street = street;
		this.city = city;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Address [pincode=" + pincode + ", street=" + street + ", city=" + city + ", state=" + state + "]";
	}
	
	

}
