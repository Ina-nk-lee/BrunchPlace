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

        String input = "";
        int tableNo = 0;

        if(option == 1) {
            while(input.equals("")) {
                input = JOptionPane.showInputDialog(new JFrame(), "Enter a table number.");

                //  Goes back if the user put nothing.
                if(input == null) {
                    return;
                }

                //  Asks again if the user put an invalid input.
                try {
                    tableNo = Integer.parseInt(input);
                } catch(NumberFormatException e) {
                    input = "";
                }
            }
        }

        //  Takes an order based on the table number.
        OrderUtil.startOrder(tableNo);
        gui.mainPanel.openTakeOrderPanel();
    }

    public void addItem(Item item) {

    }
}
