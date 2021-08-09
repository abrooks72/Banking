package com.cognixia.jump.driver;

import java.util.HashMap;

import com.cognixia.jump.menu.Menu;

import loginApp.Login;



public class Driver {
	
	public static Menu myMenu = new Menu();
	public static Login login = new Login();
	
	
	public static final String RESET = "\033[0m";  // Text Reset
	public static final String RED = "\033[0;31m";     // RED
	public static HashMap<String, String> accounts = new HashMap<String, String>();
	public static HashMap<String, Integer> userFunds = new HashMap<String, Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//myMenu.currentMenu(0);
		
		//accounts = login.accounts;
		//System.out.println(accounts);
		
		accounts = login.accounts;
		userFunds = login.userFunds;
		
		System.out.println("WELCOME TO THE MAIN MENU");
		myMenu.currentMenu(0);
		
		userFunds = login.userFunds;
		
	}

}
