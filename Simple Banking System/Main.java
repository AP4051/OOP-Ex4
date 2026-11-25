public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer alice = new Customer("Alice", "123456");
        Customer bob = new Customer("Bob", "789101");
        try {
            bank.addCustomer(alice);
            bank.addCustomer(bob);
            try { bank.addCustomer(new Customer("Another Alice", "123456")); }
            catch (DuplicateAccountException e) { System.out.println("Duplicate account: " + e.getMessage()); }

            alice.depositMoney(500);
            try { alice.depositMoney(-10); }
            catch (InvalidAmountException e) { System.out.println("Invalid deposit: " + e.getMessage()); }
            try { alice.withdrawMoney(700); }
            catch (InsufficientBalanceException e) { System.out.println("Withdrawal rejected: " + e.getMessage()); }
            alice.withdrawMoney(200);
            bank.transfer("123456", "789101", 100);
            try { bank.transfer("123456", "000000", 25); }
            catch (AccountNotFoundException e) { System.out.println("Transfer failed: " + e.getMessage()); }
            alice.checkBalance();
            bob.checkBalance();
        } catch (DuplicateAccountException | InvalidAmountException | InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println("Transaction error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }
}
