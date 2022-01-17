package com.orderservice.java.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.orderservice.java.dto.OrderResponseDto;
import com.orderservice.java.entity.OrderDetails;

@Repository
public interface OrderRepo extends JpaRepository<OrderDetails, Integer> {
	@Query(value = "Select new com.orderservice.java.dto.OrderResponseDto(o.orderId,o.userId,o.foodId,o.quantity,o.Time,o.Date) from OrderDetails o")
	List<OrderResponseDto> findAllOrders();
}
