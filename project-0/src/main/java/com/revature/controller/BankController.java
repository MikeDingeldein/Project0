package com.revature.controller;

import java.util.List;

//import java.util.logging.Handler;

import com.revature.dto.AddOrUpdateClientDTO;
import com.revature.model.Client;
import com.revature.service.BankService;

import io.javalin.Javalin;
import io.javalin.http.Handler;

public class BankController {

	private BankService bankService; // Create a HAS-A relationship

	public BankController() {
		this.bankService = new BankService();
		
	}

	public Handler addNewClient = (ctx) -> {
		AddOrUpdateClientDTO dto = ctx.bodyAsClass(AddOrUpdateClientDTO.class);

		Client s = this.bankService.addNewClient(dto);
		ctx.status(201);
		ctx.json(s);
		
	};

	private Handler getAllClients = (ctx) -> {
		List<Client> clients = this.bankService.getAllClients();

		ctx.json(clients);
	};

	private Handler getClientById = (ctx) -> {
		String id = ctx.pathParam("id");
		Client c = this.bankService.getClientById(id);
		ctx.json(c);
	};
//
//	private Handler editClientById = (ctx) -> {
//	};
//
//	private Handler deleteClientById = (ctx) -> {
//		String id = ctx.pathParam("id");
//		this.bankService.deleteClientById(id);
//	};
//	
//	private Handler createNewAccount = (ctx) -> {
//		AddAccountDTO dto = ctx.bodyAsClass(AddAccountDTO.class);
//
//		Account a = this.bankService.addAccount(dto);
//
//		ctx.json(a);
//		ctx.status(201);
//	};		
//	
//	private Handler getAccountByClientId = (ctx) -> {
//		String id = ctx.pathParam("id");
//		Account a = this.bankService.getAccountById(id);
//		ctx.json(a);
//	};
//	
//	private Handler getAccountByClientIdAndBalance = (ctx) -> {// very unsure
//		String id = ctx.pathParam("id");
//		Account a = this.bankService.getAccountById(id);
//		ctx.json(a);
//	};
//	
//	private Handler getAccountByClientIdAndAcountId = (ctx) -> {// very unsure
//		String id = ctx.pathParam("id");
//		String aid = ctx.pathParam("aid");
//		Account a = this.bankService.getAccountByClientIdAndAcountId(id, aid);
//		ctx.json(a);
//	};
//	
//	private Handler editAccountByClientIdAndAcountId = (ctx) -> {
//	};
//	
//	private Handler deleteAcountByClientIdAndAcountId = (ctx) -> {// very unsure
//		String id = ctx.pathParam("id");
//		String aid = ctx.pathParam("aid");
//		this.bankService.deleteAcountByClientIdAndAcountId(id, aid);
//	};
//	
	
	public void registerEndPoints(Javalin app) {
		app.post("/clients", addNewClient);
		app.get("/clients", getAllClients);
		app.get("/client/{id}", getClientById);
//		app.put("/clients/{id}", editClientById);
//		app.delete("/clients/{id}", deleteClientById);
//		app.post("/clients/{id}/accounts", createNewAccount);
//		app.get("/clients/{id}/accounts", getAccountByClientId);
//		app.get("/clients/{id}/accounts", getAccountByClientIdAndBalance);
//		app.get("/clients/{id}/accounts/{accountId}", getAccountByClientIdAndAcountId);
//		app.put("/clients/{id}/accounts/{accountId}", editAccountByClientIdAndAcountId);
//		app.delete("/clients/{id}/accounts/{accountId}", deleteAcountByClientIdAndAcountId);

	}
}
