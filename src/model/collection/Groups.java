package model.collection;

import model.group.Items;

import java.util.ArrayList;

public class Groups {
    private ArrayList<Items> itemGroups;

    public Groups() {
        itemGroups = new ArrayList<>();
    }

    public void addGroup(Items group) {
        itemGroups.add(group);
    }

    public void removeGroup(Items group) {
        itemGroups.remove(group);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        //  converts each order into string in a new line
        for (Items it : itemGroups) {
            result.append(it.toString()).append("\n\n");
        }

        //  removes a new line at the end of String
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
