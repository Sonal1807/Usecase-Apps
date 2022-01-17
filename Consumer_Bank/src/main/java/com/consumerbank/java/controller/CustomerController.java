
package com.consumerbank.java.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.consumerbank.java.Dto.CustomerRequestDto;
import com.consumerbank.java.Dto.CustomerResponseDto;
import com.consumerbank.java.Dto.CustomerResponseMap;
import com.consumerbank.java.service.CustomerService;

@RestController
@Validated
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PostMapping("/customers")
	public ResponseEntity<String> saveCustomer(@Valid @RequestBody CustomerRequestDto customerRequestDto) {
		String response = customerService.saveCustomer(customerRequestDto);
		return new ResponseEntity<String>(response, HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerResponseDto>> getCustomers() {
		return new ResponseEntity<List<CustomerResponseDto>>(customerService.getCustomers(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/customers/{customerName}")
	public ResponseEntity<List<CustomerResponseMap>> getCustomerByName(@PathVariable String customerName) {
		return new ResponseEntity<List<CustomerResponseMap>>(customerService.getCustomerbyName(customerName),
				HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/customers/customerId")
	public ResponseEntity<String> deleteCustomer(
			@NotNull(message = "customerId cannot be null;") @RequestParam Integer customerId) {
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("customer deleted succesfully", HttpStatus.ACCEPTED);
	}

	/*
	 * @PutMapping(value = "/updateCustomerDetails/{customerId}") public String
	 * updateCustomerDetails(@RequestBody CustomerRequestDto customerRequestDto,
	 * 
	 * @PathVariable Integer customerId) {
	 * 
	 * customerService.updateCustomerDetails(customerRequestDto, customerId); return
	 * "customer Details Updated Successfully"; }
	 */
}
