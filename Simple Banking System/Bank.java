import java.util.ArrayList;

public class Bank {
    private ArrayList<Customer> customers;

    public Bank() {
        customers = new ArrayList<Customer>();
    }
    public void addCustomer(Customer customer) throws DuplicateAccountException {
        for (Customer current : customers) {
            if (current.getAccount().getAccountNumber().equals(customer.getAccount().getAccountNumber()))
                throw new DuplicateAccountException("This account number is already registered.");
        }
        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }
    public Customer findCustomerByAccount(String accountNumber)
            throws AccountNotFoundException {
        for (Customer customer : customers) {
            if (customer.getAccount().getAccountNumber().equals(accountNumber))
                return customer;
        }
        throw new AccountNotFoundException("Account not found: " + accountNumber);
    }
    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException, InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) throw new InvalidAmountException("Transfer amount must be positive.");
        Customer sender = findCustomerByAccount(fromAccount);
        Customer receiver = findCustomerByAccount(toAccount);
        sender.withdrawMoney(amount);
        receiver.depositMoney(amount);
        System.out.println("Transfer completed.");
    }
}
