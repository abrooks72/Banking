package com.cognixia.jump.menu;

import java.util.Scanner;

import loginApp.Login;

public class CreateLogin {
	
	Scanner scan = new Scanner(System.in);
	public static Login loginClass = new Login();
	public static Menu defaultMenu = new Menu();
	private static String createUser;
	private static String createPass;
	
	public CreateLogin() {
		
	}
	
	public CreateLogin(String username, String password) {
		super();
		this.createUser = username;
		this.createPass = password;
		
	}

	public static String getCreateUser() {
		return createUser;
	}

	public static void setCreateUser(String createUser) {
		CreateLogin.createUser = createUser;
	}

	public static String getCreatePass() {
		return createPass;
	}

	public static void setCreatePass(String createPass) {
		CreateLogin.createPass = createPass;
	}
	
	public void loginMenuDisplay() {
		String username = "";
		String password = "";
		
		System.out.println("What is your desired username?");
		username = scan.next();
		boolean success = loginClass.usernameCheck(username);
		
		
		if(loginClass.usernameCheck(username)) {
			System.out.println("User exists");
		}
		else {
			
		}
	}
	
	
}
