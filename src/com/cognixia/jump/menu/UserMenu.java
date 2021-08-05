package com.cognixia.jump.menu;

import java.util.Scanner;

import loginApp.Login;

public class UserMenu {
	
	Scanner scan = new Scanner(System.in);
	public static Login loginClass = new Login();
	public static Menu defaultMenu = new Menu();
	public int money = 0;
	
	public UserMenu() {
		
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
		
		System.out.println("What would you like to do?");
		choice = scan.nextInt();
		
		userMenuOption(choice);
	}
	
	public void userMenuOption(int choice) {
		
		if(choice == 1) {																	//DEPOSIT
			System.out.println("How much would you like to deposit into your account:");
			money += scan.nextInt();
			System.out.println("You now have: " + money + "$");
			System.out.println("==================");
			userMenuDisplay();
		}
		else if(choice == 2) {																//WITHDRAW
			System.out.println("How much would you like to withdraw from your account:");
			int amount = 0;
			amount = scan.nextInt();
			if(money < amount) {
				System.out.println("***Insufficient Funds***");
				userMenuDisplay();
			}
			else {
				money -= amount;
			}
			System.out.println("You now have: " + money + "$");
			System.out.println("==================");
			userMenuDisplay();
		}
		else if(choice == 3) {																//Loses track of money when signing out
			System.out.println("Enter whose account you would like to transfer into off this list of users:");
			System.out.println(loginClass.createAccounts().keySet());
			String user = scan.next();
			System.out.println("Enter how much you would like to transfer");
			int amountTransfer = scan.nextInt();
			
			if(amountTransfer > money) {
				System.out.println("***Insufficient Funds***");
				System.out.println("================");
				userMenuDisplay();
			}
			else {
				money -= amountTransfer;
				System.out.println("You now have: " + money + "$");
				userMenuDisplay();
			}
		}
		else if(choice == 4) {
			System.out.println("Recent transactions:");
		}
		else if(choice == 5) {
			System.out.println("User Info:");
		}
		else if(choice == 6) {
			System.out.println("Thank you for using Austin Express");
			money = 0;
			defaultMenu.currentMenu(0);
		}
	}
}
