public class Customer {
    private String name;
    private BankAccount account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    // TODO: Declare throws InvalidAmountException
    public void depositMoney(double amount) throws InvalidAmountException {
        account.deposit(amount);
    }

    // TODO: Declare throws InvalidAmountException, InsufficientBalanceException
    public void withdrawMoney(double amount) throws InvalidAmountException, InsufficientBalanceException {
        account.withdraw(amount);
    }

    public void checkBalance() {
        System.out.println(name + "'s balance: $" + account.getBalance());
    }

    public String getName() {
        return name;
    }

    public BankAccount getAccount() {
        return account;
    }
}