import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) throws DuplicateAccountException {
        if (customer == null) throw new IllegalArgumentException("Customer cannot be null.");
        String accountNumber = customer.getAccount().getAccountNumber();
        for (Customer existing : customers) {
            if (existing.getAccount().getAccountNumber().equals(accountNumber)) {
                throw new DuplicateAccountException("Account " + accountNumber + " is already registered.");
            }
        }
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    public Customer findCustomerByAccount(String accountNumber) throws AccountNotFoundException {
        for (Customer customer : customers) {
            if (customer.getAccount().getAccountNumber().equals(accountNumber)) return customer;
        }
        throw new AccountNotFoundException("No account found with number " + accountNumber + ".");
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAmountException("Transfer amount must be greater than zero.");
        Customer sender = findCustomerByAccount(fromAccount);
        Customer receiver = findCustomerByAccount(toAccount);
        sender.withdrawMoney(amount);
        receiver.depositMoney(amount);
        System.out.printf("Transferred $%.2f from %s to %s.%n", amount, fromAccount, toAccount);
    }
}
