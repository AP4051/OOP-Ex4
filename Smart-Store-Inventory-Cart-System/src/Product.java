public class Product {

    private String productId;
    private String name;
    private double price;
    private int stockQuantity;


    public Product(String productId,String name,double price,int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int quantity) {
        this.stockQuantity = quantity;
    }

    public void increaseStock(int quantity) {
        if (quantity > 0)
            stockQuantity += quantity;
    }

    public boolean decreaseStock(int quantity) {
        if (quantity <= 0 || quantity > stockQuantity)
            return false;
        stockQuantity -= quantity;
        return true;
    }

    public String toString() {
        return productId + " | " + name + " | $" + String.format("%.2f",price) + " | stock : " + stockQuantity;
    }
}