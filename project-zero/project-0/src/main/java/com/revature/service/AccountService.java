package com.revature.service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.doa.AccountDAO;
import com.revature.doa.BankDOA;
import com.revature.exceptions.ClientNotFound;
import com.revature.model.Account;

import io.javalin.http.Context;

public class AccountService {

	private AccountDAO accountDao;
	private BankDOA bankDao;

	public AccountService() {
		this.accountDao = new AccountDAO();
		this.bankDao = new BankDOA();

	}

	// Add for Mockito here
	public AccountService(AccountDAO accountDao, BankDOA bankDao) {
		this.accountDao = accountDao;
		this.bankDao = bankDao;
	}

	public List<Account> getAllAccountsByClientId(String clientId, Context ctx)
			throws InvalidParameterException, ClientNotFound, SQLException {

		List<Account> accounts = new ArrayList<>();
		
		int id = Integer.parseInt(clientId);

		if (ctx.queryParam("greaterThan") != null && ctx.queryParam("lessThan") != null) {
			int gt = Integer.parseInt(ctx.queryParam("greaterThan"));
			int lt = Integer.parseInt(ctx.queryParam("lessThan"));

			accounts = this.accountDao.getAllAccountsByClientId(id, gt, lt);
		
		} else if (ctx.queryParam("lessThan") != null) {

			int lessThan = Integer.parseInt(ctx.queryParam("lessThan"));

			accounts = this.accountDao.getAllAccountsByClientId(id, 0, lessThan);

		} else if (ctx.queryParam("greaterThan") != null) {
			int greaterThan = Integer.parseInt(ctx.queryParam("greaterThan"));

			accounts = this.accountDao.getAllAccountsByClientId(id, greaterThan, 400000000);
		} else {
			accounts = this.accountDao.getAllAccountsByClientId(id, 0, 400000000);
		}
		
		return accounts;
	}

	
	
	
}
