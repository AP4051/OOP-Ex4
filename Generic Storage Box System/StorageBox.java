import java.util.ArrayList;
import java.util.List;

public class StorageBox<T> {
    private String boxName;
    private int capacity;
    private List<T> items;

    public StorageBox(String boxName, int capacity) {
        this.boxName = boxName;
        this.capacity = capacity;
        items = new ArrayList<T>();
    }
    public boolean addItem(T item) {
        if (items.size() >= capacity) {
            System.out.println("Box is full!");
            return false;
        }
        items.add(item);
        return true;
    }
    public T getItem(int index) {
        if (index < 0 || index >= items.size()) return null;
        return items.get(index);
    }
    public T removeLastItem() {
        if (items.isEmpty()) return null;
        return items.remove(items.size() - 1);
    }
    public int getItemCount() { return items.size(); }
    public boolean isEmpty() { return items.isEmpty(); }

    public void displayContents() {
        System.out.println("Box: " + boxName);
        if (items.isEmpty()) System.out.println("Box is empty.");
        for (T item : items) System.out.println(item);
    }
}
