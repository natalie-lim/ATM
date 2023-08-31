public class Tester {
    public static void main (String [] args) {
        ATM atm = new ATM ();
        String email = "natalielim@gmail.com";
        atm.openAccount(email, 1234.23);
        System.out.println (atm.depositMoney(email, 1234.123));
    }
}
