package com.accounts.service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accounts.service.model.AccountDetails;

@Repository
public interface AccountsListRepository extends CrudRepository<AccountDetails, Integer> {

	<T> List<T> findByUserId(Integer userId, Class<T> type);

}
