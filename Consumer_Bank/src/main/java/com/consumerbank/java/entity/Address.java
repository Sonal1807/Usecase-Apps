package com.consumerbank.java.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private String state;
	private String city;
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}