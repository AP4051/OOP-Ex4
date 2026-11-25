public class Main {
    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("Number of items: " + box.getItemCount());
        box.displayContents();
    }

    public static void main(String[] args) {
        StorageBox<Book> bookBox = new StorageBox<Book>("Book Box", 3);
        StorageBox<Gadget> gadgetBox = new StorageBox<Gadget>("Gadget Box", 2);

        bookBox.addItem(new Book("Harry Potter", "J.K. Rowling"));
        bookBox.addItem(new Book("The Hobbit", "J.R.R. Tolkien"));
        bookBox.addItem(new Book("1984", "George Orwell"));
        bookBox.addItem(new Book("Animal Farm", "George Orwell"));

        gadgetBox.addItem(new Gadget("Phone", 800));
        gadgetBox.addItem(new Gadget("Headphones", 100));
        gadgetBox.addItem(new Gadget("Mouse", 50));

        LabelPair<String, StorageBox<Book>> bookLabel =
                new LabelPair<String, StorageBox<Book>>("Aisle-1", bookBox);
        LabelPair<String, StorageBox<Gadget>> gadgetLabel =
                new LabelPair<String, StorageBox<Gadget>>("Aisle-2", gadgetBox);

        System.out.println(bookLabel.getKey());
        printBoxSummary(bookBox);
        System.out.println(gadgetLabel.getKey());
        printBoxSummary(gadgetBox);

        // This line would cause a compile-time error:
        // bookBox.addItem(new Gadget("Laptop", 1000));
    }
}
