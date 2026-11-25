public class Main {
    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("Items in box: " + box.getItemCount());
        box.displayContents();
    }

    public static void main(String[] args) {
        StorageBox<Book> bookBox = new StorageBox<>("Books - Shelf A", 3);
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Gadgets - Shelf B", 2);

        bookBox.addItem(new Book("Clean Code", "Robert C. Martin"));
        bookBox.addItem(new Book("Effective Java", "Joshua Bloch"));
        bookBox.addItem(new Book("The Pragmatic Programmer", "Andrew Hunt"));
        bookBox.addItem(new Book("Extra Book", "Unknown")); // Tests full capacity.

        gadgetBox.addItem(new Gadget("Wireless Mouse", 24.99));
        gadgetBox.addItem(new Gadget("Keyboard", 49.50));
        gadgetBox.addItem(new Gadget("USB Hub", 15.00)); // Tests full capacity.

        // This does not compile because Gadget is not a Book:
        // bookBox.addItem(new Gadget("Camera", 100.0));

        LabelPair<String, StorageBox<Book>> books = new LabelPair<>("Aisle-1", bookBox);
        LabelPair<String, StorageBox<Gadget>> gadgets = new LabelPair<>("Aisle-2", gadgetBox);
        System.out.println(books.getKey() + " contains books.");
        System.out.println(gadgets.getKey() + " contains gadgets.");
        printBoxSummary(bookBox);
        printBoxSummary(gadgetBox);
    }
}
