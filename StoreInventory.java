import java.util.*;
public class StoreInventory {
 private HashMap<String,Product> catalog=new HashMap<>();
 public void addProduct(Product p){if(catalog.putIfAbsent(p.getProductId(),p)!=null)System.out.println("Product already exists");}
 public void removeProduct(String id){if(catalog.containsKey(id))catalog.remove(id);}
 public Product getProduct(String id){return catalog.get(id);}
 public void restockProduct(String id,int qty){Product p=getProduct(id);if(p!=null)p.increaseStock(qty);}
 public List<Product> getLowStockProducts(int limit){List<Product> result=new ArrayList<>();for(Product p:catalog.values())if(p.getStockQuantity()<=limit)result.add(p);return result;}
 public double calculateTotalInventoryValue(){double total=0;for(Map.Entry<String,Product> e:catalog.entrySet()){Product p=e.getValue();total+=p.getPrice()*p.getStockQuantity();}return total;}
 public void printCatalog(){for(Product p:catalog.values())System.out.println(p);}
}
