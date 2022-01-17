package com.foodbank.java.Dto;

import java.time.LocalDate;

public class OrderDetailResponseDto {
	private Integer orderId;
	private Integer quantity;
	private Double totalPrice;
	private LocalDate date;
	private Long orderNumber;
	private Integer userId;

	public OrderDetailResponseDto(Integer orderId, Integer quantity, Double totalPrice, LocalDate date,
			Long orderNumber, Integer userId) {
		super();
		this.orderId = orderId;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.date = date;
		this.orderNumber = orderNumber;
		this.userId = userId;
	}

	public OrderDetailResponseDto() {

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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(Long orderNumber) {
		this.orderNumber = orderNumber;
	}

}
