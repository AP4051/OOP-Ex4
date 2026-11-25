
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(StoreInventory inventory,
                        String productId, int quantity) {

        Product product = inventory.getProduct(productId);

        if (product == null) {
            System.out.println("Product not found!");
            return;
        }

        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        int currentQuantity = items.getOrDefault(productId, 0);

        if (currentQuantity + quantity <= product.getStockQuantity()) {
            items.put(productId, currentQuantity + quantity);
            System.out.println("Item added to cart: " + product.getName());
        } else {
            System.out.println("Not enough stock!");
        }
    }

    public void removeItem(String productId) {
        if (items.containsKey(productId)) {
            items.remove(productId);
            System.out.println("Item removed from cart.");
        } else {
            System.out.println("Item not found in cart!");
        }
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
        if (items.isEmpty()) {
            System.out.println("Cart is empty!");
            return;
        }

        // Check all items before changing inventory
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());

            if (product == null ||
                    entry.getValue() > product.getStockQuantity()) {
                System.out.println("Checkout failed: Stock unavailable!");
                return;
            }
        }

        System.out.println("\n========== RECEIPT ==========");

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            int quantity = entry.getValue();

            double subtotal = product.getPrice() * quantity;

            System.out.println(product.getName()
                    + " x " + quantity
                    + " = $" + subtotal);

            product.decreaseStock(quantity);

            inventory.recordSale(product.getProductId(), quantity);
        }

        System.out.println("-----------------------------");
        System.out.println("Total: $" + calculateTotal(inventory));
        System.out.println("Checkout successful!");

        items.clear();
    }
}
