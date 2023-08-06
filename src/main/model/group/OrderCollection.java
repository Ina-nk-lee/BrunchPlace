package main.model.group;

public class OrderCollection extends Collection {
    public OrderCollection() {
        super();
    }

    public void addOrder(Order order) {
        super.addGroup(order);
    }

    public void removeOrder(Order order) {
        super.removeGroup(order);
    }
}
