public class Main {
 public static void main(String[] args){
  StoreInventory store=new StoreInventory();
  store.addProduct(new Product("P1","Mouse",10,5));store.addProduct(new Product("P2","Keyboard",20,3));store.addProduct(new Product("P3","Pen",2,10));store.addProduct(new Product("P4","Book",8,2));store.addProduct(new Product("P5","Bag",30,1));
  store.restockProduct("P5",2);System.out.println("Low stock: "+store.getLowStockProducts(3));System.out.println("Inventory value: "+store.calculateTotalInventoryValue());
  ShoppingCart cart=new ShoppingCart();cart.addItem(store,"P1",2);cart.addItem(store,"P1",1);cart.addItem(store,"P2",2);cart.addItem(store,"P5",100);
  System.out.println("Cart total: "+cart.calculateTotal(store));cart.checkout(store);store.printCatalog();
 }
}
