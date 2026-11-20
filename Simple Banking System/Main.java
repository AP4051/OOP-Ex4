public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Customer customer1 = new Customer("Alice", "123456");
        Customer customer2 = new Customer("Bob", "789101");

        // TODO: Wrap customer registration, deposits, withdrawals, and transfers in try-catch-finally blocks
        try {
            bank.addCustomer(customer1);
            bank.addCustomer(customer2);
            Customer customer3 = new Customer("John", "123456");
            bank.addCustomer(customer3);
        }
        catch(DuplicateAccountException e){
            System.out.println(e.getMessage());
        }
        try {
            customer1.withdrawMoney(200);
            customer1.withdrawMoney(1000);

        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        try {
            bank.transfer("123456", "999999", 100);

        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());

        }
        try {
            customer1.withdrawMoney(200);
            customer1.withdrawMoney(1000);

        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());

        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());


        }
        finally {
            {
                System.out.println("Main class tested");
            }
        }
    }
}