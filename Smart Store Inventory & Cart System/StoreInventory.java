import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

public class StoreInventory {
    private HashMap <String,Product> catalog;
    public StoreInventory(){
        catalog = new HashMap<>();
    }

    public void addProduct(Product product){
        Product existing = catalog.putIfAbsent(product.getProductId(), product);
        if (existing != null) {
            System.out.println("Warning: product " + product.getProductId() + " already exists.");
        }
    }

    public void removeProduct(String productId){
        if(catalog.containsKey(productId)){
            catalog.remove(productId);
        }
    }

    public Product getProduct(String productId){
        return catalog.get(productId);
    }

    public void restockProduct(String productId , int quantity){
        Product p = catalog.get(productId);
        if(p ==null){
            System.out.println("product" + productId + "not found!");
        }
        p.increaseStock(quantity);
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> result = new ArrayList<>();
        for (Product p : catalog.values()) {
            if (p.getStockQuantity() <= threshold) {
                result.add(p);
            }
        }
        return result;
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
        if (catalog.isEmpty()) {
            System.out.println("Catalog is empty.");
            return;
        }
        for (Product p : catalog.values()) {
            System.out.println(p);
        }
    }

}
