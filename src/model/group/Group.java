package model.group;

import model.single.Item;

import java.util.ArrayList;
import java.util.List;

public class Group {
    protected List<Item> items;

    public Group() {
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

    protected List<Item> getItems() {
        return items;
    }

    //  Converts Items to String starting with a headline and by placing each item on a new line.
    public String toString(String headline) {
        StringBuilder result = new StringBuilder();
        result.append("<").append(headline).append(">").append("\n");
        for (Item it : items) {
            result.append(it.toString()).append("\n");
        }

        //  removes a new line at the end.
        if(result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
