
package com.consumerbank.java.service;

import java.util.List;
import com.consumerbank.java.Dto.TransactionRequestDto;
import com.consumerbank.java.Dto.TransactionResponseDto;

public interface TransactionService {

	List<TransactionResponseDto> saveTransactions(TransactionRequestDto transactionRequestDto);

	List<TransactionResponseDto> getAllTransactions();

}
