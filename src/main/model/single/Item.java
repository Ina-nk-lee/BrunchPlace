package main.model.single;

/**
 * This class represents an item with a name and a price.
 */
public class Item {
    private String name;
    private double price;

    /**
     * Creates an item based on the given name and price.
     * @param itemName is an item's name.
     * @param itemPrice is an item's price.
     */
    public Item(String itemName, double itemPrice) {
        name = itemName;
        price = itemPrice;
    }

    /**
     * A getter for the item's name.
     * @return the item's name.
     */
    public String getName() {
        return name;
    }

    /**
     * A getter for the item's price.
     * @return the item's price.
     */
    public double getPrice() {
        return price;
    }

    /**
     * A setter for the item's name.
     * @param itemName is the item's new name.
     */
    public void setName(String itemName) {
        name = itemName;
    }

    /**
     * A setter for the item's price.
     * @param itemPrice is the item's new price.
     */
    public void setPrice(double itemPrice) {
        price = itemPrice;
    }

    /**
     * Converts the item's information to a string.
     * @return a string that contains the item's name and price.
     */
    public String toString() {
        return this.getName() + " / " + this.getPrice();
    }
}
