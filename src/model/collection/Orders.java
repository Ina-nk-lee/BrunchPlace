package model.collection;

import model.group.Order;

public class Orders extends Groups{
    public Orders() {
        super();
    }

    public void addOrder(Order order) {
        super.addGroup(order);
    }

    public void removeOrder(Order order) {
        super.removeGroup(order);
    }
}
