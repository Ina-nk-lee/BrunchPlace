package main.ui;

import main.model.group.Menu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Date;
import java.util.List;

/**
 * This class is a main menu pane of BrunchPlace.
 * The user can take an order, check current orders, pay them, and check order history.
 */
public class MainPane extends JSplitPane {
    private final ButtonHandler buttonHandler;
    private JPanel topPane;
    private JPanel bottomPane;
    protected TakeOrderPane takeOrderPane;
    protected CheckOrdersPane currentOrdersPane;
    protected HistoryPane historyPane;
    private JLabel clock;
    private final int DIVIDER_LOC = 485;
    private final Color borderColor;

    /**
     * Creates a main menu pane with options: take order, current orders / pay, and order history.
     * It also includes a clock at the bottom.
     * @param buttonHandler is a handler for button click events.
     */
    public MainPane(List<Menu> menus, ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        this.borderColor = new Color(173, 216, 230); // a sky-blue color border.

        takeOrderPane = new TakeOrderPane(menus, buttonHandler);
        currentOrdersPane = new CheckOrdersPane(buttonHandler);
        historyPane = new HistoryPane(buttonHandler);

        clock = new JLabel();
        Timer timer = new Timer(1000, e -> clock.setText(new Date().toString()));
        timer.start();

        setPanes();
    }

    /**
     * Sets the main pane with top and bottom panes.
     * The top pane includes menu options, and the bottom pane includes a clock.
     */
    private void setPanes() {
        setTopPane();
        setBottomPane();

        setOrientation(JSplitPane.VERTICAL_SPLIT);
        setDivider();
        setEnabled(false);

        setTopComponent(topPane);
        setBottomComponent(bottomPane);
    }

    /**
     * Sets up the top pane with menu option buttons.
     */
    private void setTopPane() {
        JButton takeOrder = new JButton("Take Order");
        JButton currentOrders = new JButton("Current Order / Payment");
        JButton orderHistory = new JButton("Order History");

        takeOrder.addActionListener(e -> buttonHandler.openTakeOrder());
        currentOrders.addActionListener(e -> buttonHandler.openPay());
        orderHistory.addActionListener(e -> buttonHandler.openOrderHistory());

        topPane = new JPanel();
        topPane.setLayout(new GridLayout(3,0));
        setupBorder(topPane);

        topPane.add(takeOrder);
        topPane.add(currentOrders);
        topPane.add(orderHistory);
    }

    /**
     * Sets up the bottom pane with a clock.
     */
    private void setBottomPane() {
        bottomPane = new JPanel();
        bottomPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPane.add(clock);
    }

    /**
     * Opens a main menu on the top pane.
     */
    protected void openMainMenu() {
        setTopComponent(topPane);
        setDivider();
    }

    /**
     * Opens a take order pane on the main panel.
     */
    protected void openTakeOrder() {
        setupBorder(takeOrderPane);
        setTopComponent(takeOrderPane);
        setDivider();
    }

    /**
     * Opens a current orders pane on the main panel.
     */
    protected void openCurrentOrders() {
        setupBorder(currentOrdersPane);
        setTopComponent(currentOrdersPane);
        setDivider();
    }

    /**
     * Opens an order history pane on the main panel.
     */
    protected void openOrderHistory() {
        setupBorder(historyPane);
        setTopComponent(historyPane);
        setDivider();
    }

    /**
     * Sets a horizontal divider at a default location.
     */
    private void setDivider() {
        setDividerLocation(DIVIDER_LOC);
    }

    /**
     * Sets up a colored border around the given component.
     * @param component to wrap the border around.
     */
    private void setupBorder(JComponent component) {
        component.setBorder(new TitledBorder(new LineBorder(borderColor, 5), "The Story Cafe"));
    }
}
