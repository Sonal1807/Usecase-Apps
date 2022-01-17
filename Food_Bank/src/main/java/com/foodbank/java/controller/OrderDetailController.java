package com.foodbank.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodbank.java.Dto.OrderDetailRequestDto;
import com.foodbank.java.Dto.OrderDetailResponseDto;
import com.foodbank.java.Dto.OrderDetailsResponseMap;
import com.foodbank.java.service.OrderDetailService;

@RestController
public class OrderDetailController {
	@Autowired
	OrderDetailService orderDetailService;

	@PostMapping("/orderDetails")
	public ResponseEntity<String> saveOrderDetail(@RequestBody OrderDetailRequestDto orderDetailRequestDto) {
		orderDetailService.saveOrderDetail(orderDetailRequestDto);
		return new ResponseEntity<String>("Order details added succesfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/orderDetails/{userId}")
	public ResponseEntity<List<OrderDetailsResponseMap>> getOrderDetailsByUserId(@PathVariable Integer userId) {
		return new ResponseEntity<List<OrderDetailsResponseMap>>(orderDetailService.getOrderDetailsByUserId(userId),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/orderDetails")
	public ResponseEntity<List<OrderDetailResponseDto>> getAllOrderDetails() {
		return new ResponseEntity<List<OrderDetailResponseDto>>(orderDetailService.getAllOrderDetails(),
				HttpStatus.ACCEPTED);

	}

}
