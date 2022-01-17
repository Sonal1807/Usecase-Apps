
package com.consumerbank.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consumerbank.java.Dto.CustomerRequestDto;
import com.consumerbank.java.Dto.CustomerResponseDto;
import com.consumerbank.java.Dto.CustomerResponseMap;
import com.consumerbank.java.entity.Customer;
import com.consumerbank.java.exception.CustomException;
import com.consumerbank.java.repository.CustomerRepository;
import com.consumerbank.java.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String saveCustomer(CustomerRequestDto customerRequestDto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerRequestDto, customer);
		Customer savedCustomer = customerRepository.save(customer);
		if (savedCustomer != null)
			return "Data saved successfully";
		return "Data save was unsuccessfull";
	}

	@Override
	public List<CustomerResponseDto> getCustomers() {
		List<CustomerResponseDto> customerResponseDtoList = new ArrayList<CustomerResponseDto>();
		Iterator<Customer> it = customerRepository.findAll().iterator();
		while (it.hasNext()) {
			CustomerResponseDto customerResponseDto = new CustomerResponseDto();
			BeanUtils.copyProperties(it.next(), customerResponseDto);
			customerResponseDtoList.add(customerResponseDto);
		}
		return customerResponseDtoList;
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).get();
		if (customer == null)
			throw new CustomException("Customer not found with customerId: " + customerId);
		customer = new Customer();
		customer.setCustomerId(customerId);
		customerRepository.delete(customer);
	}

	@Override
	public List<CustomerResponseMap> getCustomerbyName(String customerName) {
		List<CustomerResponseMap> customerResponse = customerRepository.findByCustomerNameContaining(customerName);
		if (customerResponse.isEmpty())
			throw new CustomException("Customer not found with given name: " + customerName);
		return customerResponse;
	}

	/*
	 * @Override public void updateCustomerDetails(CustomerRequestDto
	 * customerRequestDto, Integer customerId) { Customer customer =
	 * customerRepository.updateCustomerDetails(customerRequestDto, customerId);
	 * BeanUtils.copyProperties(customerRequestDto, customer);
	 * customerRepository.updateCustomerDetails(customerRequestDto, customerId); }
	 */
}
