public class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        if (accountNumber == null || accountNumber.isBlank()) throw new IllegalArgumentException("Account number is required.");
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) throw new InvalidAmountException("Deposit amount must be greater than zero.");
        balance += amount;
        System.out.printf("Deposited: $%.2f%n", amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
        if (amount > balance) throw new InsufficientBalanceException("Not enough money in account " + accountNumber + ".");
        balance -= amount;
        System.out.printf("Withdrew: $%.2f%n", amount);
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
}
