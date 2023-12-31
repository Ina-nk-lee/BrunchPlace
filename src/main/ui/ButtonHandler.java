package main.ui;

import main.model.group.Menu;
import main.model.group.Order;
import main.model.single.Item;
import main.model.util.MenuUtil;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
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

        int selected = JOptionPane.showOptionDialog(new JFrame(),
                "Take out or Dine-in?",
                "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);


        //  Default table no.
        int tableNo = 0;

        //  If Dine-in was selected
        if(selected == JOptionPane.NO_OPTION) {
            tableNo = askNum("Enter a table number.", 0);

            //  If the user input for the table number is null (cancel), go back to the main menu.
            if(tableNo == -1) {
                return;
            }
        }

        //  If the dialog window was closed
        if(selected == JOptionPane.CLOSED_OPTION) {
            return;
        }

        //  Takes an order based on the table number.
        OrderUtil.newCart(tableNo);
        gui.mainPane.openTakeOrder();
    }

    /**
     * Shows current orders to process payments.
     */
    protected void openPay() {
        gui.mainPane.openCurrentOrders();
        gui.mainPane.currentOrdersPane.showOrders();
    }

    /**
     * Shows current orders to process payments.
     */
    protected void openOrderHistory() {
        gui.mainPane.openOrderHistory();
        gui.mainPane.historyPane.showOrders();
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

    /**
     * Confirms the payment with a dialog before processing it.
     * @param order to be paid.
     */
    protected void confirmPayment(Order order) {
        JPanel pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

        JLabel question = new JLabel("Process Payment?");
        question.setPreferredSize(new Dimension(130, 50));

        JScrollPane orderPane = new JScrollPane();
        JTextPane orderLog = new JTextPane();
        orderLog.setContentType("text/html");
        orderLog.setText(order.toString());

        orderPane.setViewportView(orderLog);
        orderPane.setPreferredSize(new Dimension(130, 350));
        orderPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        orderPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pane.add(question);
        pane.add(orderPane);

        int choice = JOptionPane.showConfirmDialog(new JFrame(), pane, "Pay Confirmation", JOptionPane.YES_NO_OPTION);

        if(choice == JOptionPane.YES_OPTION) {
            OrderUtil.payOrder(order);
            JOptionPane.showMessageDialog(new JFrame(), "Payment Completed.");
            gui.mainPane.currentOrdersPane.clearSelection();
            openMainMenu();
        } else {
            gui.mainPane.currentOrdersPane.clearSelection();
        }
    }
}
