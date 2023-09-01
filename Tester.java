import java.io.FileNotFoundException;

public class Tester {
    public static void main (String [] args) throws FileNotFoundException {
        ATM atm = new ATM ();
        String email1 = "natalielim@gmail.com";
        String email2 = "bob@gmail.com";
        String email3 = "apple@gmail.com";
        String email4 = "cat@gmail.com";
        String email5 = "dog@gmail.com";
        
        //Testing OpenAccount
        atm.openAccount(email1, 0);
        atm.openAccount(email2, 33.23);
        atm.openAccount(email3, 13551.23);
        atm.openAccount(email4, 1234.23);
        atm.openAccount(email5, 12.23);
        
        //Testing CloseAccount
        atm.closeAccount(email1);
        
        //Testing checkBalance
        System.out.println();
        System.out.println (atm.checkBalance(email5));
        System.out.println (atm.checkBalance(email3));
        
        //Testing depositMoney
        System.out.println();
        System.out.println (atm.checkBalance(email2));
        System.out.println (atm.checkBalance(email3));
        atm.depositMoney(email2, 12.12);
        atm.depositMoney(email3, 12);
        System.out.println (atm.checkBalance(email2));
        System.out.println (atm.checkBalance(email3));
        
        //Testing withdraMoney
        System.out.println();
        System.out.println (atm.checkBalance(email2));
        System.out.println (atm.checkBalance(email3));
        atm.withdrawMoney(email2, 12.12);
        atm.withdrawMoney(email3, 12);
        System.out.println (atm.checkBalance(email2));
        System.out.println (atm.checkBalance(email3));
        
        //testing transferMoney
        System.out.println();
        System.out.println (atm.checkBalance(email4));
        System.out.println (atm.checkBalance(email5));
        System.out.println(atm.transferMoney(email4, email5, 200));
        System.out.println (atm.checkBalance(email4));
        System.out.println (atm.checkBalance(email5));
        
        atm.audit();
    }
}
