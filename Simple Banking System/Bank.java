import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) throws DuplicateAccountException {
        for (int i = 0; i < customers.size(); i++) {
            Customer existing = customers.get(i);
            if (existing.getAccount().getAccountNumber().equals(customer.getAccount().getAccountNumber())) {
                throw new DuplicateAccountException("Account number " + customer.getAccount().getAccountNumber() + " already exists!");
            }
        }
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    public Customer findCustomerByAccount(String accountNumber) throws AccountNotFoundException {
        for (int i = 0; i < customers.size(); i++) {
            Customer current = customers.get(i);
            if (current.getAccount().getAccountNumber().equals(accountNumber)) {
                return current;
            }
        }
        throw new AccountNotFoundException("Account " + accountNumber + " not found!");
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Customer sender = findCustomerByAccount(fromAccount);
        Customer receiver = findCustomerByAccount(toAccount);

        sender.withdrawMoney(amount);
        receiver.depositMoney(amount);
        System.out.println("Transferred $" + amount + " from " + sender.getName() + " to " + receiver.getName());
    }
}