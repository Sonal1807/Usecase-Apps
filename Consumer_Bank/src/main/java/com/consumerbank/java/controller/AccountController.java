
package com.consumerbank.java.controller;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.consumerbank.java.Dto.AccountRequestDto;
import com.consumerbank.java.Dto.AccountResponseDto;
import com.consumerbank.java.Dto.AccountResponseMap;
import com.consumerbank.java.service.AccountService;

@RestController
@Validated
public class AccountController {
	@Autowired
	AccountService accountService;

	@PostMapping("/accounts")
	public ResponseEntity<String> saveAccount(@Valid @RequestBody AccountRequestDto accountRequestDto) {
		accountService.saveAccount(accountRequestDto);
		return new ResponseEntity<String>("Account created succesfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/accounts")
	public ResponseEntity<List<AccountResponseDto>> getAccounts() {
		return new ResponseEntity<List<AccountResponseDto>>(accountService.getAccounts(), HttpStatus.ACCEPTED);
	}

	@GetMapping("/accounts/{customerId}")
	public ResponseEntity<List<AccountResponseMap>> getAccountsByCustomerId(
			@NotNull(message = "customerId cannot be null") @PathVariable Integer customerId) {
		return new ResponseEntity<List<AccountResponseMap>>(accountService.getAccountsByCustomerId(customerId),
				HttpStatus.ACCEPTED);
	}

}
