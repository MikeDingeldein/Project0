package com.revature.model;

import java.util.Objects;

public class Account {

	private int clientId;
//	private int clientId2;
	private int accountId;
	private String accountType;
	private double accountBalance;
	private String clientFirstName;
	private String clientLastName;

	public Account() {

	}

	public Account(int clientId, int accountId, String accountType, double accountBalance) {
		super();
		this.clientId = clientId;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}
	
//	public Account(int clientId, int accountId, String accountType, double accountBalance, String clientFirstName, String clientLastName) {
//		super();
//		this.clientId = clientId;
//		this.accountId = accountId;
//		this.accountType = accountType;
//		this.accountBalance = accountBalance;
//		this.clientFirstName = clientFirstName;
//		this.clientLastName = clientLastName;
//	}
	
	public Account(int accountId, double accountBalance) {
		super();
		
		this.accountId = accountId;
		
		this.accountBalance = accountBalance;
	}

	public Account(int clientId, String clientFirstName, String clientLastName, int accountId, 
			String accountType, double accountBalance) { //int clientId2,
		super();
		this.clientId = clientId;
//		this.clientId2 = clientId2;
		this.clientFirstName = clientFirstName;
		this.clientLastName = clientLastName;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getClientFirstName() {
		return clientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		this.clientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return clientLastName;
	}

	public void setClientLastName(String clientLastName) {
		this.clientLastName = clientLastName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountBalance, accountId, accountType, clientFirstName, clientId, clientLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Double.doubleToLongBits(accountBalance) == Double.doubleToLongBits(other.accountBalance)
				&& accountId == other.accountId && Objects.equals(accountType, other.accountType)
				&& Objects.equals(clientFirstName, other.clientFirstName) && clientId == other.clientId
				&& Objects.equals(clientLastName, other.clientLastName);
	}

	@Override
	public String toString() {
		return "Account [clientId=" + clientId + ", accountId=" + accountId + ", accountType=" + accountType
				+ ", accountBalance=" + accountBalance + ", clientFirstName=" + clientFirstName + ", clientLastName="
				+ clientLastName + "]";
	}


}
