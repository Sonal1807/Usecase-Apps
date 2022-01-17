
package com.orderservice.java.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.orderservice.java.dto.OrderRequestDto;

//@FeignClient(name = "orderclient", url = "http://localhost:9092")

@FeignClient("ORDERSERVICE")
public interface OrderClient {

	@PostMapping("/orders")
	public ResponseEntity<String> saveOrderDetails(@RequestBody OrderRequestDto requestDto);
}
