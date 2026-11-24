import java.util.*;
public class ShoppingCart {
 private HashMap<String,Integer> items=new HashMap<>();
 public void addItem(StoreInventory store,String id,int qty){Product p=store.getProduct(id);if(qty<=0||p==null||items.getOrDefault(id,0)+qty>p.getStockQuantity()){System.out.println("Cannot add item: "+id);return;}items.put(id,items.getOrDefault(id,0)+qty);}
 public void removeItem(String id){items.remove(id);}
 public double calculateTotal(StoreInventory store){double total=0;for(Map.Entry<String,Integer> e:items.entrySet()){Product p=store.getProduct(e.getKey());if(p!=null)total+=p.getPrice()*e.getValue();}return total;}
 public void checkout(StoreInventory store){for(Map.Entry<String,Integer> e:items.entrySet()){Product p=store.getProduct(e.getKey());if(p==null||p.getStockQuantity()<e.getValue()){System.out.println("Checkout failed");return;}}
  for(Map.Entry<String,Integer> e:items.entrySet()){Product p=store.getProduct(e.getKey());System.out.println(p.getName()+" x"+e.getValue()+" = $"+(p.getPrice()*e.getValue()));p.decreaseStock(e.getValue());}items.clear();System.out.println("Checkout completed");}
}
