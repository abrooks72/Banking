package loginApp;

import java.util.*;

public class Login {
	
	HashMap<String, String> accounts = new HashMap<String, String>();
	
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
        accounts.put("pepekwan", "1234");
        accounts.put("TylerThompson", "Cookie123");
        accounts.put("Rodger32", "Federer");
        //////////////////////////////////////////// 
        
        
       return accounts;
    }
    
	
	
	public Login() {
		
	}
	
	public boolean verifyAccount(String username, String password) {
		
		createAccounts();
		
		if(accounts.containsKey(username) && accounts.get(username).equals(password)) {
			System.out.println("Successfully logged in");
			return true;
		}
		else {
			System.out.println("Invalid Login Credentials");
			return false;
		}
		
		
	}
	
	
	
	
}
