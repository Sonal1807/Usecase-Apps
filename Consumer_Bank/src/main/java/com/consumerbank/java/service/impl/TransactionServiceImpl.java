package com.consumerbank.java.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.consumerbank.java.Dto.TransactionRequestDto;
import com.consumerbank.java.Dto.TransactionResponseDto;
import com.consumerbank.java.entity.Account;
import com.consumerbank.java.entity.Transaction;
import com.consumerbank.java.exception.CustomException;
import com.consumerbank.java.repository.AccountRepository;
import com.consumerbank.java.repository.TransactionRepository;
import com.consumerbank.java.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {
	@Autowired
	TransactionRepository transactionRepository;
	@Autowired
	AccountRepository accountRepository;

	@Override
	@Transactional
	public List<TransactionResponseDto> saveTransactions(TransactionRequestDto transactionRequestDto) {
		Optional<Account> optionalAccount = accountRepository.findById(transactionRequestDto.getAccountId());
		if (!optionalAccount.isPresent())
			throw new CustomException("Account doesn't exist for the id " + transactionRequestDto.getAccountId());
		Transaction transaction = new Transaction();
		transaction.setDate(LocalDate.now());
		transaction.setAccountId(transactionRequestDto.getAccountId());
		BeanUtils.copyProperties(transactionRequestDto, transaction);
		transaction = transactionRepository.save(transaction);

		TransactionResponseDto responseDto = new TransactionResponseDto();
		BeanUtils.copyProperties(transaction, responseDto);
		List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<TransactionResponseDto>();
		transactionResponseDtoList.add(responseDto);
		return transactionResponseDtoList;

	}

	@Override
	public List<TransactionResponseDto> getAllTransactions() {
		List<TransactionResponseDto> transactionResponseDtoList = new ArrayList<TransactionResponseDto>();
		Iterator<Transaction> it = transactionRepository.findAll().iterator();
		while (it.hasNext()) {
			TransactionResponseDto transactionResponseDto = new TransactionResponseDto();
			BeanUtils.copyProperties(it.next(), transactionResponseDto);
			transactionResponseDtoList.add(transactionResponseDto);
		}
		return transactionResponseDtoList;

	}

}
