package main.ui;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Date;

/**
 * This class is a main panel of BrunchPlace.
 * The user can take an order, pay, and see a list of current orders.
 */
public class MainPanel extends JSplitPane {
    private final ButtonHandler buttonHandler;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel clock;
    private JButton takeOrder;
    private JButton currentOrders;
    private JButton pay;

    /**
     * Creates a main menu panel with options: take order, pay, and current orders.
     * It also includes a clock on the bottom.
     * @param buttonHandler is a handler for button click events.
     */
    public MainPanel(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;

        clock = new JLabel();
        Timer timer = new Timer(1000, e -> clock.setText(new Date().toString()));

        setButtons();
        setPanels();
        timer.start();
    }

    /**
     * Sets buttons of the main panel.
     */
    private void setButtons() {
        takeOrder = new JButton("Take Order");
        currentOrders = new JButton("Current Orders");
        pay = new JButton("Pay");

        takeOrder.addActionListener(e -> {buttonHandler.takeOrder();});
    }

    /**
     * Sets the main panel with top and bottom panels.
     * The top panel includes menu options, and the bottom panel includes a clock.
     */
    private void setPanels() {
        GridLayout layout = new GridLayout(3,0);
        layout.setVgap(5);

        topPanel = new JPanel();
        topPanel.setLayout(layout);
        topPanel.setBorder(new TitledBorder(new LineBorder(new Color(173, 216, 230), 5), "The Story Cafe"));

        topPanel.add(takeOrder);
        topPanel.add(currentOrders);
        topPanel.add(pay);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(clock);

        setOrientation(JSplitPane.VERTICAL_SPLIT);
        setDividerLocation(435);
        setTopComponent(topPanel);
        setBottomComponent(bottomPanel);
        setEnabled(false);
    }
}
