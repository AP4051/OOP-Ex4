import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    // TODO: Throw DuplicateAccountException if a customer with the same accountNumber already exists
    public void addCustomer(Customer customer) throws DuplicateAccountException{
        for(int i =0; i<=customers.size();i++){
            if(customers.get(i).getAccount().getAccountNumber().equalsIgnoreCase(customer.getAccount().getAccountNumber())){
                throw new DuplicateAccountException("this account already exists!");
            }
        }
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    // TODO: Implement findCustomerByAccount(String accountNumber) throwing AccountNotFoundException
    public Customer findCustomerByAccount(String accountNumber) throws AccountNotFoundException{
        for(int i = 0 ; i <= customers.size() ; i++){
            if (customers.get(i).getAccount().getAccountNumber().equals(accountNumber)) {
                return customers.get(i);
            }
        }
        throw new AccountNotFoundException("account not found!" + accountNumber);
    }

    // TODO: Implement transfer(String fromAccount, String toAccount, double amount)
    //       throwing AccountNotFoundException, InvalidAmountException, InsufficientBalanceException
    public void transfer(String fromAccount, String toAccount, double amount) throws InvalidAmountException,InsufficientBalanceException, AccountNotFoundException{
        Customer sender = findCustomerByAccount(fromAccount);
        Customer reciever = findCustomerByAccount(toAccount);
        sender.withdrawMoney(amount);
        reciever.depositMoney(amount);
        System.out.println( amount + "transferd!");
    }
}