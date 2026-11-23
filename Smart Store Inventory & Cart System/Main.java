import java.util.List;

public class Main{
    public static void main(String[] args) {

        StoreInventory inventory = new StoreInventory();
        inventory.addProduct(new Product("P101", "Wireless Mouse", 25.99, 40));
        inventory.addProduct(new Product("P102", "Keyboard",       45.50, 3));
        inventory.addProduct(new Product("P103", "Monitor",       180.00, 8));
        inventory.addProduct(new Product("P104", "USB Cable",       5.25, 100));
        inventory.addProduct(new Product("P105", "Notebook",        2.50, 2));
        inventory.addProduct(new Product("P101", "Duplicate",       1.00, 1));  // هشدار تکراری

        System.out.println("catalog:");
        inventory.printCatalog();


        System.out.println("\n");
        inventory.restockProduct("P102", 10);
        inventory.restockProduct("P999", 5);

    System.out.println("\n");
        List<Product> low = inventory.getLowStockProducts(5);
        for (Product p : low) {
            System.out.println(p);
        }

        System.out.printf("%nTotal inventory value: $%.2f%n",
                inventory.calculateTotalInventoryValue());


        System.out.println("\n");
        ShoppingCart cart = new ShoppingCart();

        cart.addItem(inventory, "P101", 5);
        cart.addItem(inventory, "P101", 3);
        cart.addItem(inventory, "P103", 2);
        cart.addItem(inventory, "P105", 5);
        cart.addItem(inventory, "P777", 1);

        System.out.printf("Cart total: $%.2f%n", cart.calculateTotal(inventory));

        System.out.println();
        cart.checkout(inventory);

        System.out.println("\n");
        inventory.printCatalog();
    }
}