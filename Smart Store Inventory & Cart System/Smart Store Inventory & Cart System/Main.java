import java.util.List;

public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        inventory.addProduct(new Product("P101", "Wireless Mouse", 25.99, 10));
        inventory.addProduct(new Product("P102", "Keyboard", 49.50, 4));
        inventory.addProduct(new Product("P103", "USB-C Cable", 9.99, 2));
        inventory.addProduct(new Product("P104", "Notebook", 3.75, 50));
        inventory.addProduct(new Product("P105", "Pen Pack", 5.25, 1));
        inventory.addProduct(new Product("P101", "Duplicate Mouse", 1.0, 1)); // warning

        inventory.printCatalog();

        System.out.println();
        inventory.restockProduct("P105", 9);
        inventory.restockProduct("P999", 5);

        System.out.println("\nLow-stock products (<= 5):");
        List<Product> low = inventory.getLowStockProducts(5);
        for (Product p : low) {
            System.out.println("  " + p);
        }

        System.out.printf("%nTotal inventory value: $%.2f%n%n", inventory.calculateTotalInventoryValue());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(inventory, "P101", 2);
        cart.addItem(inventory, "P101", 3);   // same item again (getOrDefault)
        cart.addItem(inventory, "P102", 1);
        cart.addItem(inventory, "P103", 5);   // more than available
        cart.addItem(inventory, "P777", 1);   // unknown product
        cart.addItem(inventory, "P104", 10);
        cart.removeItem("P104");

        System.out.printf("%nCart total: $%.2f%n%n", cart.calculateTotal(inventory));
        cart.checkout(inventory);

        System.out.println();
        inventory.printCatalog();
    }
}
