public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    // TODO: Refactor to throw InvalidAmountException when amount <= 0
    public void deposit(double amount) throws InvalidAmountException{
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid deposit amount!");
        }
        balance += amount;
        System.out.println("Deposited:" + amount);

    }

    // TODO: Refactor to throw InvalidAmountException (amount <= 0) and InsufficientBalanceException (amount > balance)
    public void withdraw(double amount) throws InvalidAmountException,InsufficientBalanceException{
        if (amount <= 0) {
            throw new InvalidAmountException("Amount cannot be negative!");
        }
        if(balance < amount){
            throw new InsufficientBalanceException("Insufficient balance!");
        }

        balance -= amount;
        System.out.println( amount + "withdrew");
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}