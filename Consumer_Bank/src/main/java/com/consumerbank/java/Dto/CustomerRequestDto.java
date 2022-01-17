package com.consumerbank.java.Dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.consumerbank.java.entity.Address;

public class CustomerRequestDto {

	@NotEmpty(message = "customer name cannot be null")
	private String customerName;
	@NotEmpty(message = "phone number cannot be null")
	@Size(min = 10, max = 10, message = "phone number should be 10 digits")
	private String phoneNo;
	private String emailId;
	private Address address;

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
