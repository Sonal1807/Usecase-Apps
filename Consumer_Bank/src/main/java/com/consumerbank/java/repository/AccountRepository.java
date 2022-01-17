package com.consumerbank.java.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.consumerbank.java.Dto.AccountResponseMap;
import com.consumerbank.java.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	List<AccountResponseMap> findAccountByCustomerId(Integer customerId);

}