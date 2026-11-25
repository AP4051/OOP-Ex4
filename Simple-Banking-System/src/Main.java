public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        Customer alice = new Customer("Alice","123456");
        Customer bob = new Customer("Bob","789101");

        try {
            bank.addCustomer(alice);
            bank.addCustomer(bob);
            bank.addCustomer(new Customer("Another Alice","123456"));
        } catch (DuplicateAccountException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            System.out.println("Customer registration attempt completed.");
        }

        try {
            alice.depositMoney(500);
            alice.withdrawMoney(200);
            alice.checkBalance();
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Transaction error : " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            alice.depositMoney(0);
        } catch (InvalidAmountException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            alice.withdrawMoney(1000);
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Error : " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            bank.transfer("123456","000000",50);
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Transfer error : " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            bank.transfer("123456","789101",100);
            alice.checkBalance();
            bob.checkBalance();
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Transfer error : " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
        
    }
}