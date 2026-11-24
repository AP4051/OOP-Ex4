import java.util.*;
public class StorageBox<T> {
 private String boxName; private int capacity;
 private List<T> items=new ArrayList<>();
 public StorageBox(String name,int capacity){boxName=name;this.capacity=capacity;}
 public boolean addItem(T item){if(items.size()>=capacity){System.out.println("Box is full!");return false;}return items.add(item);}
 public T getItem(int i){return i>=0&&i<items.size()?items.get(i):null;}
 public T removeLastItem(){return isEmpty()?null:items.remove(items.size()-1);}
 public int getItemCount(){return items.size();}
 public boolean isEmpty(){return items.isEmpty();}
 public void displayContents(){System.out.println(boxName+": "+items);}
}
