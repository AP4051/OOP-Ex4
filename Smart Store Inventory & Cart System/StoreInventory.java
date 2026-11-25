import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreInventory {
    private final HashMap<String, Product> catalog = new HashMap<>();

    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        if (catalog.putIfAbsent(product.getProductId(), product) != null) System.out.println("Product ID already exists: " + product.getProductId());
    }

    public boolean removeProduct(String productId) { return catalog.containsKey(productId) && catalog.remove(productId) != null; }
    public Product getProduct(String productId) { return catalog.get(productId); }

    public void restockProduct(String productId, int quantity) {
        Product product = catalog.get(productId);
        if (product == null) throw new IllegalArgumentException("Unknown product: " + productId);
        product.increaseStock(quantity);
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStock = new ArrayList<>();
        for (Product product : catalog.values()) if (product.getStockQuantity() <= threshold) lowStock.add(product);
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
        if (catalog.isEmpty()) { System.out.println("Catalog is empty."); return; }
        for (Product product : catalog.values()) System.out.println(product);
    }
}
