package com.foodbank.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.foodbank.java.Dto.OrderDetailResponseDto;
import com.foodbank.java.Dto.OrderDetailsResponseMap;
import com.foodbank.java.entity.OrderDetail;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail, Integer> {

	List<OrderDetailsResponseMap> findByUserUserIdLike(Integer userId);

	@Query(value = "Select new com.foodbank.java.Dto.OrderDetailResponseDto(o.orderId,o.quantity,o.totalPrice,o.date,o.orderNumber,o.user.userId) from OrderDetail o")
	List<OrderDetailResponseDto> findAllOrders();

}
