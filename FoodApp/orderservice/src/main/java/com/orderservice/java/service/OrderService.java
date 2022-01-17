package com.orderservice.java.service;

import java.util.List;

import com.orderservice.java.dto.OrderRequestDto;
import com.orderservice.java.dto.OrderResponseDto;

public interface OrderService {

	// void saveOrderDetails(OrderRequestDto orderRequestDto);
	String saveOrder(OrderRequestDto orderRequestDto);

	List<OrderResponseDto> getAllOrderDetails();

}
