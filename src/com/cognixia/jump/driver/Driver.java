package com.cognixia.jump.driver;

import java.util.HashMap;

import com.cognixia.jump.menu.Menu;

import loginApp.Login;

public class Driver {
	
	public static Menu myMenu = new Menu();
	public static Login login = new Login();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//myMenu.currentMenu(0);
		HashMap<String, String> accounts = new HashMap<String, String>();
		accounts = login.createAccounts();
		
		
		System.out.println("WELCOME TO THE MAIN MENU");
		myMenu.currentMenu(0);
		
	}

}
