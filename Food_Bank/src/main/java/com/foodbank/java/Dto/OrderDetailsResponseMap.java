package com.foodbank.java.Dto;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;

public interface OrderDetailsResponseMap {
	Integer getOrderId();

	Integer getQuantity();

	Double getTotalPrice();

	LocalDate getDate();

	Long getOrderNumber();

	@Value("#{target.foodItem.foodId}")
	Integer getFoodId();

	@Value("#{target.user.userId}")
	Integer getUserId();

}
