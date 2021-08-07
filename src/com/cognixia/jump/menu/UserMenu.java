package com.cognixia.jump.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.cognixia.jump.account.Account;

import loginApp.Login;

public class UserMenu {
	
	Scanner scan = new Scanner(System.in);
	public static Login loginClass = new Login();
	public static Menu defaultMenu = new Menu();
	public List<String> transactions = new ArrayList<String>();
	public static HashMap<String, Integer> userFundsMain = new HashMap<String, Integer>();
	public int money = 0;
	
	private static String username;
	private static String password;
	
	
	public UserMenu(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		
		addFunds();
	}
	
	

	public String getUsername() {
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


	public void addFunds() {
		userFundsMain.put("abrooks72", 10000);
		userFundsMain.put("pepekwan", 50000);
		userFundsMain.put("TylerThompson", 50000);
		userFundsMain.put("Rodger32", 10000);
		userFundsMain = Login.userFunds;
	}
	public void userMenuDisplay() {
		String display = "";
		String newLine = System.getProperty("line.separator");
		String deposit = "1: Deposit";
		String withdraw = "2: Withdraw";
		String transfer = "3: Transfer";
		String recents = "4: Recent Transactions";
		String info = "5: User Info";
		String exit = "6: Log out.";
		int choice = -1;
		
		display = deposit + newLine + withdraw + newLine + transfer + newLine + recents + newLine + info + newLine + exit;
		System.out.println(display);
		loginClass.createAccounts();
		
		System.out.println("What would you like to do?");
		choice = scan.nextInt();
		
		userMenuOption(choice);
	}
	
	public void userMenuOption(int choice) {
		int amount = 0;
		String username = this.getUsername();
		
		
		if(choice == 1) {																	//DEPOSIT
			System.out.println("================");
			System.out.println("You currently have: " + userFundsMain.get(username) + "$");
			System.out.println("How much would you like to deposit into your account:");
			
			amount = scan.nextInt();
			userFundsMain.replace(username, userFundsMain.get(username) + amount);
			
			System.out.println("You now have: " + userFundsMain.get(username) + "$");
			System.out.println("==================");
			transactions.add("Deposited: " + amount);
			userMenuDisplay();
		}
		else if(choice == 2) {																//WITHDRAW
			System.out.println("================");
			System.out.println("You currently have: " + userFundsMain.get(username) + "$");
			System.out.println("How much would you like to withdraw from your account:");
			amount = scan.nextInt();
			if(userFundsMain.get(username) < amount) {
				System.out.println("***Insufficient Funds***");
				System.out.println("================");
				userMenuDisplay();
			}
			else {
				userFundsMain.put(username, userFundsMain.get(username) - amount);
				//money -= amount;
			}
			System.out.println("You now have: " + userFundsMain.get(username) + "$");
			System.out.println("==================");
			transactions.add("Withdrew: " + amount);
			userMenuDisplay();
		}
		else if(choice == 3) {																//Loses track of money when signing out
			System.out.println("================");
			System.out.println("You currently have: " + userFundsMain.get(username) + "$");
			System.out.println("Enter whose account you would like to transfer into off this list of users:");
			System.out.println(loginClass.createAccounts().keySet());
			String user = scan.next();
			System.out.println("Enter how much you would like to transfer");
			int amountTransfer = scan.nextInt();
			
			if(userFundsMain.get(username) < amountTransfer) {
				System.out.println("***Insufficient Funds***");
				System.out.println("================");
				userMenuDisplay();
			}
			else {								// This block needs to be edited in order to save data
				userFundsMain.put(username, userFundsMain.get(username) - amountTransfer);
				System.out.println("You now have: " + userFundsMain.get(username) + "$");
				transactions.add("Transferred: " + amountTransfer);
				System.out.println("================");
				userMenuDisplay();
			}
		}
		else if(choice == 4) {
			System.out.println("================");
			System.out.println("Recent transactions:");
			System.out.println(transactions.toString());
			System.out.println("================");
			userMenuDisplay();
		}
		else if(choice == 5) {
			System.out.println("================");
			System.out.println("User Info:");
			System.out.println("Current funds: " + userFundsMain.get(username) + "$");
			System.out.println("Username: " + UserMenu.username);								//How to get the username and password
			System.out.println("Password: " + UserMenu.password);
			System.out.println("================");
			userMenuDisplay();
		}
		else if(choice == 6) {
			System.out.println("================");
			System.out.println("Thank you for being a value customer");
			money = 0;
			System.out.println("Returning to login page");
			System.out.println("================");
			defaultMenu.currentMenu(0);
		}
	}
}
