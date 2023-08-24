package main.model.group;

import main.model.single.Item;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a food order.
 */
public class Order extends Group {
    private LocalDate date;
    private double total;
    private int table;
    private int numItems;
    private boolean isOrdered;
    private boolean isPaid;
    private Map<Item, Integer> orderList;

    /**
     * Creates an order with a given table number and a local date.
     * Table number should be 0 if it's to-go.
     * @param tableNo of the order.
     */
    public Order(int tableNo) {
        super();
        date = LocalDate.now();
        total = 0;
        table = tableNo;
        numItems = 0;
        isOrdered = false;
        isPaid = false;
        orderList = new HashMap<>();
    }

    /**
     * Adds an item to the order.
     * @param item to be added.
     */
    public void addItem(Item item) {
        super.addItem(item);
        total += item.getPrice();
    }

    /**
     * Removes an item from the order.
     * @param item to be removed.
     */
    public void removeItem(Item item) {
        super.removeItem(item);
        total -= item.getPrice();
    }

    /**
     * Gets the date of the order.
     * @return LocalDate of the order.
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Gets the number of items in the order.
     * @return the number of items in the order
     */
    public int numItem() {
        return super.numItem();
    }

    /**
     * Sets the date of the order.
     * @param newDate of the order.
     */
    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    /**
     * Gets the total amount of the order.
     * @return the total amount of the order.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Gets the table number of the order.
     * @return the table number of the order.
     */
    public int getTable() {
        return table;
    }

    /**
     * Sets the table number of the order.
     */
    public void setTable(int tableNo) {
        table = tableNo;
    }

    /**
     * Checks if the order has been made.
     * @return true if the order has been made, false if not.
     */
    public boolean isOrdered() {
        return isOrdered;
    }

    /**
     * Checks if the order has been paid.
     * @return true if the order has been paid, false if not.
     */
    public boolean isPaid() {
        return isPaid;
    }

    /**
     * Sets that the order has been made.
     */
    public void setOrdered() {
        isOrdered = true;
    }

    /**
     * Sets that the order has been paid.
     */
    public void setPaid() {
        isPaid = true;
    }

    /**
     * Gets the quantity of the item.
     * @param item to be counted.
     * @return the quantity of the item.
     */
    public int getQuantity(Item item) {
        this.updateOrderList();
        return orderList.getOrDefault(item, 0);
    }

    /**
     * Updates OrderList according to the items(ArrayList) to count the quantity of each item and all the items.
     */
    private void updateOrderList() {
        numItems = 0;
        for(Item curr : this) {
            int count = 0;
            for(Item other : this) {
                if(curr.equals(other)) {
                    count++;
                }
            }
            orderList.put(curr, count);
            numItems++;
        }
    }

    /**
     * Converts the order to string.
     * @return the string conversion of the order.
     */
    public String toString() {
        //  Update OrderList with a quantity for each item
        this.updateOrderList();

        StringBuilder result = new StringBuilder();
        result.append("<").append(date).append(">")
                .append("\nTable No: ").append(table).append("\n")
                .append("------------------\n");

        //  toString each item with a quantity
        for (Map.Entry<Item, Integer> entry : orderList.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            result.append(item.toString())
                    .append("\n\tx ").append(quantity).append("\n");
        }

        //  shows the total quantity of the items and the total price.
        result.append("------------------\n")
                .append("Items: ").append("\t").append(numItems).append("\n")
                .append("Total: ").append("\t$").append(total);

        //  removes a new line at the end.
//        if(result.length() > 0) {
//            result.setLength(result.length() - 1);
//        }

        return result.toString();
    }
}
