package com.cognixia.jump.menu;

import java.util.Scanner;

import loginApp.Login;


public class Menu {
	
	Scanner scan = new Scanner(System.in);
	public static Login loginClass = new Login();
	
	public Menu() {
		
	}
	
	public void currentMenu(int choice) {
		String display = "";
		String newLine = System.getProperty("line.separator");
		String newAccount = "1: Create New Account";
		String login = "2: Login";
		String exit = "3: Exit.";
		String back = "4: Back";
		
		int menuOption = -1;
		
		
		
		if(choice == 0) {				// 0 represents the main menu
			System.out.println("Main Menu");
			display = newAccount + newLine + login + newLine + exit + newLine + back;
			System.out.println(display);
			System.out.print("Which option would you like to choose: ");
			choice = scan.nextInt();
			menuOption = 0;
			System.out.println("================");
		}
		if(choice == 1) {			// 1 represents the create new account menu
			System.out.println("Create a New Account");
			display =  login + newLine + exit + newLine + back;
			System.out.println(display);
			System.out.print("Which option would you like to choose: ");
			// Make a call to new account class
			choice = scan.nextInt();
			menuOption = 1;
			System.out.println("===============");
		}
		else if(choice == 2) {			// Login option
			System.out.println("Login to Your Account");
			display = newAccount + newLine + exit + newLine + back;
			System.out.println(display);
			System.out.print("Which option would you like to choose: ");
			choice = scan.nextInt();
			menuOption = 2;
			// Make a call to login class
			System.out.println("===============");
			if(!loginClass.verifyAccount("abrooks72", "brazodious")) {					// Trouble
				System.out.println("Invalid username/password combination");
				currentMenu(0);
			}
		}
		else if(choice == 3) {			// 3 represents the exit menu
			System.out.println("Thanks for using this application.");
			menuOption = 3;
			return;
		}
		else if(choice == 4) {
			System.out.println("Main Menu");
			display = newAccount + newLine + login + newLine + exit;
			System.out.println(display);
			System.out.print("Which option would you like to choose: ");
			choice = scan.nextInt();
			menuOption = 4;
			System.out.println("================");
		}
		
		
	
		currentMenu(choice);
		
		scan.close();
		
	}
}
