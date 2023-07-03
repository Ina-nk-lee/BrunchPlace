package model;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Item> items;

    public Menu() {
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
}
