public class Customer {
 private String name;private BankAccount account;
 public Customer(String name,String number){this.name=name;account=new BankAccount(number);}
 public String getName(){return name;}
 public BankAccount getAccount(){return account;}
 public void depositMoney(double amount)throws InvalidAmountException{account.deposit(amount);}
 public void withdrawMoney(double amount)throws InvalidAmountException,InsufficientBalanceException{account.withdraw(amount);}
 public void checkBalance(){System.out.println(name+": "+account.getBalance());}
}
