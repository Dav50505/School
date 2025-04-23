public class CheckingAccount extends BankAccount {
    // Private field for overdraft fee
    private int overdraftFee = 0;

    // Implement debit method - always succeeds but may incur overdraft fee
    @Override
    public boolean debit(int pennies) {
        balance -= pennies;
        if (balance < 0) {
            balance -= overdraftFee;
        }
        return true;
    }

    // Getter and setter for overdraft fee
    public void setFee(int overdraftFee) {
        this.overdraftFee = overdraftFee;
    }

    public int getFee() {
        return overdraftFee;
    }

    // Implement applyInterest method - adds interest if balance > 0
    @Override
    public void applyInterest() {
        if (balance > 0) {
            int interestAmount = (int)(balance * interestRate);
            balance += interestAmount;
        }
    }

    // Implement accountInfo method - returns formatted account information
    @Override
    public String accountInfo() {
        // Convert balance and fee from pennies to dollars for display
        double balanceInDollars = balance / 100.0;
        double feeInDollars = overdraftFee / 100.0;
        double interestPercentage = interestRate * 100;
        
        return String.format("Type of Account : Checking\n" +
                           "Account ID      : %s\n" +
                           "Current Balance : $%.2f\n" +
                           "Interest rate   : %.2f%%\n" +
                           "Overdraft Fee   : $%.2f",
                           accountID,
                           balanceInDollars,
                           interestPercentage,
                           feeInDollars);
    }
} 