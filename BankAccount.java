public class BankAccount {

    // Private instance variables
    private String accountNumber;
    private String accountHolderName;
    private int pin;
    private double balance;

    // Parameterized Constructor
    BankAccount(String accountNumber, String accountHolderName, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = balance;
    }

    // Method 1: Login
    boolean login(int enteredPin) {
        if (enteredPin == this.pin) {
            System.out.println("Login Successful");
            return true;
        } else {
            System.out.println("Invalid PIN");
            return false;
        }
    }

    // Method 2: Check Balance
    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Method 3: Deposit
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount Deposited Successfully");
            System.out.println("Updated Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    // Method 4: Withdraw
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Amount Withdrawn Successfully");
            System.out.println("Updated Balance: " + balance);
        }
    }

    // Method 5: Display Account Details (PIN must NOT be shown)
    void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder Name: " + accountHolderName);
    }
}
