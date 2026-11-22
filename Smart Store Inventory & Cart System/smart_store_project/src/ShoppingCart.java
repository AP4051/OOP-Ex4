import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> items = new HashMap<>();

    public boolean addItem(StoreInventory inventory, String productId, int quantity){
        if (quantity <= 0){
            System.out.println("Quantity must be positive.");
            return false;
        }
        Product product = inventory.getProduct(productId);
        if (product == null){
            System.out.println("Unknown product: " + productId);
            return false;
        }
        int newQuantity = items.getOrDefault(productId, 0) + quantity;
        if (newQuantity > product.getStockQuantity()){
            System.out.println("Not enough stock for " + product.getName());
            return false;
        }
        items.put(productId, newQuantity);
        return true;
    }

    public boolean removeItem(String productId){
        return items.remove(productId) != null;
    }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            if (product != null) {
                total += product.getPrice() * entry.getValue();
            }
        }
        return total;
    }

    public void checkout(StoreInventory inventory) {
        // Validate the complete cart before changing any stock.
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            if (product == null || product.getStockQuantity() < entry.getValue()) {
                System.out.println("Checkout failed: inventory changed or product is unavailable."); return;
            }
        }
        double receiptTotal = calculateTotal(inventory);
        System.out.println("----- RECEIPT -----");
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            double lineTotal = product.getPrice() * entry.getValue();
            System.out.printf("%s x%d = $%.2f%n", product.getName(), entry.getValue(), lineTotal);
            product.decreaseStock(entry.getValue());
        }
        System.out.printf("TOTAL: $%.2f%n", receiptTotal);
        items.clear();
    }

}
