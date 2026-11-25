public class Main {

    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("--- Summary of " + box.getBoxName() + " ---");
        System.out.println("Item count: " + box.getItemCount());
        box.displayContents();
    }

    public static void main(String[] args) {
        StorageBox<Book> bookBox = new StorageBox<>("Shelf A", 3);
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Shelf B", 2);

        bookBox.addItem(new Book("Clean Code", "Robert C. Martin"));
        bookBox.addItem(new Book("Effective Java", "Joshua Bloch"));
        bookBox.addItem(new Book("Head First Java", "Kathy Sierra"));
        bookBox.addItem(new Book("Refactoring", "Martin Fowler")); // box is full

        gadgetBox.addItem(new Gadget("Smartphone", 799.99));
        gadgetBox.addItem(new Gadget("Headphones", 149.50));
        gadgetBox.addItem(new Gadget("Smartwatch", 249.00)); // box is full

        // Compile-time type safety: the line below does NOT compile
        // bookBox.addItem(new Gadget("Tablet", 399.0));
        // error: incompatible types: Gadget cannot be converted to Book

        LabelPair<String, StorageBox<Book>> bookLabel = new LabelPair<>("Aisle-1", bookBox);
        LabelPair<String, StorageBox<Gadget>> gadgetLabel = new LabelPair<>("Aisle-2", gadgetBox);

        System.out.println(bookLabel.getKey() + " -> " + bookLabel.getValue().getBoxName());
        System.out.println(gadgetLabel.getKey() + " -> " + gadgetLabel.getValue().getBoxName());
        System.out.println();

        printBoxSummary(bookLabel.getValue());
        printBoxSummary(gadgetLabel.getValue());
    }
}
