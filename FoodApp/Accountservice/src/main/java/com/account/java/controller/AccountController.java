package com.account.java.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.account.java.dto.AccountRequestDTO;
import com.account.java.service.AccountService;
@Validated
@RestController
public class AccountController {

	@Autowired
	AccountService accountService;

	@PostMapping("/transactions")
	public ResponseEntity<String> saveTransaction(@Valid @RequestBody AccountRequestDTO dto) {
		return new ResponseEntity<String>(accountService.saveTransaction(dto), HttpStatus.OK);
	}
}
