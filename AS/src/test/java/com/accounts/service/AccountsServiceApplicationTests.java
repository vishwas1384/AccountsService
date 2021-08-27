package com.accounts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.accounts.service.dto.AccountDetailsDto;
import com.accounts.service.dto.AccountTransactionDetailsDto;
import com.accounts.service.repository.AccountsListRepository;
import com.accounts.service.repository.AccountsTransactionRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
@EnableAutoConfiguration(exclude = { SecurityAutoConfiguration.class, DataSourceAutoConfiguration.class,
		DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class })
class AccountsServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	AccountsListRepository accountsListRepository;

	@MockBean
	AccountsTransactionRepository accountsTransactionRepository;

	@Autowired
	ObjectMapper objMapper;

	/**
	 * Test success scenario
	 * 
	 * @throws Exception
	 */
	@Test
	void testAccountsListEnquiry() throws Exception {

		AccountDetailsDto accountDetailsDto = new AccountDetailsDto(1, 1, "Test", "Savings", new Date(), "INR", 50.0f);
		List<Object> accountDetailsDtoList = new ArrayList<>();
		accountDetailsDtoList.add(accountDetailsDto);

		Mockito.when(accountsListRepository.findByUserId(Mockito.any(), Mockito.any()))
				.thenReturn(accountDetailsDtoList);
		String response = mockMvc
				.perform(post("/accountListEnquiry").contentType(MediaType.APPLICATION_JSON).content("123"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		List<AccountDetailsDto> accountDetailsDtoRespList = objMapper.readValue(response,
				new TypeReference<List<AccountDetailsDto>>() {
				});
		assertNotNull(accountDetailsDtoRespList);
		assertEquals("Test", accountDetailsDtoRespList.get(0).getAccountName());
	}

	/**
	 * Test success scenario
	 * 
	 * @throws Exception
	 */
	@Test
	void testAccountsTransactionsEnquiry() throws Exception {

		AccountTransactionDetailsDto accountTransactionDetailsDto = new AccountTransactionDetailsDto(1, 1, "Test",
				new Date(), "INR", 0.0f, 50.0f, "", "");
		List<Object> accountTransactionDetailsDtoList = new ArrayList<>();
		accountTransactionDetailsDtoList.add(accountTransactionDetailsDto);

		Mockito.when(accountsTransactionRepository.findByAccountNumber(Mockito.any(), Mockito.any()))
				.thenReturn(accountTransactionDetailsDtoList);
		String response = mockMvc
				.perform(post("/accountsTransactionEnquiry").contentType(MediaType.APPLICATION_JSON).content("123"))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		List<AccountTransactionDetailsDto> accountDetailsDtoRespList = objMapper.readValue(response,
				new TypeReference<List<AccountTransactionDetailsDto>>() {
				});
		assertNotNull(accountDetailsDtoRespList);
		assertEquals("Test", accountDetailsDtoRespList.get(0).getAccountName());
	}

}
