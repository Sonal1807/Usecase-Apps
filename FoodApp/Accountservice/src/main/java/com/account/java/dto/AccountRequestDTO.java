package com.account.java.dto;

import javax.validation.constraints.NotNull;

public class AccountRequestDTO {
	
	private float amount;
	@NotNull(message = "userId cannot be null")
	private Integer userId;
	@NotNull(message = "orderId cannot be null")
	private Integer orderId;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

}
