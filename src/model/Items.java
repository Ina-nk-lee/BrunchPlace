package model;

import java.util.ArrayList;

public class Items {
    private ArrayList<Item> items;

    public Items() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int numItem() {
        return items.size();
    }

    //  Converts Menu to String by placing each item on a new line.
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Item it : items) {
            result.append(it.toString()).append("\n");
        }
        if(result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }
}
