import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    private static ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
    
    public static void main(String[] args) {
        int menuChoice = 0;
        
        while (menuChoice != 9) {
            displayMainMenu();
            menuChoice = getMenuChoiceFromUser();
            handleMainMenuChoice(menuChoice);
        }
    }
    
    private static void displayMainMenu() {
        System.out.println("----------------------------");
        System.out.println("1) add account");
        System.out.println("2) make a credit");
        System.out.println("3) make a debit");
        System.out.println("4) transfer funds");
        System.out.println("5) view account details");
        System.out.println("6) apply monthly interest");
        System.out.println("9) exit program");
        System.out.println();
    }
    
    private static void displayAccountTypeMenu() {
        System.out.println("----------------------------");
        System.out.println("1) savings account");
        System.out.println("2) checking account");
        System.out.println("3) creditcard account");
        System.out.println("9) cancel add account");
        System.out.println();
    }
    
    private static int getMenuChoiceFromUser() {
        System.out.print("Enter menu choice ---> ");

        int menuChoice = in.nextInt();
        
        return menuChoice;
    }
    
    private static void handleMainMenuChoice(int menuChoice) {
        switch (menuChoice) {
            case 1:
                addAccount();
                break;
            case 2:
                makeCredit();
                break;
            case 3:
                makeDebit();
                break;
            case 4:
                transferFunds();
                break;
            case 5:
                viewAccountDetails();
                break;
            case 6:
                applyMonthlyInterest();
                break;
            case 9:
                exitProgram();
                break;
            default:
                handleMenuError();
                break;
        }
    }
    
    private static void handleAccountTypeMenuChoice(int menuChoice) {
        switch (menuChoice) {
            case 1:
                addSavingsAccount();
                return;
            case 2:
                addCheckingAccount();
                return;
            case 3:
                addCreditcardAccount();
                return;
            case 9:
                break;
            default:
                handleMenuError();
                break;
        }
    }
    
    private static void handleMenuError() {
        System.out.println("*** Invalid menu choice! ***");        
    }
    
    private static void exitProgram() {
        System.out.println("*** Exiting program! ***");
    }
    
    private static String getAccountIDFromUser() {
        System.out.print("Account number          : ");
        
        String accountNumber = in.next();
        
        return accountNumber;
    }

    private static double getInterestRateFromUser() {
        System.out.print("Interest rate           : ");
        
        double interestRate = in.nextDouble();
        
        return interestRate;
    }
    
    private static int getOverdraftFeeFromUser() {
        System.out.print("Overdraft fee (pennies) : ");
        
        int overdraftFee = in.nextInt();
        
        return overdraftFee;
    }

    private static int getCreditLimitFromUser() {
        System.out.print("Credit Limit (pennies)  : ");
        
        int creditlimit = in.nextInt();
        
        return creditlimit;
    }
    
    private static int getAmountFromUser() {
        System.out.print("Amount (in pennies)     : ");
        
        int amount = in.nextInt();
        
        return amount;
    }
      
    private static void setBasicAccountData(BankAccount account) {
        String accountId = getAccountIDFromUser();
        double interestRate = getInterestRateFromUser();
        account.setAccountID(accountId);
        account.setInterestRate(interestRate);
    }

    private static void addSavingsAccount() {
        SavingsAccount account = new SavingsAccount();
        setBasicAccountData(account);
        accounts.add(account);
    }

    private static void addCheckingAccount() {
        CheckingAccount account = new CheckingAccount();
        setBasicAccountData(account);
        int overdraftFee = getOverdraftFeeFromUser();
        account.setFee(overdraftFee);
        accounts.add(account);
    }

    private static void addCreditcardAccount() {
        CreditcardAccount account = new CreditcardAccount();
        setBasicAccountData(account);
        int creditLimit = getCreditLimitFromUser();
        account.setLimit(creditLimit);
        accounts.add(account);
    }

    private static void addAccount() {
        displayAccountTypeMenu();
        int menuChoice = getMenuChoiceFromUser();
        handleAccountTypeMenuChoice(menuChoice);
    }

    private static void makeCredit() {
        String accountId = getAccountIDFromUser();
        int amount = getAmountFromUser();
        
        boolean found = false;
        for (BankAccount account : accounts) {
            if (account.getAccountID().equals(accountId)) {
                account.credit(amount);
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("*** Credit failed - Invalid account number! ***");
        }
    }

    private static void makeDebit() {
        String accountId = getAccountIDFromUser();
        int amount = getAmountFromUser();
        
        boolean found = false;
        for (BankAccount account : accounts) {
            if (account.getAccountID().equals(accountId)) {
                if (!account.debit(amount)) {
                    System.out.println("*** Debit failed - Insufficient funds or credit! ***");
                }
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("*** Debit failed - Invalid account number! ***");
        }
    }

    private static void transferFunds() {
        String fromAccountId = getAccountIDFromUser();
        String toAccountId = getAccountIDFromUser();
        int amount = getAmountFromUser();
        
        BankAccount fromAccount = null;
        BankAccount toAccount = null;
        
        for (BankAccount account : accounts) {
            if (account.getAccountID().equals(fromAccountId)) {
                fromAccount = account;
            }
            if (account.getAccountID().equals(toAccountId)) {
                toAccount = account;
            }
        }
        
        if (fromAccount == null || toAccount == null) {
            System.out.println("*** Transfer failed - Invalid account number! ***");
            return;
        }
        
        if (fromAccount.getBalance() < amount) {
            System.out.println("*** Transfer failed - Insufficient funds! ***");
            return;
        }
        
        if (fromAccount.debit(amount)) {
            toAccount.credit(amount);
        }
    }

    private static void viewAccountDetails() {
        String accountId = getAccountIDFromUser();
        
        boolean found = false;
        for (BankAccount account : accounts) {
            if (account.getAccountID().equals(accountId)) {
                System.out.println(account.accountInfo());
                found = true;
                break;
            }
        }
        
        if (!found) {
            System.out.println("*** Operation failed - Invalid account number! ***");
        }
    }

    private static void applyMonthlyInterest() {
        for (BankAccount account : accounts) {
            account.applyInterest();
        }
    }
}