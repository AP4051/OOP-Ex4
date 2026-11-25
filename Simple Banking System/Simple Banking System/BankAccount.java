public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid deposit amount: " + amount + ". Amount must be greater than zero.");
        }
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid withdrawal amount: " + amount + ". Amount must be greater than zero.");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Requested: $" + amount + ", available: $" + balance);
        }
        balance -= amount;
        System.out.println("Withdrew: $" + amount);
    }

    public double getBalance() { return balance; }

    public String getAccountNumber() { return accountNumber; }
}
