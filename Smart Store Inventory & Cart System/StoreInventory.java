
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreInventory {
    private HashMap<String, Product> catalog;
    private HashMap<String, List<Product>> categoryIndex;

    // BONUS: Track total units sold for each product
    private HashMap<String, Integer> salesHistory;

    public StoreInventory() {
        catalog = new HashMap<>();
        categoryIndex = new HashMap<>();
        salesHistory = new HashMap<>();
    }

    public void addProduct(Product product) {
        addProduct(product, "General");
    }

    // Add product with category
    public void addProduct(Product product, String category) {
        if (catalog.putIfAbsent(product.getProductId(), product) == null) {
            categoryIndex.putIfAbsent(category, new ArrayList<>());
            categoryIndex.get(category).add(product);

            salesHistory.putIfAbsent(product.getProductId(), 0);

            System.out.println("Product added: " + product.getName());
        } else {
            System.out.println("Product ID already exists!");
        }
    }

    public void removeProduct(String productId) {
        if (catalog.containsKey(productId)) {
            Product product = catalog.remove(productId);

            for (List<Product> products : categoryIndex.values()) {
                products.remove(product);
            }

            System.out.println("Product removed.");
        } else {
            System.out.println("Product not found!");
        }
    }

    public Product getProduct(String productId) {
        return catalog.get(productId);
    }

    public void restockProduct(String productId, int quantity) {
        Product product = getProduct(productId);

        if (product != null && quantity > 0) {
            product.increaseStock(quantity);
            System.out.println("Stock updated.");
        } else {
            System.out.println("Invalid product or quantity!");
        }
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> result = new ArrayList<>();

        for (Product product : catalog.values()) {
            if (product.getStockQuantity() <= threshold) {
                result.add(product);
            }
        }

        return result;
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
        System.out.println("\n--- Store Catalog ---");

        for (Product product : catalog.values()) {
            System.out.println(product);
        }
    }

    // BONUS 1: Find products by category
    public List<Product> getProductsByCategory(String category) {
        return new ArrayList<>(
                categoryIndex.getOrDefault(category, new ArrayList<>())
        );
    }

    // BONUS 2: Update sales history
    public void recordSale(String productId, int quantity) {
        salesHistory.put(
                productId,
                salesHistory.getOrDefault(productId, 0) + quantity
        );
    }

    // BONUS 2: Find best-selling product
    public Product getBestSellingProduct() {
        String bestId = null;
        int highestSales = 0;

        for (Map.Entry<String, Integer> entry : salesHistory.entrySet()) {
            if (entry.getValue() > highestSales) {
                highestSales = entry.getValue();
                bestId = entry.getKey();
            }
        }

        if (bestId == null) {
            return null;
        }

        return catalog.get(bestId);
    }
}
