public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        // Normal operations
        try {
            bank.addCustomer(customer1);
            bank.addCustomer(customer2);
            customer1.depositMoney(500);
            customer1.withdrawMoney(200);
            customer1.checkBalance();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 1. Duplicate account
        try {
            bank.addCustomer(new Customer("Charlie", "123456"));
        } catch (DuplicateAccountException e) {
            System.out.println("DuplicateAccountException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 2. Invalid amount (negative and zero)
        try {
            customer1.depositMoney(-50);
        } catch (InvalidAmountException e) {
            System.out.println("InvalidAmountException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }
        try {
            customer1.depositMoney(0);
        } catch (InvalidAmountException e) {
            System.out.println("InvalidAmountException: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 3. Insufficient balance
        try {
            customer1.withdrawMoney(10000);
        } catch (InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // 4. Transfer to non-existent account
        try {
            bank.transfer("123456", "000000", 50);
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.\n");
        }

        // Successful transfer
        try {
            bank.transfer("123456", "789101", 100);
            customer1.checkBalance();
            customer2.checkBalance();
        } catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }
    }
}
