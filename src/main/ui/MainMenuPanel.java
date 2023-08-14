package main.ui;

import javax.swing.*;

public class MainMenuPanel extends JPanel {
    private JButton takeOrder;
    private JButton currentOrders;
    private JButton pay;
    private ButtonHandler buttonHandler;

    public MainMenuPanel() {
        buttonHandler = new ButtonHandler();
    }

    public void setButtons() {
        takeOrder = new JButton("Take Order");
        currentOrders = new JButton("Current Orders");
        pay = new JButton("Pay");

        takeOrder.addActionListener(e -> {});
    }
}
