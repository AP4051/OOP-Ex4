import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer)
            throws DuplicateAccountException {
        String accountNumber = customer.getAccount().getAccountNumber();

        for (Customer existingCustomer : customers) {
            if (existingCustomer.getAccount().getAccountNumber()
                    .equals(accountNumber)) {
                throw new DuplicateAccountException(
                        "Account already registered: " + accountNumber
                );
            }
        }

        customers.add(customer);
        System.out.println("New customer added: " + customer.getName());
    }

    public Customer findCustomerByAccount(String accountNumber)
            throws AccountNotFoundException {
        for (Customer customer : customers) {
            if (customer.getAccount().getAccountNumber()
                    .equals(accountNumber)) {
                return customer;
            }
        }

        throw new AccountNotFoundException(
                "Account not found: " + accountNumber
        );
    }

    public void transfer(String fromAccount, String toAccount, double amount)
            throws AccountNotFoundException,
            InvalidAmountException,
            InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                    "Transfer amount must be greater than zero."
            );
        }

        Customer sender = findCustomerByAccount(fromAccount);
        Customer receiver = findCustomerByAccount(toAccount);

        sender.withdrawMoney(amount);
        receiver.depositMoney(amount);

        System.out.println(
                "Transferred $" + amount + " from "
                        + fromAccount + " to " + toAccount
        );
    }
}
