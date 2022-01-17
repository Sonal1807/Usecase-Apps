package com.foodbank.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodbank.java.Dto.FoodItemResponseDto;
import com.foodbank.java.Dto.UserRequestDto;
import com.foodbank.java.entity.FoodItem;
import com.foodbank.java.entity.User;
import com.foodbank.java.exception.CustomException;
import com.foodbank.java.repository.FoodItemRepository;
import com.foodbank.java.repository.UserRepository;
import com.foodbank.java.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public String loginUser(String userName, String password) {
		Optional<User> opUser = userRepository.findByUserNameAndPasswordLike(userName, password);
		if (opUser.isPresent()) {
			return "Hi " + userName + "!! You're logged in succesfully ";
		} else {
			return "Unable to Login.Please enter valid credentials";
		}

	}

	@Override
	public String saveUser(UserRequestDto userRequestDto) {
		User user = new User();
		BeanUtils.copyProperties(userRequestDto, user);
		User savedUser = userRepository.save(user);
		if (savedUser != null)
			return "User data saved successfully";
		return "User data save was unsuccessfull";
	}

}
