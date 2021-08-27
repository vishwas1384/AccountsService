package com.accounts.service.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "AccountDetails")
@Getter
@Setter
public class AccountDetails {

	@Id
	private Integer accountNumber;
	@Column
	private Integer userId;
	@Column
	private String accountName;
	@Column
	private String accountType;
	@Column
	private Date balanceDate;
	@Column
	private String currency;
	@Column
	private float openingAvailableBalance;

}
