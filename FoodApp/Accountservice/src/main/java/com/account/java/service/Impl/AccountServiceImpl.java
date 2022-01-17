package com.account.java.service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.java.dto.AccountRequestDTO;
import com.account.java.entity.EWallet;
import com.account.java.entity.Transaction;
import com.account.java.repository.TransactionRepository;
import com.account.java.repository.WalletRepository;
import com.account.java.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	WalletRepository walletRepository;
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public String saveTransaction(AccountRequestDTO dto) {
		EWallet eWallet = new EWallet();
		eWallet = walletRepository.findByUserId(dto.getUserId());
		if (eWallet.getBalance() > dto.getAmount()) {
			Transaction transaction = new Transaction();
			transaction.setAmount(dto.getAmount());
			transaction.setDate(LocalDateTime.now());
			transaction.setTime(LocalDateTime.now());
			transaction.setOrderId(dto.getOrderId());
			transaction.setUserId(dto.getUserId());
			transactionRepository.save(transaction);
			eWallet.setUserId(dto.getUserId());
			eWallet.setWalletId(eWallet.getWalletId());
			eWallet.getBalance();
			eWallet.setBalance(eWallet.getBalance() - dto.getAmount());
			walletRepository.save(eWallet);
			return "Transaction Succesfull";
		} else {
			return "Transaction UnSuccesfull";
		}
	}

}
