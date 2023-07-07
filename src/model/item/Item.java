package model.item;

public class Item {
    private String name;
    private double price;

    public Item(String itemName, double itemPrice) {
        name = itemName;
        price = itemPrice;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String itemName) {
        name = itemName;
    }

    public void setPrice(double itemPrice) {
        price = itemPrice;
    }

    public String toString() {
        return this.getName() + " / " + this.getPrice();
    }
}
