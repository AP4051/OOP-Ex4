import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<String, Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(StoreInventory inventory, String productId, int quantity) {
        Product product = inventory.getProduct(productId);

        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }

        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        int currentQuantity = items.getOrDefault(productId, 0);

        if (quantity > product.getStockQuantity() - currentQuantity) {
            System.out.println("Not enough stock for: " + product.getName());
            return;
        }

        items.put(productId, currentQuantity + quantity);
        System.out.println("Added to cart: " + product.getName()
                + " x" + quantity);
    }

    public void updateItem(StoreInventory inventory, String productId, int quantity) {
        Product product = inventory.getProduct(productId);

        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }

        if (quantity < 0 || quantity > product.getStockQuantity()) {
            System.out.println("Invalid quantity for: " + product.getName());
            return;
        }

        if (quantity == 0) {
            removeItem(productId);
            return;
        }

        items.put(productId, quantity);
        System.out.println("Updated cart: " + product.getName()
                + " x" + quantity);
    }

    public void removeItem(String productId) {
        if (items.remove(productId) != null) {
            System.out.println("Removed from cart: " + productId);
        } else {
            System.out.println("Item not in cart: " + productId);
        }
    }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0;

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());

            if (product == null) {
                throw new IllegalStateException(
                        "Product no longer exists: " + entry.getKey()
                );
            }

            total += product.getPrice() * entry.getValue();
        }

        return total;
    }

    public void checkout(StoreInventory inventory) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());

            if (product == null) {
                System.out.println("Checkout failed. Product not found: "
                        + entry.getKey());
                return;
            }

            if (entry.getValue() > product.getStockQuantity()) {
                System.out.println("Checkout failed. Not enough stock for: "
                        + product.getName());
                return;
            }
        }

        double total = calculateTotal(inventory);

        System.out.println("\nReceipt:");

        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            Product product = inventory.getProduct(entry.getKey());
            int quantity = entry.getValue();
            double lineTotal = product.getPrice() * quantity;

            System.out.printf("%s x%d = $%.2f%n",
                    product.getName(), quantity, lineTotal);

            product.decreaseStock(quantity);
        }

        System.out.printf("Total: $%.2f%n", total);
        items.clear();
    }
}
