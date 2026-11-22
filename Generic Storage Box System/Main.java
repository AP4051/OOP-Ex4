public class Main {


    public static <T> void printBoxSummary(StorageBox<T> box) {
        System.out.println("=== Box Summary ===");
        System.out.println("Item Count: " + box.getItemCount());
        box.displayContents();
        System.out.println("===================");
    }

    public static void main(String[] args) {
        // ۱. ساخت جعبه کتاب با ظرفیت ۳ و جعبه گجت با ظرفیت ۲
        StorageBox<Book> bookBox = new StorageBox<>("Shelf A", 3);
        StorageBox<Gadget> gadgetBox = new StorageBox<>("Tech Drawer", 2);

        // ۲. اضافه کردن آیتم‌ها و تست پر شدن ظرفیت
        bookBox.addItem(new Book("Clean Code", "Robert C. Martin"));
        bookBox.addItem(new Book("Effective Java", "Joshua Bloch"));
        bookBox.addItem(new Book("Head First Java", "Kathy Sierra"));
        // تلاش برای اضافه کردن کتاب چهارم (چاپ پیام Box is full!)
        bookBox.addItem(new Book("Design Patterns", "GoF"));

        gadgetBox.addItem(new Gadget("Smartwatch", 199.99));
        gadgetBox.addItem(new Gadget("Wireless Earbuds", 89.50));
        // تلاش برای اضافه کردن گجت سوم (چاپ پیام Box is full!)
        gadgetBox.addItem(new Gadget("Power Bank", 45.00));

        // ۳. نمایش امنیت تایپ در زمان کامپایل (Compile-time type safety)
        // خط زیر در صورت خروج از کامنت باعث خطای کامپایل می‌شود، چون bookBox فقط اشیاء Book را می‌پذیرد:
        // bookBox.addItem(new Gadget("Tablet", 299.99));

        // ۴. تخصیص کد راهرو با استفاده از LabelPair
        LabelPair<String, StorageBox<Book>> bookAisle = new LabelPair<>("Aisle-1", bookBox);
        LabelPair<String, StorageBox<Gadget>> gadgetAisle = new LabelPair<>("Aisle-2", gadgetBox);

        System.out.println("Location: " + bookAisle.getKey());
        printBoxSummary(bookAisle.getValue());

        System.out.println("\nLocation: " + gadgetAisle.getKey());
        printBoxSummary(gadgetAisle.getValue());
    }
}