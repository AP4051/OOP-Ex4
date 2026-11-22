public class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        if (price < 0 || stockQuantity < 0) {
            throw new IllegalArgumentException("Price and stock cannot be negative");
        }
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
    public void setPrice(double price){
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
    public void setStockQuantity(int stockQuantity){
        if (stockQuantity < 0){
            throw new IllegalArgumentException("stock cannot be negative");
        }
        this.stockQuantity = stockQuantity;
    }
    public void increaseStock(int qnty){
        if (qnty <= 0){
            throw new IllegalArgumentException("Quantity must be positive");
        }
        stockQuantity += qnty;
    }
    public void decreaseStock(int qnty){
        if (qnty <= 0){
            throw new IllegalArgumentException("Invalid stock reduction");
        }
        stockQuantity -= qnty;
    }

    @Override
    public String toString() {
        return String.format("ID of Product: %s | Name of product: %s | Price: $%.2f | Stock: %d", productId, name, price, stockQuantity);
    }



}
