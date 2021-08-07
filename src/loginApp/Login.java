package loginApp;

import java.util.*;

public class Login {
	
	HashMap<String, String> accounts = new HashMap<String, String>();
	public static HashMap<String, Integer> userFunds = new HashMap<String, Integer>();
	
	// Create a HashMap object called capitalCities
	public boolean hasAccount(String hasAccount) {
		if(hasAccount.equals("yes")) {
			return true;
		}
		return false;
	}

    // Add keys and values (Country, City)
    public HashMap<String, String> createAccounts() {
    	
    	accounts.put("abrooks72", "brazodious");
    	userFunds.put("abrooks72", 10000);
        accounts.put("pepekwan", "1234");
        userFunds.put("pepekwan", 50000);
        accounts.put("TylerThompson", "Cookie123");
        userFunds.put("TylerThompson", 50000);
        accounts.put("Rodger32", "Federer");
        userFunds.put("Rodger32", 10000);
        //////////////////////////////////////////// 
        
        
       return accounts;
    }
    
	public boolean usernameCheck(String username) {
		createAccounts();
		
		if(accounts.containsKey(username)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean verifyAccount(String username, String password) {
		
		createAccounts();
		
		if(accounts.containsKey(username) && accounts.get(username).equals(password)) {
			return true;
			
		}
		else {
			System.out.println("Invalid Login Credentials");
			return false;
		}
		
		
	}
	
	
	
	
}
