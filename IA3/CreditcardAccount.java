public class CreditcardAccount extends BankAccount {
    // Private field for credit limit
    private int limit = 0;

    // Implement debit method - succeeds only if within credit limit
    @Override
    public boolean debit(int pennies) {
        // Check if debit would exceed credit limit
        if ((balance - pennies) < -limit) {
            return false;
        }
        balance -= pennies;
        return true;
    }

    // Getter and setter for credit limit
    public void setLimit(int creditLimit) {
        this.limit = creditLimit;
    }

    public int getLimit() {
        return limit;
    }

    // Implement applyInterest method - adds interest if balance < 0
    @Override
    public void applyInterest() {
        if (balance < 0) {
            int interestAmount = (int)(balance * interestRate);
            balance += interestAmount;
        }
    }

    // Implement accountInfo method - returns formatted account information
    @Override
    public String accountInfo() {
        // Convert balance and limit from pennies to dollars for display
        // Show balance as positive value
        double balanceInDollars = Math.abs(balance) / 100.0;
        double limitInDollars = limit / 100.0;
        double interestPercentage = interestRate * 100;
        
        return String.format("Type of Account : Creditcard\n" +
                           "Account ID      : %s\n" +
                           "Current Balance : $%.2f\n" +
                           "Interest rate   : %.2f%%\n" +
                           "Credit Limit    : $%.2f",
                           accountID,
                           balanceInDollars,
                           interestPercentage,
                           limitInDollars);
    }
} 