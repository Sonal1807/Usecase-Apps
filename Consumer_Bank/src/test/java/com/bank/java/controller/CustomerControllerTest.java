package com.bank.java.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.consumerbank.java.Dto.CustomerRequestDto;
import com.consumerbank.java.controller.CustomerController;
import com.consumerbank.java.service.CustomerService;

@ExtendWith(MockitoExtension.class)
public class CustomerControllerTest {
	@Mock
	CustomerService customerService;
	@InjectMocks
	CustomerController customerController;

	CustomerRequestDto customerRequestDto;

	@BeforeEach
	public void setUp() {
		customerRequestDto = new CustomerRequestDto();

		customerRequestDto.setCustomerName("Anuj");
		customerRequestDto.setPhoneNo("9858456525");
		customerRequestDto.setEmailId("anuj@gmail.com");
		customerRequestDto.setAddress(null);

	}

	@Test
	@DisplayName("save customer data: Positive scenario")
	public void saveCustomerTest_Positive() {
		// context
		when(customerService.saveCustomer(customerRequestDto)).thenReturn("Data saved successfully");
		// event
		ResponseEntity<String> result = customerController.saveCustomer(customerRequestDto);
		// outcome
		assertEquals("Data saved successfully", result.getBody());
		assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());
		

	}

	@Test
	@DisplayName("save customer data: Negative scenario")
	public void saveCustomerTest_Negative() {
		// context
		when(customerService.saveCustomer(customerRequestDto)).thenReturn("Data save was unsuccessfull");
		// event
		ResponseEntity<String> result = customerController.saveCustomer(customerRequestDto);
		// outcome
		assertEquals("Data save was unsuccessfull", result.getBody());
		assertEquals(HttpStatus.NOT_ACCEPTABLE, result.getStatusCode());

	}

}
