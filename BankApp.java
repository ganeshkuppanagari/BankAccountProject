import java.util.Scanner;

public class BankApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create BankAccount object
        BankAccount account = new BankAccount("0345", "Ganesh Reddy", 1234, 5000.0);

        // Ask user to enter PIN
        System.out.println("Enter PIN:");
        int enteredPin = scanner.nextInt();

        // Verify PIN using login()
        boolean isLoggedIn = account.login(enteredPin);

        // If wrong PIN, stop the program
        if (!isLoggedIn) {
            scanner.close();
            return;
        }

        // Menu loop after successful login
        while (true) {

            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Amount");
            System.out.println("3. Withdraw Amount");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.println();
            System.out.println("Enter your choice:");

            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {

                case 1:
                    account.checkBalance();
                    break;

                case 2:
                    System.out.println("Enter deposit amount:");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Enter withdrawal amount:");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    account.displayAccountDetails();
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank Application");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}
