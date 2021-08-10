package com.cognixia.jump.menu;

import java.util.HashMap;
import java.util.Scanner;

import com.cognixia.jump.driver.Driver;
import com.cognixia.jump.login.Login;


public class Menu {
	
	Scanner scan = new Scanner(System.in);
	public static Login loginClass = new Login();
	public static HashMap<String, Integer> userFunds = new HashMap<String, Integer>();
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
	public static final String ANSI_RESET = "\u001B[0m";
	
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	
	public Menu() {
		
	}
	
	public void currentMenu(int choice) {
		String display = "";
		String newLine = System.getProperty("line.separator");
		String newAccount = ANSI_YELLOW + "1: Create New Account";
		String login = ANSI_YELLOW + "2: Login";
		String exit = ANSI_YELLOW + "3: Close Browser";
		
		int menuOption = -1;
		
		
		
		if(choice == 0) {									// 0 represents the main menu
			System.out.println(ANSI_BLACK + "Main Menu");
			display = newAccount + newLine + login + newLine + exit;
			System.out.println(display);
			System.out.print("Which option would you like to choose: ");
			choice = scan.nextInt();
			menuOption = 0;
			System.out.println(ANSI_RESET + "================");
		}
		if(choice == 1) {									// 1 represents the create new account menu
			System.out.println(ANSI_CYAN + "Create a New Account");
			System.out.println("Enter the username of the account that you would like to create: ");
			String name = scan.next();
			boolean checkName = loginClass.usernameCheck(name);
			if(checkName != true) {							// Check if account user name is taken
				System.out.println("User does not exist");
				System.out.println("Enter the password of the account that you would like to create: ");
				String password = scan.next();
				System.out.println("Creating account...");
				System.out.println("Please sign in to your new account.");
				System.out.println(ANSI_RESET + "=============");
				loginClass.newAccount(name, password);
				loginClass.newFund(name);
				Driver.accounts.put(name, password);
				
				currentMenu(2);
			}
			else {
				System.out.println(ANSI_RED + "***User already exists, please pick a new name***");
				System.out.println(ANSI_RESET + "=============");
				currentMenu(1);
			}
			System.out.println(ANSI_RESET + "===============");
		}
		else if(choice == 2) {								// Check login credentials
			System.out.println(ANSI_PURPLE + "Login to Your Account");
			System.out.println(ANSI_PURPLE + "What is your username:");
			String user = scan.next();
			System.out.println("Enter your password:" + ANSI_BLACK);
			String password = scan.next();
			
			
			boolean success = loginClass.verifyAccount(user, password);
			
			if(success == true) {
				System.out.println(ANSI_GREEN + "Login Success");
				System.out.println("Current Balance: " + Driver.userFunds.get(user) + "$");
				System.out.println(ANSI_RESET + "=================");
				
				
				UserMenu userMenu = new UserMenu(user, password);
				userMenu.userMenuDisplay();
			}
			else {
				System.out.println(ANSI_RED + "Login failure, returning to main menu");
				System.out.println(ANSI_RESET + "==============");
				currentMenu(0);
			}
			
		}
		else if(choice == 3) {								// Close the browser
			System.out.println("Thanks for using this application.");
			menuOption = 3;
			return;
		}
		
		
		scan.close();
		
	}
}
