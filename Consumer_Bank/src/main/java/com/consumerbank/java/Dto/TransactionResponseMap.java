
package com.consumerbank.java.Dto;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Value;

public interface TransactionResponseMap {
	String getTransactionNumber();

	Double getAmount();

	String getTransactionType();

	LocalDate getDate();

	@Value("#{target.account.accountId}")
	Integer getAccountId();

}