package com.accounts.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accounts.service.dto.AccountDetailsDto;
import com.accounts.service.dto.AccountTransactionDetailsDto;
import com.accounts.service.repository.AccountsListRepository;
import com.accounts.service.repository.AccountsTransactionRepository;

/**
 * Service class
 * 
 * @author
 *
 */
@Service
public class AccountsService {

	@Autowired
	AccountsListRepository accountsListRepository;

	@Autowired
	AccountsTransactionRepository accountsTransactionRepository;

	/**
	 * Service class to get the account details of user
	 * 
	 * @param userid
	 * @return
	 */
	public List<AccountDetailsDto> getAccountDetails(Integer userid) {

		return accountsListRepository.findByUserId(userid, AccountDetailsDto.class);

	}

	/**
	 * Service class to get transaction details of accounts
	 * 
	 * @param accountNumber
	 * @return
	 */
	public List<AccountTransactionDetailsDto> getAccountTransactionDetails(Integer accountNumber) {

		return accountsTransactionRepository.findByAccountNumber(accountNumber, AccountTransactionDetailsDto.class);

	}

}
