import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final HashMap<String, Integer> items = new HashMap<>();

    public boolean addItem(StoreInventory inventory, String productId, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        Product product = inventory.getProduct(productId);
        if (product == null) { System.out.println("Unknown product: " + productId); return false; }
        int newQuantity = items.getOrDefault(productId, 0) + quantity;
        if (newQuantity > product.getStockQuantity()) { System.out.println("Not enough stock for " + product.getName()); return false; }
        items.put(productId, newQuantity);
        return true;
    }

    public void removeItem(String productId) { items.remove(productId); }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            if (product != null) total += product.getPrice() * entry.getValue();
        }
        return total;
    }

    public void checkout(StoreInventory inventory) {
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            if (product == null || product.getStockQuantity() < entry.getValue()) throw new IllegalStateException("Inventory changed; checkout cannot be completed.");
        }
        double total = calculateTotal(inventory);
        System.out.println("----- Receipt -----");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            double lineTotal = product.getPrice() * entry.getValue();
            System.out.printf("%s x%d = $%.2f%n", product.getName(), entry.getValue(), lineTotal);
            product.decreaseStock(entry.getValue());
        }
        System.out.printf("Total: $%.2f%n", total);
        items.clear();
    }
}
