package main.model.group;

import main.model.single.Item;

import java.util.ArrayList;

/**
 * This class represents a group of items.
 */
public class Group extends ArrayList<Item>{

    /**
     * Creates an item group.
     */
    public Group() {
        super();
    }

    /**
     * Adds an item to this group.
     * @param item to be added.
     */
    public void addItem(Item item) {
        this.add(item);
    }

    /**
     * Removes an item from this group.
     * @param item to be removed.
     */
    public void removeItem(Item item) {
        this.remove(item);
    }

    /**
     * Gets the number of items in this group.
     * @return the number of items in this group.
     */
    public int numItem() {
        return this.size();
    }

    /**
     * Converts items in this group to a string.
     * A given headline comes first as a title of this group.
     * @param headline is a title of the string.
     * @return a string of items in this group.
     */
    public String toString(String headline) {
        StringBuilder result = new StringBuilder();
        result.append("<").append(headline).append(">").append("\n");
        for (Item it : this) {
            result.append(it.toString()).append("\n");
        }

        //  removes a new line at the end.
        if(result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
