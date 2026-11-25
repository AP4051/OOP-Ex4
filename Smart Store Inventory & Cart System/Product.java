public class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setPrice(double price) { this.price = price; }
    public void setStockQuantity(int quantity) { stockQuantity = quantity; }
    public void increaseStock(int quantity) {
        if (quantity > 0) stockQuantity += quantity;
    }
    public void decreaseStock(int quantity) {
        if (quantity > 0 && quantity <= stockQuantity) stockQuantity -= quantity;
    }
    public String toString() {
        return productId + " | " + name + " | $" + price + " | Stock: " + stockQuantity;
    }
}
