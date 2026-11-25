import java.util.ArrayList;

public class StorageBox<T> {

    private String boxName;
    private int capacity;
    private ArrayList<T> items;

    public StorageBox(String boxName,int capacity) {
        this.boxName = boxName;
        this.capacity = capacity;
        items = new ArrayList<>();
    }

    public boolean addItem(T item) {
        if (items.size() < capacity) {
            items.add(item);
            return true;
        }
        System.out.println("Box is full!");
        return false;
    }

    public T getItem(int index) {
        if (index < 0 || index >= items.size())
            return null;
        return items.get(index);
    }

    public T removeLastItem() {
        if (items.isEmpty())
            return null;
        return items.remove(items.size() - 1);
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public boolean containsItem(T item) {
        return items.contains(item);
    }

    public void displayContents() {
        System.out.println("\n" + boxName + " contents :");
        if (items.isEmpty())
            System.out.println("Box is empty.");
        else {
            for (T item : items) {
               System.out.println(item);
            }
        }
    }
}