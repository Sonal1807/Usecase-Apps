package com.foodbank.java.test.controller;

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

import com.foodbank.java.Dto.UserRequestDto;
import com.foodbank.java.controller.UserController;
import com.foodbank.java.entity.Address;
import com.foodbank.java.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	@Mock
	UserService userService;
	@InjectMocks
	UserController userController;
	UserRequestDto userRequestDto;

	@BeforeEach
	public void setUp() {
		UserRequestDto userRequestDto = new UserRequestDto();
		Address address = new Address();
		address.setCity("Surat");
		address.setState("Gujarat");
		userRequestDto.setUserName("Rachit");
		userRequestDto.setPassword("rachit");
		userRequestDto.setPhoneNo("9745652425");
		userRequestDto.setEmailId("rachit@gmail.com");
		userRequestDto.setAddress(address);

	}

	@Test
	@DisplayName("save User data")
	public void saveUserTest() {
		// context
		when(userService.saveUser(userRequestDto)).thenReturn("User data saved successfully");
		// event
		ResponseEntity<String> result = userController.saveUser(userRequestDto);
		// outcome
		assertEquals("User data saved successfully", result.getBody());
		assertEquals(HttpStatus.ACCEPTED, result.getStatusCode());

	}

}
