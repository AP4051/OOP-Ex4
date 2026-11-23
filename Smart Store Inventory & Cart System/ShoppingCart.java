import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> item = new HashMap<>();


    public void addItem(StoreInventory inventory, String productId, int quantity) {
        if (quantity <= 0) {
            System.out.println("Warning: quantity must be positive.");
            return;
        }

        Product p = inventory.getProduct(productId);
        if (p == null) {
            System.out.println("Warning: unknown product " + productId);
            return;
        }

        int newQuantity = item.getOrDefault(productId, 0) + quantity;

        if (newQuantity > p.getStockQuantity()) {
            System.out.println("Warning: not enough stock for " + p.getName()
                    + " (available: " + p.getStockQuantity() + ")");
            return;
        }

        item.put(productId, newQuantity);
    }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0;
        for (Map.Entry<String, Integer> entry : item.entrySet()) {
            Product p = inventory.getProduct(entry.getKey());
            int qty = entry.getValue();
            if (p != null) {
                total += p.getPrice() * qty;
            }
        }
        return total;
    }

    public void removeItem(String productId) {
        if (item.containsKey(productId)) {
            item.remove(productId);
        } else {
            System.out.println("Warning: " + productId + " is not in the cart.");
        }
    }
    public void checkout(StoreInventory inventory) {
        if (item.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = 0;

        for (Map.Entry<String, Integer> entry : item.entrySet()) {
            Product p = inventory.getProduct(entry.getKey());
            int qty = entry.getValue();

            if (p == null) {
                continue;
            }

            p.decreaseStock(qty);
            double lineTotal = p.getPrice() * qty;
            total += lineTotal;


            System.out.printf("%-18s x%d  $%.2f%n", p.getName(), qty, lineTotal);
        }


        System.out.printf("TOTAL: $%.2f%n", total);

        item.clear();
    }

}

