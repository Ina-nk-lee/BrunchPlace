package main.model.util;

import main.model.group.Menu;
import main.model.group.Order;
import main.model.group.OrderCollection;
import main.model.single.Item;

import java.util.List;

/**
 * This class is a utility class to manage orders.
 */
public class OrderUtil extends Util {
    private static List<Menu> menus;
    private static OrderCollection orderRecords;
    private static Order order;

    /**
     * Creates an OrderUtil object that manages orders.
     * @param newMenus where orders are going to be based on.
     */
    public OrderUtil(List<Menu> newMenus) {
        orderRecords = new OrderCollection();
        menus = newMenus;
    }

    /**
     * Creates a new order with a given table number.
     * @param tableNum is the table number of the new order.
     */
    public void startOrder(int tableNum) {
        order = new Order(tableNum);
    }

    /**
     * Adds an item to a current order.
     * Does nothing if there is no such item in the menu.
     * @param itemName is the name of the item to add.
     */
    public void addItem(String itemName) {
        Item newItem = null;
        for(Menu menu : menus) {
            newItem = menu.getItem(itemName);
            if(newItem != null) {
                order.addItem(newItem);
            }
        }
    }

    /**
     * Removes an item to a current order.
     * Does nothing if there is no such item in the menu.
     * @param itemName is the name of the item to remove.
     */
    public void removeItem(String itemName) {
        Item newItem = null;
        for(Menu menu : menus) {
            newItem = menu.getItem(itemName);
            if(newItem != null) {
                order.removeItem(newItem);
            }
        }
    }

    /**
     * Makes an order by moving the current order to order records.
     */
    public void makeOrder() {
        if(order.numItem() != 0) {
            orderRecords.addOrder(order);
            order = null;
        }
    }

    /**
     * Checks if OrderUtil is empty.
     * @return true if OrderUtil does NOT have an order, false if it has an ongoing one.
     */
    public boolean isEmpty() {
        return order == null;
    }

    /**
     * A getter for a current order.
     * @return the current order.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * A getter for order records.
     * @return order records.
     */
    public OrderCollection getOrderRecords() {
        return orderRecords;
    }
}
