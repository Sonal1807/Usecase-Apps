package com.userservice.java.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.userservice.java.entity.User;
import com.userservice.java.repo.UserRepo;
import com.userservice.java.service.UserService;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> userOptional = userRepo.findByUserName(username);
		if (userOptional.isPresent())
			return new MyUserDetails(userOptional.get());
		return null;
	}

	@Override
	public void registerUser(User user) {
		userRepo.save(user);
	}

}
