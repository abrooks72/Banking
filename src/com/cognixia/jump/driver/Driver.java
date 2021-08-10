package com.cognixia.jump.driver;

import java.util.HashMap;

import com.cognixia.jump.login.Login;
import com.cognixia.jump.menu.Menu;



public class Driver {
	
	public static Menu myMenu = new Menu();
	public static Login login = new Login();
	
	
	
	
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static HashMap<String, String> accounts = new HashMap<String, String>();
	public static HashMap<String, Integer> userFunds = new HashMap<String, Integer>();
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//myMenu.currentMenu(0);
		
		//accounts = login.accounts;
		//System.out.println(accounts);
		
		accounts = login.accounts;
		userFunds = login.userFunds;
		
		//System.out.println( ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset() );
		
		System.out.println(ANSI_WHITE + "WELCOME TO THE MAIN MENU" + ANSI_RESET);
		
		myMenu.currentMenu(0);
		
		userFunds = login.userFunds;
		
		
	}

}
