package com.orderservice.java.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orderservice.java.dto.OrderRequestDto;
import com.orderservice.java.dto.OrderResponseDto;
import com.orderservice.java.service.OrderService;

@RestController
@Validated
public class OrderController {

	@Autowired
	OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<String> placeOrder(@Valid @RequestBody OrderRequestDto orderRequestDto) {
		String response = orderService.saveOrder(orderRequestDto);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/orders/orderDetails")
	public ResponseEntity<List<OrderResponseDto>> getAllOrderDetails() {
		return new ResponseEntity<List<OrderResponseDto>>(orderService.getAllOrderDetails(), HttpStatus.ACCEPTED);

	}
}
