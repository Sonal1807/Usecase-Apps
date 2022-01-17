
package com.consumerbank.java.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TransactionRequestDto {

	@NotNull(message = " AccountId cannot be null")
	private Integer accountId;
	@NotNull(message = "Amount cannot be null")
	@Min(value = 100, message = " Amount should not be less than 100")
	private Double amount;
	@NotEmpty(message = "Transaction number cannot be empty")
	private String transactionNumber;
	private String transactionType;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

}
