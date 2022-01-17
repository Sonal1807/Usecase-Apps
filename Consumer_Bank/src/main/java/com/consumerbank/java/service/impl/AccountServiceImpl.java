package com.consumerbank.java.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consumerbank.java.Dto.AccountRequestDto;
import com.consumerbank.java.Dto.AccountResponseDto;
import com.consumerbank.java.Dto.AccountResponseMap;
import com.consumerbank.java.entity.Account;
import com.consumerbank.java.entity.Customer;
import com.consumerbank.java.exception.CustomException;
import com.consumerbank.java.repository.AccountRepository;
import com.consumerbank.java.repository.CustomerRepository;
import com.consumerbank.java.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void saveAccount(AccountRequestDto accountRequestDto) {
		Optional<Customer> opCustomer = customerRepository.findById(accountRequestDto.getCustomerId());
		if (opCustomer.isPresent()) {
			Customer customer = opCustomer.get();
			Account account = new Account();
			BeanUtils.copyProperties(accountRequestDto, account);
			account.setCustomer(customer);
			accountRepository.save(account);
		} else {
			throw new CustomException("Customer not found with given customerId ");
		}

	}

	@Override
	public List<AccountResponseDto> getAccounts() {
		List<AccountResponseDto> accountResponseDtoList = new ArrayList<AccountResponseDto>();
		Iterator<Account> itr = accountRepository.findAll().iterator();
		while (itr.hasNext()) {
			AccountResponseDto accountResponseDto = new AccountResponseDto();
			BeanUtils.copyProperties(itr.next(), accountResponseDto);
			accountResponseDtoList.add(accountResponseDto);
		}
		return accountResponseDtoList;
	}

	@Override
	public List<AccountResponseMap> getAccountsByCustomerId(Integer customerId) {
		if (!customerRepository.findById(customerId).isPresent())
			throw new CustomException(" Customer not found with customerId: " + customerId);
		List<AccountResponseMap> accountResponse = accountRepository.findAccountByCustomerId(customerId);
		if (accountResponse.isEmpty())
			throw new CustomException("Account not found related to customerId: " + customerId);
		return accountResponse;
	}

}
