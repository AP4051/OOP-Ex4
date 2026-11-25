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
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public void increaseStock(int qty) {
        if (qty > 0) stockQuantity += qty;
    }

    public void decreaseStock(int qty) {
        if (qty > 0 && qty <= stockQuantity) stockQuantity -= qty;
    }

    @Override
    public String toString() {
        return String.format("[%s] %-18s $%8.2f  stock: %d", productId, name, price, stockQuantity);
    }
}
