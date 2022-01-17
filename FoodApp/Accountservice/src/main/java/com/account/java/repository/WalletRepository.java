package com.account.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.java.entity.EWallet;

@Repository
public interface WalletRepository extends JpaRepository<EWallet, Integer> {

	EWallet findByUserId(Integer userId);

}
