public class Product {
    private final String productId;
    private final String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        if (productId == null || productId.isBlank() || name == null || name.isBlank()) throw new IllegalArgumentException("Product ID and name are required.");
        if (price < 0 || stockQuantity < 0) throw new IllegalArgumentException("Price and stock cannot be negative.");
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setPrice(double price) { if (price < 0) throw new IllegalArgumentException("Price cannot be negative."); this.price = price; }
    public void setStockQuantity(int quantity) { if (quantity < 0) throw new IllegalArgumentException("Stock cannot be negative."); this.stockQuantity = quantity; }
    public void increaseStock(int qty) { if (qty <= 0) throw new IllegalArgumentException("Quantity must be positive."); stockQuantity += qty; }
    public void decreaseStock(int qty) { if (qty <= 0 || qty > stockQuantity) throw new IllegalArgumentException("Invalid stock decrease."); stockQuantity -= qty; }

    @Override
    public String toString() { return productId + " - " + name + " ($" + String.format("%.2f", price) + ", stock: " + stockQuantity + ")"; }
}
