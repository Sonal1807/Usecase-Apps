package com.foodbank.java.service;

import java.util.List;

import com.foodbank.java.Dto.OrderDetailRequestDto;
import com.foodbank.java.Dto.OrderDetailResponseDto;
import com.foodbank.java.Dto.OrderDetailsResponseMap;

public interface OrderDetailService {

	void saveOrderDetail(OrderDetailRequestDto orderDetailRequestDto);

	List<OrderDetailsResponseMap> getOrderDetailsByUserId(Integer userId);

	List<OrderDetailResponseDto> getAllOrderDetails();

}
