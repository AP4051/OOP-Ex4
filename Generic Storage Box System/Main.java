
public class Main {

    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("Number of items: " + box.getItemCount());
        box.displayContents();
    }

    public static void main(String[] args) {

        // Create book box
        StorageBox<Book> bookBox = new StorageBox<>("Books Shelf", 3);

        bookBox.addItem(new Book("Java Basics", "John"));
        bookBox.addItem(new Book("Python Guide", "Mike"));
        bookBox.addItem(new Book("OOP Programming", "David"));

        // Test adding item when box is full
        bookBox.addItem(new Book("C++ Guide", "Alex"));

        // Compile-time type safety:
        // bookBox.addItem(new Gadget("Laptop", 1000));
        // This causes a compile-time error.

        // Create gadget box
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Gadgets Shelf", 2);

        gadgetBox.addItem(new Gadget("Laptop", 1000));
        gadgetBox.addItem(new Gadget("Phone", 700));

        // Test adding item when box is full
        gadgetBox.addItem(new Gadget("Tablet", 500));

        // Create LabelPair objects
        LabelPair<String, StorageBox<Book>> bookLabel =
                new LabelPair<>("Aisle-1", bookBox);

        LabelPair<String, StorageBox<Gadget>> gadgetLabel =
                new LabelPair<>("Aisle-2", gadgetBox);

        System.out.println("Book Label: " + bookLabel.getKey());
        System.out.println("Gadget Label: " + gadgetLabel.getKey());

        // Print summaries
        System.out.println("\n--- Book Box Summary ---");
        printBoxSummary(bookBox);

        System.out.println("\n--- Gadget Box Summary ---");
        printBoxSummary(gadgetBox);
    }
}
