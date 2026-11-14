# Smart Store Inventory & Cart System (HashMap OOP Exercise) 🛒

## Learning Objectives
- Master `HashMap<K, V>` for O(1) average-time lookups, insertions, and updates.
- Practice key `HashMap` methods: `put()`, `get()`, `getOrDefault()`, `containsKey()`, `remove()`, `putIfAbsent()`, `keySet()`, `values()`, and `entrySet()`.
- Iterate cleanly over `Map.Entry<K, V>` pairs to generate reports and totals.
- Combine multiple OOP classes where one class manages catalog metadata and another manages quantity mappings.

## Features
- Maintain a store catalog mapping unique product IDs (`String`) to `Product` objects.
- Track stock quantities for each product ID.
- Allow customers to add, update, and remove items in a `ShoppingCart`.
- Prevent adding out-of-stock quantities or unknown product IDs.
- Generate an itemized receipt and compute total inventory value and low-stock alerts.

## Classes & Structure
```plaintext
SmartStoreSystem
 ├── Product
 ├── StoreInventory
 ├── ShoppingCart
 └── Main (Runner)
```

## Class-by-Class Requirements

### 1. `Product`
- **Fields:**
  - `productId` (`String`): Unique SKU/ID (e.g., `"P101"`).
  - `name` (`String`): Product name (e.g., `"Wireless Mouse"`).
  - `price` (`double`): Unit price.
  - `stockQuantity` (`int`): Available units in the store.
- **Constructor & Methods:**
  - `Product(String productId, String name, double price, int stockQuantity)`
  - Getters and setters (`setPrice`, `setStockQuantity`), plus helper methods `increaseStock(int qty)` and `decreaseStock(int qty)`.
  - `toString()`: Cleanly formats product details.

### 2. `StoreInventory`
- **Fields:**
  - `catalog` (`HashMap<String, Product>`): Maps `productId` → `Product`.
- **Constructor:**
  - `StoreInventory()`: Initializes an empty `HashMap<>`.
- **Methods:**
  - `addProduct(Product product)`: Adds a new product using `putIfAbsent()`. Prints a warning if the `productId` already exists.
  - `removeProduct(String productId)`: Removes a product by its key if `containsKey(productId)` is true.
  - `getProduct(String productId)`: Returns the `Product` or `null` if not found.
  - `restockProduct(String productId, int quantity)`: Finds the product and increases its stock.
  - `getLowStockProducts(int threshold)`: Iterates over `catalog.values()` and returns a `List<Product>` whose `stockQuantity <= threshold`.
  - `calculateTotalInventoryValue()`: Iterates over `catalog.entrySet()` and sums `price * stockQuantity` for all products.
  - `printCatalog()`: Displays all products formatted cleanly.

### 3. `ShoppingCart`
- **Fields:**
  - `items` (`HashMap<String, Integer>`): Maps `productId` → `quantity` in the customer's cart.
- **Methods:**
  - `addItem(StoreInventory inventory, String productId, int quantity)`: Checks if the product exists and has enough stock. Uses `items.getOrDefault(productId, 0) + quantity` to update the cart quantity.
  - `removeItem(String productId)`: Removes the item from the cart.
  - `calculateTotal(StoreInventory inventory)`: Iterates through `items.entrySet()`, looks up each `Product` price from `inventory`, and returns the total cost.
  - `checkout(StoreInventory inventory)`: Deducts purchased quantities from `StoreInventory`, prints an itemized receipt, and clears the cart (`items.clear()`).

### 4. `Main` (Runner)
- Populate `StoreInventory` with at least 5 products.
- Test restocking, querying low-stock items, and calculating total inventory value.
- Simulate a customer adding multiple items (including adding more of the same item to test `getOrDefault`), attempting to buy more than available stock, and completing `checkout()`.
- Print the updated inventory after checkout to verify stock deduction.

## How to Run
1. Compile all Java files:
   ```bash
   javac *.java
   ```
2. Run the `Main` class:
   ```bash
   java Main
   ```

## Bonus Challenges
- Add a `HashMap<String, List<Product>>` category index (e.g., `"Electronics"`, `"Stationery"`) to filter products by category.
- Track sales history using a `HashMap<String, Integer>` mapping `productId` → total units sold, and implement a `getBestSellingProduct()` method.

---
🗂️ **Fast lookups, clean mappings—master HashMap in Java!** ⚡
