public class Main {
    public static void main(String[] args) {
        StoreInventory inventory = new StoreInventory();
        inventory.addProduct(new Product("P1","Mouse",15.0,10));
        inventory.addProduct(new Product("P2","Keyboard",25.0,5));
        inventory.addProduct(new Product("P3","USB",5.0,20));
        inventory.addProduct(new Product("P4","Headphones",40.0,3));
        inventory.addProduct(new Product("P5","Laptop",30.0,4));

        inventory.restockProduct("P4",2);
        System.out.println("Inventory value : $" + inventory.calculateTotalInventoryValue());
        System.out.println("Low stock products :");
        for (Product p : inventory.getLowStockProducts(5)) {
            System.out.println(p);
        }

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(inventory,"P1",2);
        cart.addItem(inventory,"P1",1);
        cart.addItem(inventory,"P2",2);
        cart.addItem(inventory,"P4",100);
        System.out.println("Cart total : $" + cart.calculateTotal(inventory));
        cart.checkout(inventory);
        inventory.printCatalog();
    }
}