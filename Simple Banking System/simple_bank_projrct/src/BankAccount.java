public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public void deposit(double amount) throws InvalidAmountException{
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid deposit amount");
        }
        this.balance += amount;
        System.out.printf("Deposited %.2f%n", amount);
    }
    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new InvalidAmountException("Invalid withdrawal amount");
        }
        else if (amount > this.balance){
            throw new InsufficientBalanceException("The balance is insufficient");
        }
        this.balance -= amount;
        System.out.printf("Withdrew %.2f%n", amount);
    }

    public double getBalance(){
        return this.balance;
    }
    public String getAccountNumber(){
        return this.accountNumber;
    }
}
