package com.account.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.java.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
