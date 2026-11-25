
public class Main {
    public static void main(String[] args) {

        StoreInventory inventory = new StoreInventory();

        // Add products
        Product p1 = new Product("P101", "Wireless Mouse", 25, 10);
        Product p2 = new Product("P102", "Keyboard", 45, 5);
        Product p3 = new Product("P103", "Monitor", 200, 3);
        Product p4 = new Product("P104", "Notebook", 5, 20);
        Product p5 = new Product("P105", "USB Cable", 10, 2);

        inventory.addProduct(p1, "Electronics");
        inventory.addProduct(p2, "Electronics");
        inventory.addProduct(p3, "Electronics");
        inventory.addProduct(p4, "Stationery");
        inventory.addProduct(p5, "Electronics");

        // Test duplicate product
        inventory.addProduct(p1, "Electronics");

        // Restock product
        System.out.println("\n--- Restock ---");
        inventory.restockProduct("P105", 5);

        // Display catalog
        inventory.printCatalog();

        // Low stock products
        System.out.println("\n--- Low Stock Products ---");

        for (Product product : inventory.getLowStockProducts(5)) {
            System.out.println(product);
        }

        // Total inventory value
        System.out.println("\nTotal Inventory Value: $"
                + inventory.calculateTotalInventoryValue());

        // BONUS 1: Search by category
        System.out.println("\n--- Electronics Category ---");

        for (Product product :
                inventory.getProductsByCategory("Electronics")) {
            System.out.println(product);
        }

        // Create shopping cart
        ShoppingCart cart = new ShoppingCart();

        System.out.println("\n--- Shopping Cart ---");

        cart.addItem(inventory, "P101", 2);
        cart.addItem(inventory, "P101", 1);
        cart.addItem(inventory, "P102", 2);
        cart.addItem(inventory, "P103", 5);
        cart.addItem(inventory, "P999", 1);

        System.out.println("\nCart Total: $"
                + cart.calculateTotal(inventory));

        // Checkout
        cart.checkout(inventory);

        // Updated inventory
        inventory.printCatalog();

        // BONUS 2: Best-selling product
        System.out.println("\n--- Best Selling Product ---");

        Product bestSeller = inventory.getBestSellingProduct();

        if (bestSeller != null) {
            System.out.println(bestSeller.getName());
        } else {
            System.out.println("No sales yet.");
        }

        // Check cart after checkout
        System.out.println("\nCart Total After Checkout: $"
                + cart.calculateTotal(inventory));
    }
}
