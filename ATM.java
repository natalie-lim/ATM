import java.util.HashMap;

public class ATM {
    private HashMap <String, Account> mapOfAccounts;
    
    public ATM () {
        this.mapOfAccounts = new HashMap<String, Account>();
    }
    
    public void openAccount (String emailString, double amount) {
        if (mapOfAccounts.get(emailString) != null) {
            throw new Error("User already exists");
        }
        mapOfAccounts.put (emailString, new Account(emailString, amount));
    }
    
    public void closeAccount (String emailString) {
        if (mapOfAccounts.get(emailString).getAmount() == 0) {
            mapOfAccounts.remove(emailString);
        }
        throw new Error ("Please remove the rest of your $$$ before closing;");
    }
}