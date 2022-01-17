package com.orderservice.java.service.impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderservice.java.dto.OrderRequestDto;
import com.orderservice.java.dto.OrderResponseDto;
import com.orderservice.java.entity.OrderDetails;
import com.orderservice.java.exception.OrderNotFoundException;
import com.orderservice.java.repo.OrderRepo;
import com.orderservice.java.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderRepo orderRepo;

	@Override
	public String saveOrder(OrderRequestDto orderRequestDto) {

		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setDate(LocalDate.now());
		orderDetails.setTime(LocalTime.now());
		BeanUtils.copyProperties(orderRequestDto, orderDetails);
		OrderDetails savedUser = orderRepo.save(orderDetails);
		if (savedUser != null)
			return "order data saved successfully";
		return "order data save was unsuccessfull";
	}

	
	@Override
    public List<OrderResponseDto> getAllOrderDetails() {
        if (orderRepo.findAllOrders().isEmpty())
            throw new OrderNotFoundException ("order not found");
        return orderRepo.findAllOrders();
 
    }
}
