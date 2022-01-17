package com.orderservice.java.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderResponseDto {
	private Integer orderId;
	private Integer userId;
	private Integer foodId;
	private Integer quantity;
	private LocalTime Time = LocalTime.now();
	private LocalDate Date = LocalDate.now();

	public OrderResponseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderResponseDto(Integer orderId, Integer userId, Integer foodId, Integer quantity, LocalTime time,
			LocalDate date) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.foodId = foodId;
		this.quantity = quantity;
		Time = time;
		Date = date;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public LocalTime getTime() {
		return Time;
	}

	public void setTime(LocalTime time) {
		Time = time;
	}

	public LocalDate getDate() {
		return Date;
	}

	public void setDate(LocalDate date) {
		Date = date;
	}

}
