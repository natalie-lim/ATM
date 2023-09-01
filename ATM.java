import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class ATM {
    private HashMap <String, Account> mapOfAccounts;
    
    public ATM () {
        this.mapOfAccounts = new HashMap<String, Account>();
    }
    
    public void openAccount (String emailString, double amount) {
        if (userExists(emailString)) {
            throw new Error("User already exists");
        }
        mapOfAccounts.put (emailString, new Account(emailString, amount));
    }
    
    public void closeAccount (String emailString) {
        if (mapOfAccounts.get(emailString).getAmount() == 0) {
            mapOfAccounts.remove(emailString);
        } else {
            throw new Error ("Please remove the rest of your $$$ before closing;");
        }
    }
    
    public double checkBalance (String emailString) {
        if (!userExists(emailString)) {
            throw new Error("Acount does not exist");
        }
        return mapOfAccounts.get(emailString).getAmount();
    }
    
    public double depositMoney (String emailString, double deposit) {
        if (!userExists(emailString)) {
            throw new Error("You're broke af! LOL!");
        }
        Account current = mapOfAccounts.get(emailString);
        current.depositMoney(deposit);
        return current.getAmount();
    }
    
    public double withdrawMoney (String emailString, double withdrawal) {
        if (!userExists(emailString)) {
            throw new Error("You're broke af! LOL!");
        }
        Account current = mapOfAccounts.get(emailString);
        current.withdrawMoney(withdrawal);
        return current.getAmount();
    }
    
    public boolean transferMoney (String emailString, String toAccount, double amount) {
        if (!userExists(emailString) || !userExists(toAccount)) {
            return false;
        }
        Account current = mapOfAccounts.get(emailString);
        Account transferTo = mapOfAccounts.get(toAccount);
        current.withdrawMoney(amount);
        transferTo.depositMoney(amount);
        return true;
    }
    
    public void audit () throws FileNotFoundException {
        File file = new File("AccountAudit.txt");
        if (file.exists()) {
            file.delete();
        }
        PrintWriter pw = new PrintWriter ("AccountAudit.txt");
        for (Map.Entry<String, Account> user : mapOfAccounts.entrySet()) {
            String email = user.getKey();
            double amount = user.getValue().getAmount();
            pw.println(email);
            pw.println(amount);
        }
        pw.close();
    }
    
    private boolean userExists (String emailString) {
        if (mapOfAccounts.get(emailString) == null) {
            return false;
        }
        return true;
    }
}