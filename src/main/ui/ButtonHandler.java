package main.ui;

import main.model.group.Menu;
import main.model.single.Item;
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
        this.menus = MenuGetter.getInstance().getMenus();
        this.gui = gui;
    }

    /**
     * Gives two options -- take-out or dine-in -- to the user and takes an order based on the user input.
     */
    public void takeOrder() {
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
        gui.mainPanel.openTakeOrderPanel();
    }

    /**
     * Adds an item to the cart based on the user input.
     * @param item to be added.
     */
    public void addItemToCart(Item item) {
        int quantity = askNum("Enter a quantity:", 1);
        if(quantity == -1) {
            return;
        }
        OrderUtil.addCartItem(item.getName(), quantity);
        gui.mainPanel.takeOrderPanel.updateCart();
    }

    /**
     * A helper method to ask for a user input in integer.
     * Asks again if the input is invalid; e.g. non-integer or less than min.
     * @param question to ask the user.
     * @return the user integer input.
     */
    private int askNum(String question, int min) {
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
     * Opens a main menu.
     * It clears the cart.
     */
    public void openMainMenu() {
        gui.mainPanel.openMainMenu();
        OrderUtil.clearCart();
        gui.mainPanel.takeOrderPanel.updateCart();
    }

    /**
     * Make an order.
     * It goes back to the main menu.
     */
    public void makeOrder() {
        OrderUtil.makeOrder();
        JOptionPane.showMessageDialog(new JFrame(), "Order Completed.");
        openMainMenu();
    }
}
