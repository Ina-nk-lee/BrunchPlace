package main.model.util;

import main.model.group.Menu;
import main.model.group.Order;
import main.model.group.OrderCollection;
import main.model.single.Item;

import java.util.List;

public class OrderUtil extends Util {
    private static List<Menu> menus;
    private static OrderCollection orders;
    private static Order order;

    public OrderUtil(List<Menu> newMenus) {
        orders = new OrderCollection();
        menus = newMenus;
    }

    public void startOrder(int tableNum) {
        order = new Order(tableNum);
    }

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

    public Order getOrder() {
        return order;
    }
}
