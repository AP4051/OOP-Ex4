import java.util.List;
import java.util.ArrayList;

public class StorageBox<T> {
    private String boxName;
    private int capacity;
    private ArrayList<T> items;


    public StorageBox(String boxName, int capacity) {
        if(capacity < 0)
            throw new IllegalArgumentException("Capacity cannot be negative");
        this.boxName = boxName;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public boolean addItem(T item){
        if (capacity <= items.size()){
            System.out.println("Box is full");
            return false;
        }
        items.add(item);
        return true;
    }

    public T getItem(int index){
        return (index >= 0 && index < items.size()) ? items.get(index) : null;
    }
    public T removeLastItem(){
        return items.isEmpty() ? null : items.remove(items.size()-1);
    }
    public int getItemCount(){
        return items.size();
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public void displayContents(){
        System.out.println(boxName + " contents:");
        if (items.isEmpty()){
            System.out.println(" (empty)");
        }
        else {
            for (T item : items){
                System.out.println(" " + item);
            }
        }
    }


}
