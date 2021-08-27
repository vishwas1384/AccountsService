package com.accounts.service.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accounts.service.dto.AccountDetailsDto;
import com.accounts.service.dto.AccountTransactionDetailsDto;
import com.accounts.service.service.AccountsService;

@RestController
public class AccountsServiceController {

	@Autowired
	AccountsService accountsService;

	/**
	 * Account List Enquiry api to get Accounts for the user
	 * 
	 * @param userid
	 * @return List<AccountDetailsDto>
	 */
	@PostMapping("/accountListEnquiry")
	public List<AccountDetailsDto> accountsListEnquiry(@RequestBody Integer userid) {

		return accountsService.getAccountDetails(userid);
	}

	/**
	 * Transaction details enquiry api to get transaction details of Acount
	 * 
	 * @param accountNumber
	 * @return List<AccountTransactionDetailsDto>
	 */
	@PostMapping("/accountsTransactionEnquiry")
	public List<AccountTransactionDetailsDto> accountsTransactionEnquiry(@RequestBody Integer accountNumber) {

		return accountsService.getAccountTransactionDetails(accountNumber);
	}

}
