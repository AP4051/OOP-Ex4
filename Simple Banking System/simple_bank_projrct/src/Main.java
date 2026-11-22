public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer amir = new Customer("Amir", "123456");
        Customer parsa = new Customer("Parsa", "789101");
        try { bank.addCustomer(amir); bank.addCustomer(parsa); }
        catch (DuplicateAccountException e) { System.out.println("Registration error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }

        // Attempt to add a duplicate account
        try { bank.addCustomer(new Customer("Ali", "123456")); }
        catch (DuplicateAccountException e) { System.out.println("Registration error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }

        try { amir.depositMoney(500); }
        catch (InvalidAmountException e) { System.out.println("Deposit error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }

        // Attempt to deposit invalid amount
        try { amir.depositMoney(0); }
        catch (InvalidAmountException e) { System.out.println("Deposit error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }

        // Attempt to withdraw more than balance
        try { amir.withdrawMoney(700); }
        catch (InvalidAmountException | InsufficientBalanceException e) { System.out.println("Withdrawal error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }

        // Attempt to deposit to a non-existing account
        try { bank.transfer("123456", "000000", 100); }
        catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) { System.out.println("Transfer error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }

        try { bank.transfer("123456", "789101", 150); }
        catch (AccountNotFoundException | InvalidAmountException | InsufficientBalanceException e) { System.out.println("Transfer error: " + e.getMessage()); }
        finally { System.out.println("Transaction attempt completed."); }


        amir.checkBalance();
        parsa.checkBalance();
    }
}