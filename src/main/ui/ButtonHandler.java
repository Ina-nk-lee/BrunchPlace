package main.ui;

import main.model.group.Menu;
import main.model.group.Order;
import main.model.single.Item;
import main.model.util.MenuUtil;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.util.List;

/**
 * This class handles button click events in BrunchPlace.
 */
public class ButtonHandler {
    private GUI gui;
    private List<Menu> menus;

    /**
     * Creates a ButtonHandler with a given food menu.
     */
    public ButtonHandler(GUI gui) {
        this.menus = MenuUtil.getInstance().getMenus();
        this.gui = gui;
    }

    /**
     * Opens a main menu.
     * It clears the cart.
     */
    protected void openMainMenu() {
        gui.mainPane.openMainMenu();
        OrderUtil.clearCart();
        gui.mainPane.takeOrderPane.updateCart();
    }

    /**
     * Takes an order from the user.
     * Gives two options -- take-out or dine-in -- and takes an order based on the user input.
     */
    protected void openTakeOrder() {
        //  Shows two options: take-out and dine-in.
        Object[] options = {"Take out", "Dine-in"};
        int option = JOptionPane.showOptionDialog(new JFrame(),
                "Take out or Dine-in?",
                "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);

        int tableNo = 0;

        if(option == 1) {
            tableNo = askNum("Enter a table number.", 0);
            if(tableNo == -1) {
                return;
            }
        }

        //  Takes an order based on the table number.
        OrderUtil.newCart(tableNo);
        gui.mainPane.openTakeOrderPanel();
    }

    /**
     * Shows current orders.
     */
    protected void openCurrOrders() {
        gui.mainPane.openCurrentOrderPane();
        gui.mainPane.currOrdersPane.showOrders();
    }

    /**
     * Shows current orders to process payments.
     */
    protected void openPay() {
        gui.mainPane.openPayPane();
        gui.mainPane.payPane.showOrders();
    }

    /**
     * Shows current orders to process payments.
     */
    protected void openOrderHistory() {
        gui.mainPane.openOrderHistoryPane();
        gui.mainPane.orderHistoryPane.showOrders();
    }

    /**
     * Adds an item to the cart based on the user input.
     * @param item to be added.
     */
    protected void addItemToCart(Item item) {
        int quantity = askNum("Enter a quantity:", 1);
        if(quantity == -1) {
            return;
        }
        OrderUtil.addCartItem(item.getName(), quantity);
        gui.mainPane.takeOrderPane.updateCart();
    }

    /**
     * A helper method to ask for a user input in integer.
     * Asks again if the input is invalid; e.g. non-integer or less than min.
     * @param question to ask the user.
     * @return the user integer input.
     */
    protected int askNum(String question, int min) {
        String input = "";
        int num = 0;

        while(input.equals("")) {
            input = JOptionPane.showInputDialog(new JFrame(), question);

            //  If the user put nothing, return -1.
            if(input == null) {
                return -1;
            }

            //  Asks again if the user put an invalid input.
            try {
                num = Integer.parseInt(input);
                if(num < min) {
                    throw new NumberFormatException();
                }
            } catch(NumberFormatException e) {
                input = "";
            }
        }

        return num;
    }

    /**
     * Make an order.
     * It goes back to the main menu.
     */
    protected void makeOrder() {
        OrderUtil.makeOrder();
        JOptionPane.showMessageDialog(new JFrame(), "Order Completed.");
        openMainMenu();
    }

    protected void checkPayment(Order order) {
        OrderUtil.payOrder(order);
        JOptionPane.showMessageDialog(new JFrame(), "Order Paid.");
        openMainMenu();
        System.out.println(OrderUtil.getOrderRecords().toString());
    }
}
