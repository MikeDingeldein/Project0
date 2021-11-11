package com.revature.model;

import java.util.Objects;

public class Account {

	private int clientId;
	private int clientId2;
	private int accountId;
	private String accountType;
	private String accountBalance;
	private String clientFirstName;
	private String clientLastName;

	public Account() {

	}

	public Account(int clientId, int accountId, String accountType, String accountBalance) {
		super();
		this.clientId = clientId;
		this.accountId = accountId;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
	}

	public Account(int clientId, String clientFirstName, String clientLastName, int accountId, int clientId2,
			String accountType, String accountBalance) {
		super();
		this.clientId = clientId;
		this.clientId2 = clientId2;
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

	public int getClientId2() {
		return clientId2;
	}

	public void setClientId2(int clientId2) {
		this.clientId2 = clientId2;
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

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
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
		return Objects.hash(accountBalance, accountId, accountType, clientFirstName, clientId, clientId2,
				clientLastName);
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
		return Objects.equals(accountBalance, other.accountBalance) && accountId == other.accountId
				&& Objects.equals(accountType, other.accountType)
				&& Objects.equals(clientFirstName, other.clientFirstName) && clientId == other.clientId
				&& clientId2 == other.clientId2 && Objects.equals(clientLastName, other.clientLastName);
	}

	@Override
	public String toString() {
		return "Account [clientId=" + clientId + ", clientId2=" + clientId2 + ", accountId=" + accountId
				+ ", accountType=" + accountType + ", accountBalance=" + accountBalance + ", clientFirstName="
				+ clientFirstName + ", clientLastName=" + clientLastName + "]";
	}

}
