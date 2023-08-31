import java.util.HashMap;

public class ATM {
    private HashMap <String, Account> mapOfAccounts;
    
    public ATM (String email) {
        this.mapOfAccounts = new HashMap<String, Account>();
    }
    
    public void openAccount (String emailString, double amount) {
        if (mapOfAccounts.get(emailString) != null) {
            throw new Error("User already exists");
        }
        Account account = new Account(emailString);
        mapOfAccounts.put (emailString, new Account(emailString, amount));
    }
}