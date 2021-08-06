package com.cognixia.jump.account;

public class Account {
	
	private static String username;
	private String password;
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
	}
	
	public static String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
