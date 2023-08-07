package main.model.util;

import main.model.group.Menu;
import main.model.group.Order;
import main.model.group.OrderRecords;
import main.model.single.Item;

import java.util.List;

/**
 * This class is a static utility class to manage orders.
 * It saves orders made to its order records.
 */
public class OrderUtil {
    private static OrderRecords orderRecords;
    private static OrderRecords currentOrders;
    private static List<Menu> menus;
    private static Order order;
    private static int sales;

    public static void initUtil(List<Menu> newMenus) {
        orderRecords = new OrderRecords();
        currentOrders = new OrderRecords();
        menus = newMenus;
        sales = 0;
    }

    /**
     * Creates a new order with a given table number.
     * @param tableNum is the table number of the new order.
     */
    public static void startOrder(int tableNum) {
        order = new Order(tableNum);
    }

    /**
     * Adds an item to a current order.
     * Does nothing if there is no such item in the menu.
     * @param itemName is the name of the item to add.
     */
    public static void addItem(String itemName) {
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
    public static void removeItem(String itemName) {
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
    public static void makeOrder() {
        if(order.numItem() != 0) {
            currentOrders.addOrder(order);
            order.setOrdered();
            order = null;
        }
    }

    /**
     * Pays one of the orders that are made.
     * Picks an order according to the user input.
     */
    public static void payOrder(int i) {
        int index = i - 1;
        Order picked = (Order) currentOrders.getList().get(index);
        picked.setPaid();
        sales += picked.getTotal();
        orderRecords.addOrder(picked);
        currentOrders.removeOrder(picked);
    }

    /**
     * Checks if OrderUtil is empty.
     * @return true if OrderUtil does NOT have an order, false if it has an ongoing one.
     */
    public static boolean isEmpty() {
        return order == null;
    }

    /**
     * A getter for the ongoing, unpaid order.
     * @return Order that is an ongoing, unpaid one.
     */
    public static Order getOrder() {
        return order;
    }

    /**
     * A getter for order records
     * @return order records.
     */
    public static OrderRecords getOrderRecords() {
        return orderRecords;
    }

    /**
     * A getter for orders that are made but not paid.
     * @return current orders that are made but not paid.
     */
    public static OrderRecords getCurrentOrders() {
        return currentOrders;
    }

    /**
     * A getter for sales.
     * @return sales in total.
     */
    public static int getSales() {
        return sales;
    }
}
