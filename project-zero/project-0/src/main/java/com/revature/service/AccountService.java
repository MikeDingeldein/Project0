package com.revature.service;

import java.security.InvalidParameterException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.doa.AccountDAO;
import com.revature.doa.BankDOA;
import com.revature.dto.AddOrUpdateAccountDTO;
import com.revature.dto.AddOrUpdateClientDTO;
import com.revature.exceptions.ClientNotFound;
import com.revature.model.Account;
import com.revature.model.Client;

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

	// get account by Id and client id
	public List<Account> getAccountByClientIdAndAcountId(String clientId, String accountId)
			throws SQLException, InvalidParameterException, ClientNotFound {
		// Convert from String to int

//		List<Account> a1 = new ArrayList<>();

		try {
			int id = Integer.parseInt(clientId);
			Client c = this.bankDao.getClientById(id);
			int aid = Integer.parseInt(accountId);
			List<Account> a = this.accountDao.getAccountByClientIdAndAcountId(id, aid);
			if (c == null) {
				throw new SQLException("Client with id of " + clientId + " was not found.");
			}
			if (a == null) {
				throw new SQLException("Account with id of " + accountId + " was not found.");
			}
			return a;
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("Id provided is not an int convertable value");
		}
	}

	public Account editAccountByClientIdAndAcountId(String clientId, String accountId, String changedAccountType, double changedAccountBalacne) 
			throws SQLException, InvalidParameterException, ClientNotFound {
		// Convert from String to int
		try {
			int id = Integer.parseInt(clientId);
			Client c = this.bankDao.getClientById(id);
			int aid = Integer.parseInt(accountId);
			List<Account> a = this.accountDao.getAccountByClientIdAndAcountId(id, aid);
			if (c == null) {
				throw new SQLException("Client with id of " + clientId + " was not found.");
			}

			if (a == null) {
				throw new SQLException("Account with id of " + accountId + " was not found.");
			}
			//
			AddOrUpdateAccountDTO dto = new AddOrUpdateAccountDTO(id, changedAccountType, changedAccountBalacne);
			Account updatedAccount = this.accountDao.updatedAccount(id, aid, dto);

			if (dto.getAccountType().trim().equals("") || dto.getAccountBalance() < 0) {
				throw new InvalidParameterException("Account Type or Account Balance can not be blank");
			}
			dto.setAccountType(dto.getAccountType().trim());
			dto.setAccountBalance(dto.getAccountBalance());

			return updatedAccount;
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("Id provided is not an int convertable value");
		}
	}

	// delete account with Id
	public void deleteAcountByClientIdAndAcountId(String clientId, String accountId) throws SQLException, InvalidParameterException, ClientNotFound {
		try {
//			int id = Integer.parseInt(accountId);
//			Account a = this.accountDao.getAccountByClientIdAndAcountId(id);
//			if (a == null) {
//				throw new SQLException("Account with id of " + accountId + " was not found.");
//			}
			int id = Integer.parseInt(clientId);
			Client c = this.bankDao.getClientById(id);
			int aid = Integer.parseInt(accountId);
			List<Account> a = this.accountDao.getAccountByClientIdAndAcountId(id, aid);
			if (c == null) {
				throw new SQLException("Client with id of " + clientId + " was not found.");
			}
			if (a == null) {
				throw new SQLException("Account with id of " + accountId + " was not found.");
			}
			// delete all accounts for the client
			//this.accountDao.deleteAllAccountsByClientId(id);
			// delete the client
			this.accountDao.deleteAcountByClientIdAndAcountId(aid);
		} catch (NumberFormatException e) {
			throw new InvalidParameterException("Id provided is not an int convertable value.");
		}

	}
	
//	// delete client with Id
//	public void deleteClientById(String clientId) throws SQLException, InvalidParameterException, ClientNotFound {
//		try {
//			int id = Integer.parseInt(clientId);
//			Client c = this.bankDao.getClientById(id);
//			if (c == null) {
//				throw new SQLException("Client with id of " + clientId + " was not found.");
//			}
//			// delete all accounts for the client
//			this.accountDao.deleteAllAccountsByClientId(id);
//			// delete the client
//			this.bankDao.deleteClientById(id);
//		} catch (NumberFormatException e) {
//			throw new InvalidParameterException("Id provided is not an int convertable value.");
//		}
//
//	}
	
//	// edit client by Id
//	// , String firstName, String lastName
//	public Client editClientById(String clientId, String changedFirstName, String changedLastName)
//			throws SQLException, InvalidParameterException, ClientNotFound {
//		try {
//			int id = Integer.parseInt(clientId);
//			Client clientToEdit = this.bankDao.getClientById(id);
//			if (clientToEdit == null) {
//				throw new SQLException("Client with id of " + clientId + " was not found.");
//			}
//
//			AddOrUpdateClientDTO dto = new AddOrUpdateClientDTO(changedFirstName, changedLastName);
//			Client updatedClient = this.bankDao.updatedClient(id, dto);
//
//			if (dto.getFirstName().trim().equals("") || dto.getLastName().trim().equals("")) {
//				throw new InvalidParameterException("First name or last name can not be blank");
//			}
//			dto.setFirstName(dto.getFirstName().trim());
//			dto.setLastName(dto.getLastName().trim());
//
//			return updatedClient;
//		} catch (NumberFormatException e) {
//			throw new InvalidParameterException("Id provided is not an int convertable value.");
//		}
//	}
}
