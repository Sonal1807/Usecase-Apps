package com.account.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EWallet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eWalletId;
	private Integer userId;
	private float balance;

	public Integer getWalletId() {
		return eWalletId;
	}

	public void setWalletId(Integer eWalletId) {
		this.eWalletId = eWalletId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

}
