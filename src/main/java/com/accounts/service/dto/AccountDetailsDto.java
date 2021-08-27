package com.accounts.service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountDetailsDto {

	private Integer accountNumber;
	private Integer userId;
	private String accountName;
	private String accountType;
	private Date balanceDate;
	private String currency;
	private Float openingAvailableBalance;

}
