public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();

        inventory.addProduct(new Product("P101", "Wireless Mouse", 25.50, 10));
        inventory.addProduct(new Product("P102", "Keyboard", 49.99, 5));
        inventory.addProduct(new Product("P103", "Notebook", 3.25, 3));
        inventory.addProduct(new Product("P104", "Pen", 1.50, 2));
        inventory.addProduct(new Product("P105", "USB Cable", 8.00, 0));

        inventory.restockProduct("P103", 10);

        System.out.println("\nLow-stock products:");
        for (Product product : inventory.getLowStockProducts(2)) {
            System.out.println(product);
        }

        System.out.printf("%nInventory value before checkout: $%.2f%n",
                inventory.calculateTotalInventoryValue());

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(inventory, "P101", 2);
        cart.addItem(inventory, "P101", 1);
        cart.addItem(inventory, "P103", 4);
        cart.addItem(inventory, "P104", 1);

        cart.addItem(inventory, "P102", 20);
        cart.addItem(inventory, "P999", 1);

        cart.updateItem(inventory, "P103", 5);

        System.out.printf("%nCart total: $%.2f%n",
                cart.calculateTotal(inventory));

        cart.checkout(inventory);

        System.out.println("\nInventory after checkout:");
        inventory.printCatalog();
    }
}

