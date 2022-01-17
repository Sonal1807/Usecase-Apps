package com.foodbank.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodbank.java.Dto.FoodItemRequestDto;
import com.foodbank.java.Dto.FoodItemResponseDto;
import com.foodbank.java.Dto.FoodItemResponseMap;
import com.foodbank.java.entity.FoodItem;
import com.foodbank.java.exception.CustomException;
import com.foodbank.java.repository.FoodItemRepository;
import com.foodbank.java.service.FoodItemService;

@Service
public class FoodItemServiceImpl implements FoodItemService {
	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public List<FoodItemResponseMap> getFoodItemById(Integer foodId) {
		if (foodItemRepository.findByFoodId(foodId).isEmpty())
			throw new CustomException("Food Item not found for given foodId");
		List<FoodItemResponseMap> responseList = foodItemRepository.findByFoodId(foodId);
		return responseList;
	}

	@Override
	public void saveFoodItem(FoodItemRequestDto foodItemRequestDto) {
		FoodItem foodItem = new FoodItem();
		BeanUtils.copyProperties(foodItemRequestDto, foodItem);
		foodItemRepository.save(foodItem);

	}

	@Override
	public List<FoodItemResponseDto> getFoodItemList() {
		List<FoodItemResponseDto> foodItemResponseDtoList = new ArrayList<FoodItemResponseDto>();
		Iterator<FoodItem> it = foodItemRepository.findAll().iterator();
		while (it.hasNext()) {
			FoodItemResponseDto foodItemResponseDto = new FoodItemResponseDto();
			BeanUtils.copyProperties(it.next(), foodItemResponseDto);
			foodItemResponseDtoList.add(foodItemResponseDto);

		}
		return foodItemResponseDtoList;

	}
}
