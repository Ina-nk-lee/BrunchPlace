package model;

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

    public void printOrders() {

    }
}
