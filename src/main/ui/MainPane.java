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
public class MainPane extends JSplitPane {
    private final ButtonHandler buttonHandler;
    private JPanel topPanel;
    private JPanel bottomPanel;
    protected TakeOrderPane takeOrderPane;
    protected CurrentOrdersPane currOrdersPane;
    protected PayPane payPane;
    private JLabel clock;
    private JButton takeOrder;
    private JButton currentOrders;
    private JButton pay;
    private final int DIVIDER_LOC = 485;
    private final Color borderColor;

    /**
     * Creates a main menu pane with options: take order, pay, and current orders.
     * It also includes a clock on the bottom.
     * @param buttonHandler is a handler for button click events.
     */
    public MainPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        this.borderColor = new Color(173, 216, 230); // sky-blue color

        clock = new JLabel();
        Timer timer = new Timer(1000, e -> clock.setText(new Date().toString()));

        setButtons();
        setPanes();
        timer.start();
    }

    /**
     * Sets the main pane with top and bottom panes.
     * The top pane includes menu options, and the bottom pane includes a clock.
     */
    private void setPanes() {
        GridLayout layout = new GridLayout(3,0);
        layout.setVgap(5);

        topPanel = new JPanel();
        topPanel.setLayout(layout);
        setupBorder(topPanel);

        topPanel.add(takeOrder);
        topPanel.add(currentOrders);
        topPanel.add(pay);

        takeOrderPane = new TakeOrderPane(buttonHandler);
        currOrdersPane = new CurrentOrdersPane(buttonHandler);
        payPane = new PayPane(buttonHandler);

        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.add(clock);

        setOrientation(JSplitPane.VERTICAL_SPLIT);
        setBottomComponent(bottomPanel);
        setEnabled(false);
        openMainMenu();
    }

    /**
     * Sets buttons of the main pane.
     */
    private void setButtons() {
        takeOrder = new JButton("Take Order");
        currentOrders = new JButton("Current Orders");
        pay = new JButton("Pay");

        takeOrder.addActionListener(e -> buttonHandler.openTakeOrder());
        currentOrders.addActionListener(e -> buttonHandler.openCurrOrders());
        pay.addActionListener(e -> buttonHandler.openPay());
    }

    /**
     * Opens a main menu on the top pane.
     */
    protected void openMainMenu() {
        setTopComponent(topPanel);
        setDivider();
    }

    /**
     * Opens a take order pane on the main panel.
     */
    protected void openTakeOrderPanel() {
        setupBorder(takeOrderPane);
        setTopComponent(takeOrderPane);
        setDivider();
    }

    /**
     * Opens a current orders pane on the main panel.
     */
    protected void openCurrentOrderPane() {
        setupBorder(currOrdersPane);
        setTopComponent(currOrdersPane);
        setDivider();
    }

    /**
     * Opens a current orders pane on the main panel.
     */
    protected void openPayPane() {
        setupBorder(payPane);
        setTopComponent(payPane);
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
