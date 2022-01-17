
package com.consumerbank.java.service;

import java.util.List;
import com.consumerbank.java.Dto.AccountRequestDto;
import com.consumerbank.java.Dto.AccountResponseDto;
import com.consumerbank.java.Dto.AccountResponseMap;

public interface AccountService {
	void saveAccount(AccountRequestDto accountRequestDto);

	List<AccountResponseDto> getAccounts();

	List<AccountResponseMap> getAccountsByCustomerId(Integer customerId);

}
