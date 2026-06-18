# 🏦 Simple Bank Account System Using Encapsulation

A beginner-level Java project that demonstrates the concept of **Encapsulation** through a simple bank account management system.

---

## 📌 Project Overview

This project simulates a basic bank account system where a user can:
- Login using a secret PIN
- Check account balance
- Deposit money
- Withdraw money
- View account details
- Exit the application

---

## 🎯 Objective

The main objective of this project is to understand how **Encapsulation** works in Java.

- Keep important data **private** inside a class
- Access data **only through public methods**
- In real banking systems, details like PIN and balance should never be directly accessible from outside the class

---

## 🗂️ Project Structure

```
BankAccountProject/
│
├── BankAccount.java      # Class with private variables and methods
├── BankApp.java          # Main class with menu and user interaction
└── README.md
```

---

## 🧱 Class Structure

### `BankAccount.java`

| Member | Type | Description |
|--------|------|-------------|
| `accountNumber` | `private String` | Stores the account number |
| `accountHolderName` | `private String` | Stores the account holder's name |
| `pin` | `private int` | Stores the secret PIN |
| `balance` | `private double` | Stores the current balance |

#### Methods

| Method | Return Type | Description |
|--------|-------------|-------------|
| `login(int enteredPin)` | `boolean` | Verifies the user PIN |
| `checkBalance()` | `void` | Displays current balance |
| `deposit(double amount)` | `void` | Adds amount to balance |
| `withdraw(double amount)` | `void` | Deducts amount from balance |
| `displayAccountDetails()` | `void` | Shows account number and holder name |

---

## ▶️ How to Run

### Step 1: Compile
```bash
javac BankAccount.java BankApp.java
```

### Step 2: Run
```bash
java BankApp
```

---

## 🖥️ Sample Output

```
Enter PIN:
1234

Login Successful

1. Check Balance
2. Deposit Amount
3. Withdraw Amount
4. Display Account Details
5. Exit

Enter your choice:
1

Current Balance: 5000.0
```

---

## ✅ Important Conditions

- All instance variables are `private`
- No direct access to variables from outside the class
- PIN is never displayed in output
- Deposit amount must be greater than zero
- Withdrawal only allowed if sufficient balance exists
- Menu continues until user chooses Exit

---

## 💡 Concepts Used

- **Encapsulation**
- Classes and Objects
- Private Instance Variables
- Parameterized Constructor
- Public Methods
- Scanner (User Input)
- if-else conditions
- switch-case
- while loop

---

## 👨‍💻 Author

**Ganesh Reddy**  
