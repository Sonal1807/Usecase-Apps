package com.consumerbank.java.Dto;

import org.springframework.beans.factory.annotation.Value;

public interface AccountResponseMap {

	Integer getAccountId();

	Long getAccountNumber();

	Double getBalance();

	String getAccountType();

	@Value("#{target.customer.customerId}")
	Integer getCustomerId();

}
