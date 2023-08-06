package main.model.group;

import main.model.single.Item;

/**
 * This class represents a menu of items.
 */
public class Menu extends Group {
    private String name;

    /**
     * Creates a menu with a given name.
     * @param menuName is the name of the menu.
     */
    public Menu(String menuName) {
        super();
        name = menuName;
    }

    /**
     * Gets an item with a given name.
     * @param itemName is the name of the item to get.
     * @return the item with the given name. null if there is none.
     */
    public Item getItem(String itemName) {
        for(Item i : super.getItems()) {
            if(i.getName().equalsIgnoreCase(itemName)) {
                return i;
            }
        }
        return null;
    }

    /**
     * A getter for the name of this menu.
     * @return the name of this menu.
     */
    public String getName() {
        return name;
    }

    /**
     * A setter for the name of this menu.
     * @param newName is the new name of this menu.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Converts this menu into a string.
     * @return a string that is converted from this menu.
     */
    public String toString() {
        return super.toString(name);
    }
}
