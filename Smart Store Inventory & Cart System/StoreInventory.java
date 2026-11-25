import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StoreInventory {
    private HashMap<String, Product> catalog;

    public StoreInventory() {
        catalog = new HashMap<String, Product>();
    }
    public void addProduct(Product product) {
        if (catalog.putIfAbsent(product.getProductId(), product) != null)
            System.out.println("Product ID already exists: " + product.getProductId());
    }
    public void removeProduct(String productId) {
        if (catalog.containsKey(productId)) catalog.remove(productId);
        else System.out.println("Product not found.");
    }
    public Product getProduct(String productId) {
        return catalog.get(productId);
    }
    public void restockProduct(String productId, int quantity) {
        Product product = catalog.get(productId);
        if (product == null) System.out.println("Product not found.");
        else if (quantity <= 0) System.out.println("Quantity must be positive.");
        else product.increaseStock(quantity);
    }
    public List<Product> getLowStockProducts(int threshold) {
        ArrayList<Product> result = new ArrayList<Product>();
        for (Product product : catalog.values()) {
            if (product.getStockQuantity() <= threshold) result.add(product);
        }
        return result;
    }
    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Product product : catalog.values())
            total += product.getPrice() * product.getStockQuantity();
        return total;
    }
    public void printCatalog() {
        System.out.println("\nStore inventory:");
        for (Product product : catalog.values()) System.out.println(product);
    }
}
