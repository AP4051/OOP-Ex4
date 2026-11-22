public class Customer {
    private String name;
    private BankAccount bankAccount;

    public Customer(String name, String accountNumber) {
        this.name = name;
        this.bankAccount = new BankAccount(accountNumber);
    }

    public void depositMoney(double amount) throws InvalidAmountException {
        bankAccount.deposit(amount);
    }
    public void withdrawMoney(double amount) throws InvalidAmountException, InsufficientBalanceException {
        bankAccount.withdraw(amount);
    }
    public void checkBalance() {
        System.out.printf("%s's balance: $%.2f%n", name, bankAccount.getBalance());
    }
    public String getName() {
        return name;
    }
    public BankAccount getAccount() {
        return bankAccount;
    }

}
