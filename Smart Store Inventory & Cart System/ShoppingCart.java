import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(StoreInventory inventory, String productId, int quantity) {
        Product p = inventory.getProduct(productId);
        if (p == null) {
            System.out.println("Product ID " + productId + " does not exist!");
            return;
        }

        int currentInCart = items.getOrDefault(productId, 0);
        int newTotalQty = currentInCart + quantity;

        if (newTotalQty > p.getStockQuantity()) {
            System.out.println("Not enough stock for " + p.getName() + "! Available: " + p.getStockQuantity());
            return;
        }

        items.put(productId, newTotalQty);
        System.out.println("Added " + quantity + " x " + p.getName() + " to cart.");
    }

    public void removeItem(String productId) {
        if (items.containsKey(productId)) {
            items.remove(productId);
            System.out.println("Removed " + productId + " from cart.");
        }
    }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0.0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String id = entry.getKey();
            int qty = entry.getValue();
            Product p = inventory.getProduct(id);
            if (p != null) {
                total = total + (p.getPrice() * qty);
            }
        }
        return total;
    }

    public void checkout(StoreInventory inventory) {
        System.out.println("\n=== Receipt ===");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String id = entry.getKey();
            int qty = entry.getValue();
            Product p = inventory.getProduct(id);

            if (p != null) {
                double itemCost = p.getPrice() * qty;
                System.out.println(p.getName() + " x" + qty + " = $" + itemCost);
                p.decreaseStock(qty);
            }
        }
        System.out.println("Total Paid: $" + calculateTotal(inventory));
        System.out.println("===============\n");
        items.clear();
    }
}