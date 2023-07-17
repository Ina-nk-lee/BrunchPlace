package model.itemGroup;

import model.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Items {
    protected List<Item> items;

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

    //  Converts Items to String starting with a headline and by placing each item on a new line.
    public String toString(String headline) {
        StringBuilder result = new StringBuilder();
        result.append("<" + headline + ">").append("\n");
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
