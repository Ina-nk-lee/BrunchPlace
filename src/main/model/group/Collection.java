package main.model.group;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a collection of item groups.
 */
public class Collection {
    protected List<Group> itemGroups;

    /**
     * Creates a collection object.
     */
    public Collection() {
        itemGroups = new ArrayList<>();
    }

    /**
     * Adds a given group to this collection.
     * @param group to be added.
     */
    public void addGroup(Group group) {
        itemGroups.add(group);
    }

    /**
     * Removes a given group from this collection.
     * @param group to be removed.
     */
    public void removeGroup(Group group) {
        itemGroups.remove(group);
    }

    /**
     * A getter for this collection's group list.
     * @return a list of groups.
     */
    public List<Group> getList() {
        return itemGroups;
    }

    /**
     * Gets the size of this collection.
     * @return the size of this collection.
     */
    public int numItems() {
        return itemGroups.size();
    }

    /**
     * Converts item groups in this collection into a string.
     * The elements are numbered.
     * @return a string of the item groups in this collection.
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        int i = 1;

        //  converts each order into string in a new line
        for (Group it : itemGroups) {
            result.append(i++).append(". ").append(it.toString()).append("\n\n")
                    .append("===========================================\n\n");
        }

        //  removes a new line at the end of String
        if (result.length() > 0) {
            result.setLength(result.length() - 47);
        }
        return result.toString();
    }
}
