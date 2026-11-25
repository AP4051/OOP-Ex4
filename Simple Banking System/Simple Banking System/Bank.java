import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) throws DuplicateAccountException {
        String number = customer.getAccount().getAccountNumber();
        for (Customer c : customers) {
            if (c.getAccount().getAccountNumber().equals(number)) {
                throw new DuplicateAccountException("Account number " + number + " is already registered.");
            }
        }
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    public Customer findCustomerByAccount(String accountNumber) throws AccountNotFoundException {
        for (Customer c : customers) {
            if (c.getAccount().getAccountNumber().equals(accountNumber)) {
                return c;
            }
        }
        throw new AccountNotFoundException("Account not found: " + accountNumber);
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        Customer from = findCustomerByAccount(fromAccount);
        Customer to = findCustomerByAccount(toAccount);

        from.withdrawMoney(amount);
        try {
            to.depositMoney(amount);
        } catch (InvalidAmountException e) {
            // roll back the withdrawal so the transfer stays atomic
            try {
                from.depositMoney(amount);
            } catch (InvalidAmountException ignored) { }
            throw e;
        }
        System.out.println("Transferred $" + amount + " from " + from.getName() + " to " + to.getName());
    }
}
