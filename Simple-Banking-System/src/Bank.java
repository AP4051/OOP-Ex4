import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) throws DuplicateAccountException {
        for (Customer existing : customers) {
            if (existing.getAccount().getAccountNumber().equals(customer.getAccount().getAccountNumber()))
                throw new DuplicateAccountException("Account number already registered.");
        }
        customers.add(customer);
        System.out.println("New customer added : " + customer.getName());
    }

    public Customer findCustomerByAccount(String accountNumber) throws AccountNotFoundException {
        for (Customer customer : customers) {
            if (customer.getAccount().getAccountNumber().equals(accountNumber))
                return customer;
        }
        throw new AccountNotFoundException("Account " + accountNumber + " not found.");
    }

    public void transfer(String fromAccount,String toAccount,double amount) throws AccountNotFoundException,InvalidAmountException,InsufficientBalanceException {
        if (amount <= 0)
            throw new InvalidAmountException("Transfer amount must be greater than zero.");
        Customer from = findCustomerByAccount(fromAccount);
        Customer to = findCustomerByAccount(toAccount);
        from.withdrawMoney(amount);
        to.depositMoney(amount);
        System.out.println("Transfer completed.");
    }

}