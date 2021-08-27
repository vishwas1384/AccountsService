package com.accounts.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "AccountTransactionDetails")
@Getter
@Setter
public class AccountTransactionDetails {

	@Id
	private int transactionId;
	@Column
	private int accountNumber;
	@Column
	private String accountName;
	@Column
	private Date valueDate;
	@Column
	private String currency;
	@Column
	private float debitAmount;
	@Column
	private float creditAmount;
	@Column
	private String transactionType;
	@Column
	private String transactionNarrative;

}
