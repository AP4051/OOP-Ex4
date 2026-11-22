import java.util.List;

public class Main {
    public static void main(String[] args) {
        StoreInventory store = new StoreInventory();

        store.addProduct(new Product("P101", "Wireless Mouse", 25.0, 10));
        store.addProduct(new Product("P102", "Mechanical Keyboard", 80.0, 5));
        store.addProduct(new Product("P103", "USB-C Cable", 10.0, 20));
        store.addProduct(new Product("P104", "Monitor Stand", 45.0, 2));
        store.addProduct(new Product("P105", "Webcam HD", 60.0, 3));

        store.printCatalog();

        store.restockProduct("P104", 3);

        System.out.println("\nLow Stock Products (<= 5):");
        List<Product> lowStock = store.getLowStockProducts(5);
        for (int i = 0; i < lowStock.size(); i++) {
            System.out.println(" - " + lowStock.get(i));
        }

        System.out.println("\nTotal Inventory Value: $" + store.calculateTotalInventoryValue());

        ShoppingCart cart = new ShoppingCart();
        System.out.println("\n--- Shopping ---");
        cart.addItem(store, "P101", 2);
        cart.addItem(store, "P101", 1);
        cart.addItem(store, "P102", 2);

        cart.addItem(store, "P105", 10);

        cart.checkout(store);

        System.out.println("Updated Inventory after Checkout:");
        store.printCatalog();
    }
}