import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(StoreInventory inventory, String productId, int quantity) {
        Product product = inventory.getProduct(productId);
        if (product == null) {
            System.out.println("Unknown product ID: " + productId);
            return;
        }
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }
        int newQty = items.getOrDefault(productId, 0) + quantity;
        if (newQty > product.getStockQuantity()) {
            System.out.println("Not enough stock for " + product.getName() + ". Requested: " + newQty
                    + ", available: " + product.getStockQuantity());
            return;
        }
        items.put(productId, newQty);
        System.out.println("Added " + quantity + " x " + product.getName() + " to cart (total in cart: " + newQty + ").");
    }

    public void removeItem(String productId) {
        if (items.remove(productId) != null) {
            System.out.println("Removed " + productId + " from cart.");
        } else {
            System.out.println(productId + " is not in the cart.");
        }
    }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product p = inventory.getProduct(entry.getKey());
            if (p != null) {
                total += p.getPrice() * entry.getValue();
            }
        }
        return total;
    }

    public void checkout(StoreInventory inventory) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("=== Receipt ===");
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product p = inventory.getProduct(entry.getKey());
            int qty = entry.getValue();
            double lineTotal = p.getPrice() * qty;
            p.decreaseStock(qty);
            total += lineTotal;
            System.out.printf("%-18s %2d x $%8.2f = $%9.2f%n", p.getName(), qty, p.getPrice(), lineTotal);
        }
        System.out.printf("TOTAL: $%.2f%n", total);
        items.clear();
    }
}
