package com.consumerbank.java.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.consumerbank.java.Dto.CustomerResponseMap;
import com.consumerbank.java.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
	List<CustomerResponseMap> findByCustomerNameContaining(String customerName);
	// Customer updateCustomerDetails(CustomerRequestDto customerRequestDto, Integer
	// customerId);
}