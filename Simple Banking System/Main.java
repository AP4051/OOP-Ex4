
public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();

        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        // 1. Register customers
        try {
            bank.addCustomer(customer1);
            bank.addCustomer(customer2);

            // Duplicate account test
            Customer customer3 = new Customer("John", "123456");
            bank.addCustomer(customer3);

        } catch (DuplicateAccountException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 2. Deposit money
        try {
            customer1.depositMoney(500);
            customer1.checkBalance();

            // Invalid amount test
            customer1.depositMoney(-100);

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 3. Withdraw money
        try {
            customer1.withdrawMoney(200);
            customer1.checkBalance();

            // Insufficient balance test
            customer1.withdrawMoney(1000);

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 4. Transfer money
        try {
            bank.transfer("123456", "999999", 100);

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 5. Successful transfer
        try {
            bank.transfer("123456", "789101", 100);

            customer1.checkBalance();
            customer2.checkBalance();

        } catch (AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }
}
