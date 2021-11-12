package com.revature.controller;

import java.util.List;

import com.revature.model.Account;
import com.revature.service.AccountService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class AccountController {

	private AccountService accountService;

	public AccountController() {
		this.accountService = new AccountService();

	}

	private Handler getAllAccountsByClientId = (ctx) -> {
		String clientId = ctx.pathParam("id");
		List<Account> account = this.accountService.getAllAccountsByClientId(clientId, ctx);
		ctx.json(account);

	};

//	private Handler getAllAccountsByClientId = (ctx) -> {
//		String id = ctx.pathParam("id");
//		String amountGreaterThan = ctx.queryParam("amountGreaterThan");
//		String amountLessThan = ctx.queryParam("amountLessThan");
//
//		// String aid = ctx.pathParam("aid");
//		List<Account> a = this.accountService.getAllAccountsByClientId(id, ctx);
//		ctx.json(a);
//	};

	public void registerEndPoints(Javalin app) {
		app.get("/clients/{id}/accounts", getAllAccountsByClientId);
//		app.get("/clients/{id}/accounts", getAllAccountsByClientId);
	}
}