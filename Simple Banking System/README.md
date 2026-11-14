# Simple Banking System (Exception Handling Edition) 💰

## Features
- Create and register bank accounts for customers, preventing duplicate account numbers.
- Perform deposits, withdrawals, and transfers with strict exception-based validation.
- Prevent overdrafts, invalid amounts, and operations on non-existent accounts using custom exceptions.

## Classes & Structure
```plaintext
SimpleBankingSystem
 ├── InvalidAmountException (To Be Created)
 ├── InsufficientBalanceException (To Be Created)
 ├── AccountNotFoundException (To Be Created)
 ├── DuplicateAccountException (To Be Created)
 ├── BankAccount
 ├── Customer
 ├── Bank
 └── Main (Runner)
```

## Starter Implementation

### `BankAccount.java`
```java
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // TODO: Refactor to throw InvalidAmountException when amount <= 0
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // TODO: Refactor to throw InvalidAmountException (amount <= 0) and InsufficientBalanceException (amount > balance)
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
```

### `Customer.java`
```java
public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    // TODO: Declare throws InvalidAmountException
    public void depositMoney(double amount) {
        account.deposit(amount);
    }

    // TODO: Declare throws InvalidAmountException, InsufficientBalanceException
    public void withdrawMoney(double amount) {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }
}
```

### `Bank.java`
```java
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    // TODO: Throw DuplicateAccountException if a customer with the same accountNumber already exists
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    // TODO: Implement findCustomerByAccount(String accountNumber) throwing AccountNotFoundException

    // TODO: Implement transfer(String fromAccount, String toAccount, double amount)
    //       throwing AccountNotFoundException, InvalidAmountException, InsufficientBalanceException
}
```

### `Main.java`
```java
public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        // TODO: Wrap customer registration, deposits, withdrawals, and transfers in try-catch-finally blocks
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);

        customer1.depositMoney(500);
        customer1.withdrawMoney(200);
        customer1.checkBalance();
    }
}
```

## Assignment Tasks (Exception Handling)
1. **Create Custom Exception Classes** (extending `Exception`):
   - `InvalidAmountException`: Thrown whenever a deposit, withdrawal, or transfer amount is `<= 0`.
   - `InsufficientBalanceException`: Thrown when a withdrawal or transfer amount exceeds the account's current `balance`.
   - `AccountNotFoundException`: Thrown when `findCustomerByAccount` or `transfer` references an account number that does not exist in the bank.
   - `DuplicateAccountException`: Thrown when `addCustomer` receives a customer whose `accountNumber` is already registered.
2. **Refactor `BankAccount.java`**:
   - Update `deposit(double amount)` to `throws InvalidAmountException` and remove the `else` print statement.
   - Update `withdraw(double amount)` to `throws InvalidAmountException, InsufficientBalanceException`, checking each condition separately and throwing the matching exception with a clear message.
3. **Refactor `Customer.java`**:
   - Update `depositMoney` and `withdrawMoney` signatures with the appropriate `throws` declarations so exceptions propagate cleanly to the caller.
4. **Extend `Bank.java`**:
   - Update `addCustomer(Customer customer)` to check for duplicate account numbers and throw `DuplicateAccountException`.
   - Implement `findCustomerByAccount(String accountNumber) throws AccountNotFoundException`.
   - Implement `transfer(String fromAccount, String toAccount, double amount)` using `findCustomerByAccount`, `withdraw`, and `deposit`.
5. **Update `Main.java`**:
   - Use `try-catch-finally` blocks to test:
     - Registering a duplicate account number (`DuplicateAccountException`).
     - Depositing a negative or zero amount (`InvalidAmountException`).
     - Withdrawing more than the available balance (`InsufficientBalanceException`).
     - Transferring to a non-existent account (`AccountNotFoundException`).
   - Print `"Transaction attempt completed."` inside a `finally` block.

## How to Run
1. Compile all Java files:
   ```bash
   javac *.java
   ```
2. Run the `Main` class:
   ```bash
   java Main
   ```

## Future Enhancements
- Ensure `transfer(...)` is atomic by rolling back the withdrawal if the deposit fails.
- Add an `InsufficientFundsForFeeException` for transfers above a certain limit.

---
🏦 **Manage your finances safely with clean exception handling!** 💳
