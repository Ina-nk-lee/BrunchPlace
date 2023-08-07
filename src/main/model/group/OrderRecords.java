package main.model.group;

/**
 * This class represents order records.
 */
public class OrderRecords extends Collection {
    public OrderRecords() {
        super();
    }

    public void addOrder(Order order) {
        super.addGroup(order);
    }

    public void removeOrder(Order order) {
        super.removeGroup(order);
    }

    public int numOrders() {
        return super.numItems();
    }
}
