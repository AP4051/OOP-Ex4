public class Customer {
    private final String name;
    private final BankAccount account;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.account = new BankAccount(accountNumber);
    }

    public void depositMoney(double amount) throws InvalidAmountException { account.deposit(amount); }
    public void withdrawMoney(double amount) throws InvalidAmountException, InsufficientBalanceException { account.withdraw(amount); }
    public void checkBalance() { System.out.printf("%s's balance: $%.2f%n", name, account.getBalance()); }
    public String getName() { return name; }
    public BankAccount getAccount() { return account; }
}
