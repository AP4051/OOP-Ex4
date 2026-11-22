public class Main {
 public static <T> void printBoxSummary(StorageBox<T> box){System.out.println("Count: "+box.getItemCount());box.displayContents();}
 public static void main(String[] args){
  StorageBox<Book> books=new StorageBox<>("Books",3);
  books.addItem(new Book("Java","Ali"));books.addItem(new Book("Math","Sara"));books.addItem(new Book("OOP","Reza"));books.addItem(new Book("Extra","X"));
  StorageBox<Gadget> gadgets=new StorageBox<>("Gadgets",2);
  gadgets.addItem(new Gadget("Mouse",20));gadgets.addItem(new Gadget("Phone",200));gadgets.addItem(new Gadget("Extra",1));
  LabelPair<String,StorageBox<Book>> b=new LabelPair<>("Aisle-1",books);
  LabelPair<String,StorageBox<Gadget>> g=new LabelPair<>("Aisle-2",gadgets);
  System.out.println(b.getKey()+" "+g.getKey());printBoxSummary(books);printBoxSummary(gadgets);
  // books.addItem(new Gadget("Wrong",5)); // Compile-time error: wrong type
 }
}
