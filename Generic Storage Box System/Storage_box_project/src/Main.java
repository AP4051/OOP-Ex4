public class Main {
    public static <T> void printBoxSummary(StorageBox<T> box){
        System.out.println("Summary for " + box.getItemCount() + " item(s):");
        box.displayContents();
    }

    public static void main(String[] args) {
        StorageBox<Book> bookBox = new StorageBox<>("Box of books", 3);
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Box of gadgets", 2);

        bookBox.addItem(new Book("War and Peace", "Leo Tolstoy"));
        bookBox.addItem(new Book("Pride and Prejudice", "Jane Austen"));
        bookBox.addItem(new Book("Clean Code", "Robert C. Martin"));
        // Must prevent being added
        bookBox.addItem(new Book("The Pragmatic Programmer", "Andrew Hunt"));

        gadgetBox.addItem(new Gadget("Speaker", 49.50));
        gadgetBox.addItem(new Gadget("TV", 110.99));
        // Must prevent being added
        gadgetBox.addItem(new Gadget("Webcam", 39.99));

        LablePair<String, StorageBox<Book>> bookAisle = new LablePair<>("Aisle-1", bookBox);
        LablePair<String, StorageBox<Gadget>> gadgetAisle = new LablePair<>("Aisle-2", gadgetBox);

        System.out.println(bookAisle.getKey() + " / " + gadgetAisle.getKey());
        printBoxSummary(bookBox);
        printBoxSummary(gadgetBox);

    }

}