
package com.consumerbank.java.Dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AccountRequestDto {

	@NotNull(message = "account number cannot be empty")
	private Long accountNumber;
	@NotNull(message = "balance cannot be empty")
	@Min(value = 2000, message = "min balance:2000")
	private Double balance;
	@NotEmpty(message = "account type cannot be empty")
	private String accountType;
	@NotNull(message = "customer id cannot be empty")
	private Integer customerId;

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
