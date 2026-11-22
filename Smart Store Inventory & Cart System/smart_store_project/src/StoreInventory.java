import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StoreInventory {
    private HashMap<String, Product> catalog;

    public StoreInventory(){
        catalog = new HashMap<>();
    }

    public void addProduct(Product product){
        if (product == null){
            throw new IllegalArgumentException("Product cannot be null");
        }
        Product previous = catalog.putIfAbsent(product.getProductId(), product);
        if (previous != null){
            System.out.println("Warning: Product already exists: " + product.getProductId());
        }
    }

    public boolean removeProduct(String productId){
        if (!(catalog.containsKey(productId))){
            return false;
        }
        catalog.remove(productId);
        return true;
    }

    public Product getProduct(String productId){
        return catalog.get(productId);
    }

    public boolean restockProduct(String productId, int quantity){
        Product product = getProduct(productId);
        if (product == null){
            return false;
        }
        product.increaseStock(quantity);
        return true;
    }
    public List<Product> getLowStockProducts(int threshold){
        List<Product> low = new ArrayList<>();
        for (Product product : catalog.values()){
            if (product.getStockQuantity() < threshold){
                low.add(product);
            }
        }
        return low;

    }

    public double calculateTotalInventoryValue(){
        double total = 0.00;
        for (Map.Entry<String, Product> entry : catalog.entrySet()){
            Product p = entry.getValue();
            total += p.getPrice() * p.getStockQuantity();
        }
        return total;
    }

    public void printCatalog(){
        System.out.println("Store catalog:");
        for (Product p : catalog.values()){
            System.out.println(" " + p);
        }
    }


}
