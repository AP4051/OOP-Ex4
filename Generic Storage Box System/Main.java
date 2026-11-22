public class Main {

    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("Item count: " + box.getItemCount());
        box.displayContents();
    }

    public static void main(String[] args) {
        StorageBox<Book> bookBox = new StorageBox<>("Bookshelf A", 3);
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Gadget Shelf", 2);

        bookBox.addItem(new Book("The Hobbit", "J.R.R. Tolkien"));
        bookBox.addItem(new Book("1984", "George Orwell"));
        bookBox.addItem(new Book("Pride and Prejudice", "Jane Austen"));
        bookBox.addItem(new Book("Dune", "Frank Herbert"));

        gadgetBox.addItem(new Gadget("Headphones", 49.99));
        gadgetBox.addItem(new Gadget("Keyboard", 79.99));
        gadgetBox.addItem(new Gadget("Mouse", 25.50));

        LabelPair<String, StorageBox<Book>> bookLabel =
                new LabelPair<>("Aisle-1", bookBox);

        LabelPair<String, StorageBox<Gadget>> gadgetLabel =
                new LabelPair<>("Aisle-2", gadgetBox);

        System.out.println(bookLabel.getKey());
        printBoxSummary(bookLabel.getValue());

        System.out.println();

        System.out.println(gadgetLabel.getKey());
        printBoxSummary(gadgetLabel.getValue());
    }
}


