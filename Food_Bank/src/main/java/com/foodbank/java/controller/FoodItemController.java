package com.foodbank.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodbank.java.Dto.FoodItemRequestDto;
import com.foodbank.java.Dto.FoodItemResponseDto;
import com.foodbank.java.Dto.FoodItemResponseMap;
import com.foodbank.java.Dto.UserRequestDto;
import com.foodbank.java.service.FoodItemService;

@RestController
public class FoodItemController {
	@Autowired
	FoodItemService foodItemService;

	@PostMapping("/foodItems")
	public ResponseEntity<String> saveFoodItem(@RequestBody FoodItemRequestDto foodItemRequestDto) {
		foodItemService.saveFoodItem(foodItemRequestDto);
		return new ResponseEntity<String>("Food Item added succesfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/foodItems/{foodId}")
	public ResponseEntity<List<FoodItemResponseMap>> getFoodItemById(@PathVariable Integer foodId) {
		return new ResponseEntity<List<FoodItemResponseMap>>(foodItemService.getFoodItemById(foodId),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/foodItems")
	public ResponseEntity<List<FoodItemResponseDto>> getFoodItemList() {
		return new ResponseEntity<List<FoodItemResponseDto>>(foodItemService.getFoodItemList(), HttpStatus.ACCEPTED);
	}

}
