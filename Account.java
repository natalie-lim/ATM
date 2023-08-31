public class Account {
    private String emailString;
    private double amount;
    
    public Account (String emailString, double initialDeposit) {
        this.emailString = emailString;
        this.amount = initialDeposit;
    }
    
    public double getAmount () {
        return amount;
    }
    
    public void depositMoney (double deposit) {
        amount += deposit;
    }
}
