public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        try {
            bank.addCustomer(customer1);
            bank.addCustomer(customer2);
        } catch (DuplicateAccountException e) {
            System.out.println("Registration error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            bank.addCustomer(new Customer("Another Alice", "123456"));
        } catch (DuplicateAccountException e) {
            System.out.println("Registration error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            customer1.depositMoney(500);
        } catch (InvalidAmountException e) {
            System.out.println("Deposit error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            customer1.depositMoney(0);
        } catch (InvalidAmountException e) {
            System.out.println("Deposit error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            customer1.withdrawMoney(700);
        } catch (InvalidAmountException e) {
            System.out.println("Withdrawal error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Withdrawal error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            bank.transfer("123456", "000000", 100);
        } catch (AccountNotFoundException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        try {
            bank.transfer("123456", "789101", 200);
        } catch (AccountNotFoundException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } catch (InvalidAmountException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Transfer error: " + e.getMessage());
        } finally {
            System.out.println("Transaction attempt completed.");
        }

        customer1.checkBalance();
        customer2.checkBalance();
    }
}

