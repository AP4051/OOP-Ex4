public class Product {
 private String productId,name;private double price;private int stockQuantity;
 public Product(String id,String name,double price,int stock){productId=id;this.name=name;this.price=price;stockQuantity=stock;}
 public String getProductId(){return productId;}
 public String getName(){return name;}
 public double getPrice(){return price;}
 public int getStockQuantity(){return stockQuantity;}
 public void setPrice(double price){if(price>=0)this.price=price;}
 public void setStockQuantity(int stock){if(stock>=0)stockQuantity=stock;}
 public void increaseStock(int qty){if(qty>0)stockQuantity+=qty;}
 public void decreaseStock(int qty){if(qty>=0&&qty<=stockQuantity)stockQuantity-=qty;}
 public String toString(){return productId+" "+name+" $"+price+" stock="+stockQuantity;}
}
