package com.accounts.service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AccountTransactionDetailsDto {

	private Integer transactionId;
	private Integer accountNumber;
	private String accountName;
	private Date valueDate;
	private String currency;
	private Float debitAmount;
	private Float creditAmount;
	private String transactionType;
	private String transactionNarrative;

}
