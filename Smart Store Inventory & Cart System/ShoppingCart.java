import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> items;

    public ShoppingCart() {
        items = new HashMap<String, Integer>();
    }
    public void addItem(StoreInventory inventory, String productId, int quantity) {
        Product product = inventory.getProduct(productId);
        if (product == null) {
            System.out.println("Unknown product ID.");
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        int currentQuantity = items.getOrDefault(productId, 0);
        if (currentQuantity + quantity > product.getStockQuantity()) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }
        items.put(productId, currentQuantity + quantity);
        System.out.println("Added to cart: " + product.getName());
    }
    public void removeItem(String productId) {
        if (items.containsKey(productId)) items.remove(productId);
        else System.out.println("Item is not in the cart.");
    }
    public double calculateTotal(StoreInventory inventory) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            if (product != null) total += product.getPrice() * entry.getValue();
        }
        return total;
    }
    public void checkout(StoreInventory inventory) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        double total = calculateTotal(inventory);
        System.out.println("\nReceipt:");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            if (product != null) {
                int quantity = entry.getValue();
                double subtotal = product.getPrice() * quantity;
                System.out.println(product.getName() + " x " + quantity + " = $" + subtotal);
                product.decreaseStock(quantity);
            }
        }
        System.out.println("Total: $" + total);
        items.clear();
    }
}
