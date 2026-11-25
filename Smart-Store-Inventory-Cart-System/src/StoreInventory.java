import java.util.HashMap;
import java.util.ArrayList;

public class StoreInventory {

    private HashMap<String,Product> catalog;

    public StoreInventory() {
        catalog = new HashMap<>();
    }

    public void addProduct(Product product) {
        if (catalog.putIfAbsent(product.getProductId(),product) == null)
            System.out.println("Product added : " + product.getName());
        else
            System.out.println("Product ID already exists.");
    }

    public void removeProduct(String productId) {
        if (catalog.containsKey(productId))
            catalog.remove(productId);
        else
            System.out.println("Product was not found.");
    }

    public Product getProduct(String productId) {
        return catalog.get(productId);
    }

    public void restockProduct(String productId,int quantity) {
        Product product = catalog.get(productId);
        if (product != null && quantity > 0)
            product.increaseStock(quantity);
        else
            System.out.println("Cannot restock product.");
    }

    public ArrayList<Product> getLowStockProducts(int threshold) {
        ArrayList<Product> result = new ArrayList<>();
        for (Product product : catalog.values()) {
            if (product.getStockQuantity() <= threshold)
                result.add(product);
        }
        return result;
    }

    public double calculateTotalInventoryValue() {
        double total = 0;
        for (Product product : catalog.values()) {
            total += product.getPrice() * product.getStockQuantity();
        }
        return total;
    }

    public void printCatalog() {
        System.out.println("\nStore catalog :");
        for (Product product : catalog.values()) {
            System.out.println(product);
        }
    }
}