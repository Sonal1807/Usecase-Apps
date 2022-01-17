package com.userservice.java.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.java.entity.User;
import com.userservice.java.service.UserService;

@RestController
public class UserController {


	@Autowired
	UserService userService;

	@GetMapping("/users/userlogin")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String getWelcomeNote(Principal principal) {
		return "user login successfully";
	}

	@PostMapping("/users")
	public String registration(@RequestBody User user) {
		userService.registerUser(user);
		return "Success";
	}

}