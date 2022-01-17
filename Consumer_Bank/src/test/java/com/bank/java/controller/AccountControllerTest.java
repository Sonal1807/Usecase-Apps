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

import com.consumerbank.java.Dto.AccountRequestDto;
import com.consumerbank.java.controller.AccountController;
import com.consumerbank.java.service.AccountService;


@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
	@Mock
	AccountService accountService;
	
	@InjectMocks
	AccountController accountController;
	
	AccountRequestDto accountRequestDto;
	@BeforeEach
	public void setUp()
	{
		accountRequestDto = new AccountRequestDto();
		accountRequestDto.setAccountType("SA");
		accountRequestDto.setBalance(5000.00);
		accountRequestDto.setCustomerId(1);
		
		
	}
	/*@Test
	@DisplayName("save account data: Positive scenario")
	public void saveAccountTest_Positive() {
		// context
		when(accountService.saveAccount(accountRequestDto)).thenReturn("Data saved successfully");
		// event
		ResponseEntity<String> result = accountController.saveAccount(accountRequestDto);
		// outcome
		assertEquals("Data saved successfully", result.getBody());
		assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

	}*/
}
