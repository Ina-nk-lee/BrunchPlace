package model;

public class App extends Item{

    public App(String itemName, double itemPrice) {
        super(itemName, itemPrice);
    }

    public String getName() {
        return super.getName();
    }

    public double getPrice() {
        return super.getPrice();
    }

    public void setName(String itemName) {
        super.setName(itemName);
    }

    public void setPrice(double itemPrice) {
        super.setPrice(itemPrice);
    }
}
