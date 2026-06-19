import java.util.Scanner;

class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private int pin;
    private double balance;

    BankAccount(int accountNumber, String accountHolderName, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = balance;
    }

    // Backward-compatible constructor that accepts account number as String
    BankAccount(String accountNumberStr, String accountHolderName, int pin, double balance) {
        try {
            this.accountNumber = Integer.parseInt(accountNumberStr);
        } catch (NumberFormatException e) {
            this.accountNumber = 0;
        }
        this.accountHolderName = accountHolderName;
        this.pin = pin;
        this.balance = balance;
    }

    boolean login(int enteredAccountNumber, int enteredPin) {
        return this.accountNumber == enteredAccountNumber && this.pin == enteredPin;
    }

    // Backward-compatible login that accepts only PIN (some older code used this)
    boolean login(int enteredPin) {
        return this.pin == enteredPin;
    }

    void checkBalance() {
        System.out.println("Current Balance: " + this.balance);
    }

    void deposit(double amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;
            System.out.println("Amount Deposited Successfully");
            System.out.println("Updated Balance: " + this.balance);
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Withdrawal Amount");
            return false;
        }

        if (amount > this.balance) {
            System.out.println("Insufficient Balance");
            return false;
        }

        this.balance = this.balance - amount;
        System.out.println("Amount Withdrawn Successfully");
        System.out.println("Updated Balance: " + this.balance);
        return true;
    }

    void displayAccountDetails() {
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Holder Name: " + this.accountHolderName);
    }

    int getAccountNumber() {
        return this.accountNumber;
    }

    void receiveAmount(double amount) {
        if (amount > 0) {
            this.balance = this.balance + amount;
        }
    }

    void transferAmount(BankAccount receiver, double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Transfer Amount");
            return;
        }

        if (amount > this.balance) {
            System.out.println("Insufficient Balance");
            return;
        }

        this.balance = this.balance - amount;
        receiver.receiveAmount(amount);
        System.out.println("Transfer Successful");
        System.out.println("Amount Transferred: " + amount);
        System.out.println("Updated Balance: " + this.balance);
    }

    void setAccountHolderName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            this.accountHolderName = newName;
            System.out.println("Account holder name updated successfully");
            System.out.println("Updated Account Holder Name: " + this.accountHolderName);
        } else {
            System.out.println("Invalid Name");
        }
    }

}

public class BankApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount[] accounts = new BankAccount[4];
        accounts[0] = new BankAccount(1001, "Rahul", 1234, 5000.0);
        accounts[1] = new BankAccount(1002, "Priya", 2345, 8000.0);
        accounts[2] = new BankAccount(1003, "Amit", 3456, 3000.0);
        accounts[3] = new BankAccount(1004, "Sneha", 4567, 10000.0);

        System.out.println("Welcome to Bank Application");
        System.out.println();

        System.out.println("Enter Account Number:");
        int enteredAccountNumber = scanner.nextInt();

        System.out.println();
        System.out.println("Enter PIN:");
        int enteredPin = scanner.nextInt();

        BankAccount loggedInAccount = null;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i].login(enteredAccountNumber, enteredPin)) {
                loggedInAccount = accounts[i];
                break;
            }
        }

        if (loggedInAccount == null) {
            System.out.println();
            System.out.println("Invalid Account Number or PIN");
            scanner.close();
            return;
        }

        System.out.println();
        System.out.println("Login Successful");

        while (true) {

            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Display Account Details");
            System.out.println("5. Transfer Amount");
            System.out.println("7. Update Account Holder Name");
            System.out.println("6. Exit");
            System.out.println();
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {

                case 1:
                    loggedInAccount.checkBalance();
                    break;

                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    loggedInAccount.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    loggedInAccount.withdraw(withdrawAmount);
                    break;

                case 4:
                    loggedInAccount.displayAccountDetails();
                    break;

                case 5:
                    System.out.println("Enter receiver account number:");
                    int receiverAccountNumber = scanner.nextInt();

                    if (receiverAccountNumber == loggedInAccount.getAccountNumber()) {
                        System.out.println();
                        System.out.println("Cannot transfer amount to the same account");
                        break;
                    }

                    BankAccount receiverAccount = null;
                    for (int i = 0; i < accounts.length; i++) {
                        if (accounts[i].getAccountNumber() == receiverAccountNumber) {
                            receiverAccount = accounts[i];
                            break;
                        }
                    }

                    if (receiverAccount == null) {
                        System.out.println();
                        System.out.println("Receiver Account Not Found");
                        break;
                    }

                    System.out.println();
                    System.out.println("Enter transfer amount:");
                    double transferAmount = scanner.nextDouble();
                    loggedInAccount.transferAmount(receiverAccount, transferAmount);
                    break;

                case 7:
                    scanner.nextLine(); // consume newline
                    System.out.println("Enter new account holder name:");
                    String newName = scanner.nextLine();
                    loggedInAccount.setAccountHolderName(newName);
                    break;

                case 6:
                    System.out.println("Thank you for using the Bank Application");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
}
