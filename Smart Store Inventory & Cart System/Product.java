public class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        this.name = name;
        this.productId = productId;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void increaseStock(int qty){
        stockQuantity += qty;
    }

    public void decreaseStock(int qty){
        stockQuantity -= qty;
    }

    public String toString() {
        return productId + " - " + name + " - $" + price + " - " + stockQuantity + " units";
    }
}
