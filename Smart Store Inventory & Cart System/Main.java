public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        inventory.addProduct(new Product("P101", "Wireless Mouse", 24.99, 10));
        inventory.addProduct(new Product("P102", "Keyboard", 49.50, 5));
        inventory.addProduct(new Product("P103", "USB Hub", 15.00, 3));
        inventory.addProduct(new Product("P104", "Monitor", 179.99, 2));
        inventory.addProduct(new Product("P105", "Webcam", 59.99, 8));

        inventory.restockProduct("P103", 2);
        System.out.println("Low-stock products: " + inventory.getLowStockProducts(4));
        System.out.printf("Inventory value: $%.2f%n", inventory.calculateTotalInventoryValue());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(inventory, "P101", 2);
        cart.addItem(inventory, "P101", 1); // Tests getOrDefault for an existing cart entry.
        cart.addItem(inventory, "P102", 1);
        cart.addItem(inventory, "P104", 10); // Tests insufficient stock.
        System.out.printf("Cart total: $%.2f%n", cart.calculateTotal(inventory));
        cart.checkout(inventory);
        System.out.println("Inventory after checkout:");
        inventory.printCatalog();
    }
}
