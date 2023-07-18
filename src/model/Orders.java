package model;

import model.itemGroup.Order;

import java.util.ArrayList;

public class Orders {
    private ArrayList<Order> orders;

    public Orders() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        //  converts each order into string in a new line
        for (Order it : orders) {
            result.append(it.toString()).append("\n\n");
        }

        //  removes a new line at the end of String
        if (result.length() > 0) {
            result.setLength(result.length() - 2);
        }
        return result.toString();
    }
}
