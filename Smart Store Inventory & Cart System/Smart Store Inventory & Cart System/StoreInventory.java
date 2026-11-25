import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreInventory {
    private HashMap<String, Product> catalog;

    public StoreInventory() {
        this.catalog = new HashMap<>();
    }

    public void addProduct(Product product) {
        Product existing = catalog.putIfAbsent(product.getProductId(), product);
        if (existing != null) {
            System.out.println("Warning: product ID " + product.getProductId() + " already exists.");
        }
    }

    public void removeProduct(String productId) {
        if (catalog.containsKey(productId)) {
            catalog.remove(productId);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public Product getProduct(String productId) {
        return catalog.get(productId);
    }

    public void restockProduct(String productId, int quantity) {
        Product p = catalog.get(productId);
        if (p == null) {
            System.out.println("Cannot restock. Unknown product: " + productId);
            return;
        }
        p.increaseStock(quantity);
        System.out.println("Restocked " + p.getName() + " with " + quantity + " units.");
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> low = new ArrayList<>();
        for (Product p : catalog.values()) {
            if (p.getStockQuantity() <= threshold) {
                low.add(p);
            }
        }
        return low;
    }

    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Map.Entry<String, Product> entry : catalog.entrySet()) {
            Product p = entry.getValue();
            total += p.getPrice() * p.getStockQuantity();
        }
        return total;
    }

    public void printCatalog() {
        System.out.println("=== Store Catalog ===");
        for (Product p : new java.util.TreeMap<>(catalog).values()) {
            System.out.println(p);
        }
    }
}
