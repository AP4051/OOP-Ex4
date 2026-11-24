import java.util.*;
public class Bank {
 private List<Customer> customers=new ArrayList<>();
 public void addCustomer(Customer c)throws DuplicateAccountException{for(Customer x:customers)if(x.getAccount().getAccountNumber().equals(c.getAccount().getAccountNumber()))throw new DuplicateAccountException("Duplicate account");customers.add(c);}
 public Customer findCustomerByAccount(String number)throws AccountNotFoundException{for(Customer c:customers)if(c.getAccount().getAccountNumber().equals(number))return c;throw new AccountNotFoundException("Account not found");}
 public void transfer(String from,String to,double amount)throws AccountNotFoundException,InvalidAmountException,InsufficientBalanceException{
  Customer sender=findCustomerByAccount(from),receiver=findCustomerByAccount(to);
  sender.withdrawMoney(amount);receiver.depositMoney(amount);
 }
}
