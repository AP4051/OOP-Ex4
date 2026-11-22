public class Main{
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        inventory.addProduct(new Product("P101", "Wireless Mouse", 25.00, 10));
        inventory.addProduct(new Product("P102", "Keyboard", 45.00, 5));
        inventory.addProduct(new Product("P103", "USB Cable", 8.50, 3));
        inventory.addProduct(new Product("P104", "Monitor", 180.00, 2));
        inventory.addProduct(new Product("P105", "Headphones", 60.00, 8));
        inventory.restockProduct("P103", 2);
        inventory.printCatalog();
        System.out.println("Low-stock products: " + inventory.getLowStockProducts(4));
        System.out.printf("Total inventory value: $%.2f%n", inventory.calculateTotalInventoryValue());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(inventory, "P101", 2);
        cart.addItem(inventory, "P101", 1); // Testing getOrDefault and quantity accumulation.
        cart.addItem(inventory, "P102", 1);
        cart.addItem(inventory, "P104", 5); // More than available stock: should be rejected.
        System.out.printf("Cart total: $%.2f%n", cart.calculateTotal(inventory));
        cart.checkout(inventory);
        inventory.printCatalog();
    }
}