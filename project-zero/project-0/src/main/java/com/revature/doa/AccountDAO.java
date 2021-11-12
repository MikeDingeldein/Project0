package com.revature.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Account;
import com.revature.util.JDBCUtility;

public class AccountDAO {

	
	public void deleteAllAccountsByClientId(int clientId) throws SQLException {
		try (Connection con = JDBCUtility.getConnection()) {
			String sql = "DELETE FROM accounts WHERE client_id = ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, clientId);
			
			pstmt.executeUpdate();
		}
	}	
//		public void deleteAccountById(int aid) throws SQLException {
//			try (Connection con = JDBCUtility.getConnection()) {
//				String sql = "Delete FROM accounts WHERE account_id = ?";
//				
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setInt(1, aid);
//				pstmt.executeUpdate();
//			}
//		}
	
	public List<Account> getAllAccountsByClientId(int clientId, int greaterThan, int lessThan) throws SQLException {
		List<Account> account = new ArrayList<>();
		
		try (Connection con = JDBCUtility.getConnection()) {
			String sql = "SELECT * FROM accounts WHERE client_id = ? AND account_balance >= ? and account_balance <= ?";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, clientId);
			pstmt.setInt(2, greaterThan);
			pstmt.setInt(3, lessThan);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int aid = rs.getInt("account_id");
				int id = rs.getInt("client_id");
				String accountType = rs.getString("account_type");
				double accountBalance = rs.getInt("account_balance");
//				String clientFirstName = rs.getString("clientFirstName");
//				String clientLastName = rs.getString("clientLastName");
				
				Account a = new Account(id, aid, accountType, accountBalance); //
//				Account a = new Account(id, aid, accountType, accountBalance, clientFirstName, clientLastName);
				account.add(a);
			}
			
			
		}
		
		return account;
		
	}
	
}
