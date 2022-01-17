package com.foodbank.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodbank.java.Dto.FoodItemResponseDto;
import com.foodbank.java.Dto.OrderDetailRequestDto;
import com.foodbank.java.Dto.UserRequestDto;
import com.foodbank.java.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/users")
	public ResponseEntity<String> saveUser(@RequestBody UserRequestDto userRequestDto) {
		String response = userService.saveUser(userRequestDto);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/users/login")
	public ResponseEntity<String> loginUser(@RequestParam String userName, @RequestParam String password) {
		return new ResponseEntity<String>(userService.loginUser(userName, password), HttpStatus.ACCEPTED);

	}

}
