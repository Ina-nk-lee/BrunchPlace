package main.ui;

import main.model.group.Menu;
import main.model.util.OrderUtil;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

/**
 * This class is a panel of a main menu.
 * The user can take an order, pay, and see a list of current orders.
 */
public class MainMenuPanel extends JPanel {
    private JButton takeOrder;
    private JButton currentOrders;
    private JButton pay;
    private ButtonHandler buttonHandler;

    /**
     * Creates a main menu panel with a given food menu list.
     * @param menus is a list of food menus to use in the panel.
     */
    public MainMenuPanel(List<Menu> menus) {
        OrderUtil.initUtil(menus);
        buttonHandler = new ButtonHandler(menus);
        setButtons();
        setPane();
    }

    /**
     * Sets buttons in the main menu panel.
     */
    public void setButtons() {
        takeOrder = new JButton("Take Order");
        currentOrders = new JButton("Current Orders");
        pay = new JButton("Pay");

        takeOrder.addActionListener(e -> {buttonHandler.takeOrder();});
    }

    /**
     * Sets a main menu panel with its components.
     */
    public void setPane() {
        GridLayout layout = new GridLayout(3,0);
        layout.setVgap(5);
        this.setLayout(layout);
        setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 5), "The Story Cafe"));

        this.add(takeOrder);
        this.add(currentOrders);
        this.add(pay);
    }
}
