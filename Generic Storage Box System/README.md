# Generic Storage Box System (Generics OOP Exercise) 📦

## Learning Objectives
- Define and instantiate **generic classes** with a single type parameter (`<T>`) and two type parameters (`<K, V>`).
- Write a simple **generic method** (`public static <T> ...`).
- Understand how Java Generics provide **compile-time type safety** (preventing you from putting the wrong item type into a typed box).

## Features
- Create simple item classes (`Book` and `Gadget`).
- Store items in a reusable generic `StorageBox<T>` with a maximum item capacity.
- Label and organize boxes using a generic `LabelPair<K, V>` class.
- Print any list or box contents using a generic utility method.

## Classes & Structure
```plaintext
GenericStorageSystem
 ├── Book
 ├── Gadget
 ├── StorageBox<T>
 ├── LabelPair<K, V>
 └── Main (Runner)
```

## Class-by-Class Requirements

### 1. `Book` & `Gadget` (Simple Item Classes)
- **`Book`**:
  - Fields: `title` (`String`), `author` (`String`)
  - Constructor, getters, and a clean `toString()` method.
- **`Gadget`**:
  - Fields: `name` (`String`), `price` (`double`)
  - Constructor, getters, and a clean `toString()` method.

### 2. `StorageBox<T>` (Generic Class)
- **Purpose:** A reusable, type-safe container that holds a list of items of type `T`.
- **Fields:**
  - `boxName` (`String`): Name of the box (e.g., `"Shelf A"`).
  - `capacity` (`int`): Maximum number of items allowed in the box.
  - `items` (`List<T>`): Internal `ArrayList<T>` storing the items.
- **Constructor:**
  - `StorageBox(String boxName, int capacity)`: Initializes the box name, capacity, and an empty `ArrayList<>`.
- **Methods:**
  - `addItem(T item)`: Adds `item` if `items.size() < capacity`; otherwise prints `"Box is full!"`. Returns `true` if added, `false` otherwise.
  - `getItem(int index)`: Returns the item of type `T` at `index` (or `null` if the index is invalid).
  - `removeLastItem()`: Removes and returns the last item in the box (or `null` if the box is empty).
  - `getItemCount()`: Returns the current number of items.
  - `isEmpty()`: Returns `true` if the box has no items.
  - `displayContents()`: Prints `boxName` and all items inside.

### 3. `LabelPair<K, V>` (Two-Parameter Generic Class)
- **Purpose:** Associates any label/key of type `K` with any value of type `V` (for example, pairing an aisle code `String` with a `StorageBox<Book>`).
- **Fields:**
  - `key` (`K`)
  - `value` (`V`)
- **Methods:**
  - Constructor `LabelPair(K key, V value)`
  - `getKey()`, `getValue()`, `setValue(V value)`, and `toString()`.

### 4. Generic Helper Method (in `Main` or a `BoxUtils` class)
- Implement a static generic method:
  - `public static <T> void printBoxSummary(StorageBox<T> box)`: Prints the box's item count and contents for any `StorageBox<T>`.

### 5. `Main` (Runner)
- Create a `StorageBox<Book>` with capacity `3` and a `StorageBox<Gadget>` with capacity `2`.
- Add items to both boxes and test adding an item when the box is already full.
- Demonstrate **compile-time type safety** (e.g., show in a comment that `bookBox.addItem(new Gadget(...))` causes a compile-time error).
- Create `LabelPair<String, StorageBox<Book>>` and `LabelPair<String, StorageBox<Gadget>>` to assign aisle codes (like `"Aisle-1"`).
- Call `printBoxSummary(...)` on both boxes.

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
- Add a bounded type parameter `<T extends PricedItem>` (using a simple `PricedItem` interface with `double getPrice()`) to calculate the total value of items in a box.
- Add a `containsItem(T item)` method to `StorageBox<T>`.

---
🧩 **Write once, reuse safely everywhere—master Java Generics!** 🚀