import java.util.ArrayList;
import java.util.List;

public class StorageBox<T> {
    private String boxName;
    private int capacity;
    private List<T> items;

    public StorageBox(String boxName, int capacity) {
        this.boxName = boxName;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public boolean addItem(T item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        } else {
            System.out.println("Box is full!");
            return false;
        }
    }

    public T getItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public T removeLastItem() {
        if (!items.isEmpty()) {
            return items.remove(items.size() - 1);
        }
        return null;
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void displayContents() {
        System.out.println("Box Name: " + boxName);
        if (items.isEmpty()) {
            System.out.println("  (Empty)");
        } else {
            for (T item : items) {
                System.out.println("  - " + item);
            }
        }
    }
}