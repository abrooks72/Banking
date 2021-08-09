package com.cognixia.jump.login;

import java.util.*;

public class Login {
	
	public HashMap<String, String> accounts = new HashMap<String, String>();
	public static HashMap<String, Integer> userFunds = new HashMap<String, Integer>();
	
	// Create a HashMap object called capitalCities
	public boolean hasAccount(String hasAccount) {
		if(hasAccount.equals("yes")) {
			return true;
		}
		return false;
	}
    
    public void newAccount(String username, String password) {
    	accounts.put(username, password);
    }
    
    public void newFund(String username) {
    	userFunds.put(username, 0);
    }
    
	public boolean usernameCheck(String username) {
		
		
		if(accounts.containsKey(username)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyAccount(String username, String password) {
		
		
		if(accounts.containsKey(username) && accounts.get(username).equals(password)) {
			return true;
			
		}
		else {
			System.out.println("Invalid Login Credentials");
			return false;
		}
		
		
	}
	
	public String allUsers() {
		return accounts.toString();
	}
	
	
	
	
}
