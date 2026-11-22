import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreInventory {
    private HashMap<String, Product> catalog;

    public StoreInventory() {
        catalog = new HashMap<>();
    }

    public void addProduct(Product product) {
        Product existing = catalog.putIfAbsent(
                product.getProductId(), product
        );

        if (existing != null) {
            System.out.println("Product ID already exists: " + product.getProductId());
        } else {
            System.out.println("Added product: " + product.getName());
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
        Product product = catalog.get(productId);

        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }

        if (quantity <= 0) {
            System.out.println("Restock quantity must be positive.");
            return;
        }

        product.increaseStock(quantity);
        System.out.println("Restocked " + product.getName() + " by " + quantity);
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();

        for (Product product : catalog.values()) {
            if (product.getStockQuantity() <= threshold) {
                lowStock.add(product);
            }
        }

        return lowStock;
    }

    public double calculateTotalInventoryValue() {
        double total = 0;

        for (Map.Entry<String, Product> entry : catalog.entrySet()) {
            Product product = entry.getValue();
            total += product.getPrice() * product.getStockQuantity();
        }

        return total;
    }

    public void printCatalog() {
        System.out.println("Store catalog:");

        for (String productId : catalog.keySet()) {
            System.out.println(catalog.get(productId));
        }
    }
}

