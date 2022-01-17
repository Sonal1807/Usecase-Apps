package com.foodbank.java.service;

import java.util.List;
import com.foodbank.java.Dto.FoodItemResponseDto;
import com.foodbank.java.Dto.UserRequestDto;

public interface UserService {

	String loginUser(String userName,String password);

	String saveUser(UserRequestDto userRequestDto);

}
