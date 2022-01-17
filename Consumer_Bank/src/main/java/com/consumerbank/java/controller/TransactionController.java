package com.consumerbank.java.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.consumerbank.java.Dto.TransactionRequestDto;
import com.consumerbank.java.Dto.TransactionResponseDto;
import com.consumerbank.java.service.TransactionService;

@RestController
public class TransactionController {
	@Autowired
	TransactionService transactionService;

	@PostMapping("/transactions")
	public ResponseEntity<List<TransactionResponseDto>> saveTransactions(
			@Valid @RequestBody TransactionRequestDto transactionRequestDto) {
		return new ResponseEntity<List<TransactionResponseDto>>(
				transactionService.saveTransactions(transactionRequestDto), HttpStatus.ACCEPTED);
	}

	@GetMapping("/transactions")
	public ResponseEntity<List<TransactionResponseDto>> getTransactions() {
		return new ResponseEntity<List<TransactionResponseDto>>(transactionService.getAllTransactions(),
				HttpStatus.ACCEPTED);

	}

}
