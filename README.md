# 🏦 Bank Account System (Multiple Accounts & Transfers)

A Java console application demonstrating encapsulation, arrays of objects, and safe account-to-account transfers.

---

## 📌 Project Overview

This program stores multiple `BankAccount` objects in an array and allows users to:
- Login using **account number** and **PIN**
- Check balance
- Deposit money
- Withdraw money
- View account details
- Transfer money to another account
- Update account holder name
- Exit the application

---

## 🎯 Learning Objectives

- Understand encapsulation: keep account details private and expose operations via methods
- Store multiple objects in an array and search them with loops
- Implement safe transfers where the sender cannot directly modify the receiver's balance
- Practice constructors, methods, Scanner input, conditionals, loops, and switch-case

---

## 🗂️ Project Structure

```
BankAccountProject/
│
├── BankApp.java          # Main class (contains BankAccount class and program)
└── README.md
```

Note: `BankAccount` is implemented inside `BankApp.java` in this workspace.

---

## 🧱 BankAccount (summary)

Each account contains (all fields private):
- `accountNumber` (int)
- `accountHolderName` (String)
- `pin` (int)
- `balance` (double)

Key methods:
- `login(int enteredAccountNumber, int enteredPin)` — authenticate user
- `checkBalance()` — print current balance
- `deposit(double amount)` — add funds (amount &gt; 0)
- `withdraw(double amount)` — remove funds if sufficient balance
- `displayAccountDetails()` — show account number and holder name
- `transferAmount(BankAccount receiver, double amount)` — transfer to another account with validations
- `setAccountHolderName(String newName)` — update holder name

---

## ▶️ How to Build & Run

Compile:
```bash
javac BankApp.java
```

Run:
```bash
java BankApp
```

Sample accounts included in code:
- `1001` (Rahul) PIN `1234` balance `5000.0`
- `1002` (Priya) PIN `2345` balance `8000.0`
- `1003` (Amit) PIN `3456` balance `3000.0`
- `1004` (Sneha) PIN `4567` balance `10000.0`

---

## 🖥️ Typical Usage Flow

1. Start the application
2. Enter account number and PIN
3. On successful login, use the menu to choose operations (check balance, deposit, withdraw, display details, transfer, update name, exit)

Transfer rules:
- Receiver account must exist in the array
- Sender and receiver cannot be the same
- Transfer amount must be &gt; 0 and sender must have sufficient balance

---

## ✅ Important Conditions

- All account details are private and manipulated only through methods
- PIN is not displayed anywhere
- Deposit/withdraw/transfer amounts must be positive
- Withdrawal/transfer only proceed when sufficient balance is available

---

## 👨‍💻 Author

**Ganesh Reddy**
