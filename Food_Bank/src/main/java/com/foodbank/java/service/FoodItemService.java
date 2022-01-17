package com.foodbank.java.service;

import java.util.List;

import com.foodbank.java.Dto.FoodItemRequestDto;
import com.foodbank.java.Dto.FoodItemResponseDto;
import com.foodbank.java.Dto.FoodItemResponseMap;

public interface FoodItemService {

	List<FoodItemResponseMap> getFoodItemById(Integer foodId);

	void saveFoodItem(FoodItemRequestDto foodItemRequestDto);

	List<FoodItemResponseDto> getFoodItemList();

}
