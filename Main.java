public class Main {
 public static void main(String[] args){
  Bank bank=new Bank();Customer a=new Customer("Alice","123"),b=new Customer("Bob","456");
  try{
   bank.addCustomer(a);bank.addCustomer(b);a.depositMoney(500);a.withdrawMoney(100);bank.transfer("123","456",200);a.checkBalance();b.checkBalance();
   try{bank.addCustomer(new Customer("Other","123"));}catch(DuplicateAccountException e){System.out.println(e.getMessage());}
   try{a.depositMoney(-5);}catch(InvalidAmountException e){System.out.println(e.getMessage());}
   try{a.withdrawMoney(9999);}catch(InsufficientBalanceException e){System.out.println(e.getMessage());}
   try{bank.transfer("123","999",10);}catch(AccountNotFoundException e){System.out.println(e.getMessage());}
  }catch(Exception e){System.out.println(e.getMessage());}
  finally{System.out.println("Transaction attempt completed.");}
 }
}
