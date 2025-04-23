public abstract class BankAccount {
    // Protected fields with initial values
    protected String accountID = "0000-0000-0000-0000";
    protected double interestRate = 0.0;
    protected int balance = 0;

    // Credit method - adds amount to balance and always returns true
    public boolean credit(int pennies) {
        balance += pennies;
        return true;
    }

    // Abstract debit method
    public abstract boolean debit(int pennies);

    // Balance getter
    public int getBalance() {
        return balance;
    }

    // AccountID getter and setter
    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    // InterestRate getter and setter
    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    // Abstract methods
    public abstract void applyInterest();
    public abstract String accountInfo();
} 