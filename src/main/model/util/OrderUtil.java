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
    private static OrderCollection orders;
    private static Order order;

    /**
     * Creates an OrderUtil object that manages orders.
     * @param newMenus where orders are going to be based on.
     */
    public OrderUtil(List<Menu> newMenus) {
        orders = new OrderCollection();
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

    public void removeItem() {

    }

    public void printMenu() {

    }

    public void makeOrder() {

    }

    /**
     * A getter for a current order.
     * @return the current order.
     */
    public Order getOrder() {
        return order;
    }
}
