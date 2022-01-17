
package com.consumerbank.java.service;

import java.util.List;
import com.consumerbank.java.Dto.CustomerRequestDto;
import com.consumerbank.java.Dto.CustomerResponseDto;
import com.consumerbank.java.Dto.CustomerResponseMap;

public interface CustomerService {
	String saveCustomer(CustomerRequestDto customerRequestDto);

	List<CustomerResponseDto> getCustomers();

	void deleteCustomer(Integer customerId);

	List<CustomerResponseMap> getCustomerbyName(String customerName);

	// void updateCustomerDetails(CustomerRequestDto customerRequestDto, Integer
	// customerId);
}
