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
     * Creates a new cart with a given table number.
     * @param tableNum is the table number of the new order.
     */
    public static void newCart(int tableNum) {
        order = new Order(tableNum);
    }

    /**
     * Adds an item to a cart.
     * Does nothing if there is no such item in the menu.
     * @param itemName is the name of the item to add.
     */
    public static void addCartItem(String itemName, int quantity) {
        Item newItem;
        for(Menu menu : menus) {
            newItem = menu.getItem(itemName);
            if(newItem != null) {
                for(int i = 0; i < quantity; i++) {
                    order.addItem(newItem);
                }
            }
        }
    }

    /**
     * Removes an item to a cart.
     * Does nothing if there is no such item in the menu.
     * @param itemName is the name of the item to remove.
     */
    public static void removeCartItem(String itemName, int quantity) {
        Item newItem;
        for(Menu menu : menus) {
            newItem = menu.getItem(itemName);
            if(newItem != null) {
                for(int i = 0; i < quantity; i++) {
                    order.removeItem(newItem);
                }
            }
        }
    }

    /**
     * Clears the cart.
     */
    public static void clearCart() {
        order = null;
    }

    /**
     * Makes an order.
     * The order made moves to the order records.
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
     * Checks if the cart is empty.
     * @return true if cart is empty, false if it has an ongoing one.
     */
    public static boolean isEmpty() {
        return order == null;
    }

    /**
     * A getter for the ongoing, unpaid order.
     * @return Order that is an ongoing, unpaid one.
     */
    public static Order getCart() {
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
