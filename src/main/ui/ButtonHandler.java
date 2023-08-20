package main.ui;

import main.model.group.Menu;
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

        if(option == 1) {
            //  If it is a dine-in, it receives a user input for a table number.
            try {
                while(input.equals("")) {
                    input = JOptionPane.showInputDialog(new JFrame(), "Enter a table number.");}
                } catch(NullPointerException e) {
                //  Returns if there is no input.
                return;
            }

            //  If it is a take-out, it automatically chooses 0 for a table number.
        } else {
            input = "0";
        }

        //  Takes an order based on the table number.
        int tableNo = Integer.parseInt(input);
        OrderUtil.startOrder(tableNo);
        gui.mainPanel.openPanel(new TakeOrderPanel());
    }
}
