public class SavingsAccount extends BankAccount {
    // Implement debit method - returns false if amount is more than balance
    @Override
    public boolean debit(int pennies) {
        if (pennies > balance) {
            return false;
        }
        balance -= pennies;
        return true;
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
        // Convert balance from pennies to dollars for display
        double balanceInDollars = balance / 100.0;
        double interestPercentage = interestRate * 100;
        
        return String.format("Type of Account : Savings\n" +
                           "Account ID      : %s\n" +
                           "Current Balance : $%.2f\n" +
                           "Interest rate   : %.2f%%",
                           accountID,
                           balanceInDollars,
                           interestPercentage);
    }
} 