public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        try {
            bank.addCustomer(customer1);
            bank.addCustomer(customer2);

            customer1.depositMoney(500);
            customer1.withdrawMoney(200);
            customer1.checkBalance();

            bank.transfer("123456", "789101", 100);
            customer2.checkBalance();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        try {
            Customer duplicate = new Customer("Charlie", "123456");
            bank.addCustomer(duplicate);
        } catch (DuplicateAccountException e) {
            System.out.println("Caught DuplicateAccountException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        try {
            customer1.depositMoney(-50);
        } catch (InvalidAmountException e) {
            System.out.println("Caught InvalidAmountException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        try {
            customer1.withdrawMoney(5000);
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Caught InsufficientBalanceException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        try {
            bank.transfer("123456", "999999", 50);
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println("Caught AccountNotFoundException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }
}