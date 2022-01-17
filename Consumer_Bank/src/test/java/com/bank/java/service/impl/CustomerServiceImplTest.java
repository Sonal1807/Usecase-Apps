package com.bank.java.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.consumerbank.java.Dto.CustomerRequestDto;
import com.consumerbank.java.entity.Customer;
import com.consumerbank.java.repository.CustomerRepository;
import com.consumerbank.java.service.impl.CustomerServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceImplTest {
	@Mock
	CustomerRepository customerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	CustomerRequestDto customerRequestDto;

	Customer customer;

	Customer savedCustomer;

	@BeforeEach
	public void setUp() {
		customerRequestDto = new CustomerRequestDto();
		customerRequestDto.setCustomerName("Swati");
		customerRequestDto.setPhoneNo("8788888886");

		customer = new Customer();
		customer.setCustomerName("Swati");
		customer.setPhoneNo("8788888886");

		savedCustomer = new Customer();
		savedCustomer.setCustomerName("Swati");
		savedCustomer.setPhoneNo("8788888886");

		savedCustomer.setCustomerId(1);
	}

	@Test
	public void saveCustomerDataTest_Positive() {
     //context
		when(customerRepository.save(any(Customer.class))).thenAnswer(i -> {
			Customer customer = i.getArgument(0);
			customer.setCustomerId(1);
			return customer;
		});

     //event
		customerServiceImpl.saveCustomer(customerRequestDto);

    //outcome
		verify(customerRepository).save(any(Customer.class));
	}

	@Test
	public void saveCustomerDataTest_Negative() {
    //context
		when(customerRepository.save(any(Customer.class))).thenReturn(null);

     //event
		customerServiceImpl.saveCustomer(customerRequestDto);

      //outcome

		verify(customerRepository).save(any(Customer.class));
	}
}