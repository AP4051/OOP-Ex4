import java.nio.channels.IllegalSelectorException;
import java.util.List;
import java.util.ArrayList;

public class Bank {
    private List<Customer> customers;

    public Bank(){
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) throws DuplicateAccountException {
        if (customer==null){
            throw new IllegalArgumentException("Customer cannot be null");
        }
        if (searchCustomerByAccount(customer.getAccount().getAccountNumber()) != null){
            throw new DuplicateAccountException("Account " + customer.getAccount().getAccountNumber() + " already registered" );
        }
        customers.add(customer);
        System.out.println("New customer '" + customer.getName() + "' added");

    }

    public Customer searchCustomerByAccount(String accountNumber){
        for (Customer customer : this.customers) {
            if (customer.getAccount().getAccountNumber().equals(accountNumber)){
                return customer;
            }
        }
        return null;
    }

    public Customer findCustomerByAccount(String accountNumber) throws AccountNotFoundException{
        Customer foundCustomer = searchCustomerByAccount(accountNumber);
        if (foundCustomer == null){
            throw new AccountNotFoundException("Account " + accountNumber + " was not found");
        }
        return foundCustomer;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        if (amount < 0){
            throw new InvalidAmountException("Transfer amount cannot be negative");
        }
        Customer sender = findCustomerByAccount(fromAccountNumber);
        Customer receiver = findCustomerByAccount(toAccountNumber);
        sender.withdrawMoney(amount);
        receiver.depositMoney(amount);
        System.out.printf("Transferred $%.2f from %s's account with account number %s to %s's account with account number %s.%n", amount, sender.getName(), fromAccountNumber, receiver.getName(), toAccountNumber);
    }

}
