package com.foodbank.java.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodbank.java.Dto.OrderDetailRequestDto;
import com.foodbank.java.Dto.OrderDetailResponseDto;
import com.foodbank.java.Dto.OrderDetailsResponseMap;
import com.foodbank.java.entity.FoodItem;
import com.foodbank.java.entity.OrderDetail;
import com.foodbank.java.entity.User;
import com.foodbank.java.exception.CustomException;
import com.foodbank.java.repository.FoodItemRepository;
import com.foodbank.java.repository.OrderDetailRepository;
import com.foodbank.java.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetailRepository orderDetailRepository;
	@Autowired
	FoodItemRepository foodItemRepository;

	@Override
	public void saveOrderDetail(OrderDetailRequestDto orderDetailRequestDto) {
		Optional<FoodItem> opFoodItem = foodItemRepository.findById(orderDetailRequestDto.getFoodId());
		if (!opFoodItem.isPresent()) {
			throw new CustomException("Food Item not available for ordered foodId");
		}
		FoodItem foodItem = opFoodItem.get();
		User user = new User();
		OrderDetail orderDetail = new OrderDetail();
		orderDetail.setDate(LocalDate.now());
		orderDetail.setTotalPrice(orderDetailRequestDto.getQuantity() * foodItem.getPrice());
		orderDetail.setFoodItem(foodItem);
		foodItem.setFoodId(orderDetailRequestDto.getFoodId());
		orderDetail.setUser(user);
		user.setUserId(orderDetailRequestDto.getUserId());
		BeanUtils.copyProperties(orderDetailRequestDto, orderDetail);
		orderDetailRepository.save(orderDetail);

	}

	@Override
	public List<OrderDetailsResponseMap> getOrderDetailsByUserId(Integer userId) {
		if (orderDetailRepository.findByUserUserIdLike(userId).isEmpty())
			throw new CustomException("No orders done by the given user");
		List<OrderDetailsResponseMap> responseList = orderDetailRepository.findByUserUserIdLike(userId);
		return responseList;
	}

	@Override
	public List<OrderDetailResponseDto> getAllOrderDetails() {
		if (orderDetailRepository.findAllOrders().isEmpty())
			throw new CustomException("No orders found");
		return orderDetailRepository.findAllOrders();

	}

}
