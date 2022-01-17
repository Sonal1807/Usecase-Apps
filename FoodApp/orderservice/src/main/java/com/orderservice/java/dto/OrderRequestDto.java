package com.orderservice.java.dto;

import javax.validation.constraints.NotNull;

public class OrderRequestDto {

	@NotNull(message = "userid cannot be null")
	private Integer userId;

	@NotNull(message = "foodid cannot be null")
	private Integer foodId;

	@NotNull(message = "quantity cannot be null")
	private Integer quantity;

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

}
