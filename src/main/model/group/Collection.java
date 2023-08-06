package main.model.group;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    protected List<Group> itemGroups;

    public Collection() {
        itemGroups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        itemGroups.add(group);
    }

    public void removeGroup(Group group) {
        itemGroups.remove(group);
    }

    protected List<Group> getMenuList() {
        return itemGroups;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        //  converts each order into string in a new line
        for (Group it : itemGroups) {
            result.append(it.toString()).append("\n\n");
        }

        //  removes a new line at the end of String
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
