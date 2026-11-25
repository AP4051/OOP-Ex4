import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String,Integer> items;

    public ShoppingCart() {
        items = new HashMap<>();
    }

    public void addItem(StoreInventory inventory,String productId,int quantity) {
        Product product = inventory.getProduct(productId);
        if (product == null) {
            System.out.println("Unknown product ID.");
            return;
        }
        int currentQuantity = items.getOrDefault(productId,0);
        if (quantity <= 0 || currentQuantity + quantity > product.getStockQuantity()) {
            System.out.println("Not enough stock or invalid quantity.");
            return;
        }
        items.put(productId,currentQuantity + quantity);
        System.out.println("Added to cart : " + product.getName());
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public double calculateTotal(StoreInventory inventory) {
        double total = 0;
        for (String id : items.keySet()) {
            Product product = inventory.getProduct(id);
            if (product != null)
                total += product.getPrice() * items.get(id);
        }
        return total;
    }

    public void checkout(StoreInventory inventory) {
        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\nReceipt :");
        for (String id : items.keySet()) {
            Product product = inventory.getProduct(id);
            int quantity = items.get(id);
            if (product == null || quantity > product.getStockQuantity()) {
                System.out.println("Checkout cancelled : stock changed.");
                return;
            }
        }
        for (String id : items.keySet()) {
            Product product = inventory.getProduct(id);
            int quantity = items.get(id);
            product.decreaseStock(quantity);
            System.out.println(product.getName() + " x " + quantity + " = $" + String.format("%.2f",product.getPrice() * quantity));
        }
        System.out.println("Total : $" + String.format("%.2f",calculateTotal(inventory)));
        items.clear();
    }
}