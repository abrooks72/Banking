package com.cognixia.jump.login;

import java.util.*;

public class Login {
	
	public HashMap<String, String> accounts = new HashMap<String, String>();
	public static HashMap<String, Integer> userFunds = new HashMap<String, Integer>();
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	
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
	
	public boolean passwordCheck(String password) {
		int upperCount = 0;
		int numberCount = 0;
		int length = password.length();
		
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i)) && upperCount < 1) {
				upperCount++;
			}
			else if(Character.isDigit(password.charAt(i)) && numberCount < 2) {
				numberCount++;
			}
			
		}
		
		if(upperCount == 1 && numberCount == 2 && password.length() > 7) {
			System.out.println(ANSI_GREEN + "Good password");
			return true;
		}
		else {
			System.out.println(ANSI_RED + "Password does not contain at least 2 numbers or 1 upper case letter, or does not meet the length requirment");
			return false;
		}
		
	}
	
	
	
	
}
