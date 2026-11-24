public class BankAccount {
 private String accountNumber;private double balance;
 public BankAccount(String number){accountNumber=number;}
 public String getAccountNumber(){return accountNumber;}
 public double getBalance(){return balance;}
 public void deposit(double amount)throws InvalidAmountException{if(amount<=0)throw new InvalidAmountException("Amount must be positive");balance+=amount;}
 public void withdraw(double amount)throws InvalidAmountException,InsufficientBalanceException{if(amount<=0)throw new InvalidAmountException("Amount must be positive");if(amount>balance)throw new InsufficientBalanceException("Not enough balance");balance-=amount;}
}
