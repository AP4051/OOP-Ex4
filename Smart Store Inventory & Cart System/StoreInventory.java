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
            System.out.println("Warning: Product ID " + product.getProductId() + " already exists!");
        }
    }

    public void removeProduct(String productId) {
        if (catalog.containsKey(productId)) {
            catalog.remove(productId);
            System.out.println("Removed product: " + productId);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public Product getProduct(String productId) {
        return catalog.get(productId);
    }

    public void restockProduct(String productId, int quantity) {
        Product p = catalog.get(productId);
        if (p != null) {
            p.increaseStock(quantity);
            System.out.println("Restocked " + p.getName() + " by " + quantity);
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStockList = new ArrayList<>();
        for (Product p : catalog.values()) {
            if (p.getStockQuantity() <= threshold) {
                lowStockList.add(p);
            }
        }
        return lowStockList;
    }

    public double calculateTotalInventoryValue() {
        double totalValue = 0.0;
        for (Map.Entry<String, Product> entry : catalog.entrySet()) {
            Product p = entry.getValue();
            totalValue = totalValue + (p.getPrice() * p.getStockQuantity());
        }
        return totalValue;
    }

    public void printCatalog() {
        System.out.println("=== Store Catalog ===");
        for (Product p : catalog.values()) {
            System.out.println(p);
        }
        System.out.println("=====================");
    }
}