public class Main {

    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("Number of items : " + box.getItemCount());
        box.displayContents();
    }

    public static void main(String[] args) {

        StorageBox<Book> bookBox = new StorageBox<>("Books Shelf",3);
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Gadgets Shelf",2);

        bookBox.addItem(new Book("Java","A"));
        bookBox.addItem(new Book("HTML","B"));
        bookBox.addItem(new Book("Python","C"));
        bookBox.addItem(new Book("C++","D"));

        gadgetBox.addItem(new Gadget("Mouse",15.5));
        gadgetBox.addItem(new Gadget("Keyboard",25.0));
        gadgetBox.addItem(new Gadget("Headphones",40.0));

        LabelPair<String,StorageBox<Book>> booksLabel = new LabelPair<>("Aisle-1",bookBox);
        LabelPair<String,StorageBox<Gadget>> gadgetsLabel = new LabelPair<>("Aisle-2",gadgetBox);
        System.out.println(booksLabel);
        System.out.println(gadgetsLabel);

        printBoxSummary(bookBox);
        printBoxSummary(gadgetBox);
    }
    
}