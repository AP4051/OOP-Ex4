public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        inventory.addProduct(new Product("P101", "Wireless Mouse", 25, 10));
        inventory.addProduct(new Product("P102", "Keyboard", 45, 5));
        inventory.addProduct(new Product("P103", "USB Cable", 8, 3));
        inventory.addProduct(new Product("P104", "Headphones", 60, 7));
        inventory.addProduct(new Product("P105", "Laptop Stand", 30, 2));

        inventory.restockProduct("P103", 4);
        inventory.printCatalog();
        System.out.println("\nLow stock products:");
        System.out.println(inventory.getLowStockProducts(5));
        System.out.println("Total inventory value: $" +
                inventory.calculateTotalInventoryValue());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(inventory, "P101", 2);
        cart.addItem(inventory, "P101", 1); // Add same product again
        cart.addItem(inventory, "P103", 2);
        cart.addItem(inventory, "P105", 10); // More than stock
        System.out.println("Cart total: $" + cart.calculateTotal(inventory));

        cart.checkout(inventory);
        inventory.printCatalog();
    }
}
