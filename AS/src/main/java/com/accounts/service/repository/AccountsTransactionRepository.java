package com.accounts.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.service.model.AccountTransactionDetails;

@Repository
public interface AccountsTransactionRepository extends CrudRepository<AccountTransactionDetails, Integer> {

	<T> List<T> findByAccountNumber(Integer accountNumber, Class<T> type);

}
