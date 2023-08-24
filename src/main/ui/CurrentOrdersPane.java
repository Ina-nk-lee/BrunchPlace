package main.ui;

import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a pane that shows current unpaid orders.
 */
public class CurrentOrdersPane extends JSplitPane {
    private ButtonHandler buttonHandler;
    private final int DIVIDER_LOC = 480;
    private JScrollPane orderPane;
    private JPanel buttonPane;
    JTextArea currentOrders;

    /**
     * Creates a current orders pane.
     * @param buttonHandler to handle button click events.
     */
    public CurrentOrdersPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        setPanes();
    }

    /**
     * Sets this pane to be horizontally split into two panes: a record pane and a pane with a button.
     */
    private void setPanes() {
        setOrderPane();
        setButtonPane();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(orderPane);
        setRightComponent(buttonPane);
        setEnabled(false);
    }

    /**
     * Sets a scrollable order pane that shows current unpaid orders.
     */
    private void setOrderPane() {
        orderPane = new JScrollPane();

        currentOrders = new JTextArea("");
        loadCurrOrders();
        currentOrders.setEditable(false);

        orderPane.setViewportView(currentOrders);
        orderPane.setPreferredSize(new Dimension(500, 350));
        orderPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        orderPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    /**
     * Sets a button pane that has a back button.
     */
    private void setButtonPane() {
        buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));

        JPanel emptySpace = new JPanel();
        emptySpace.setPreferredSize(new Dimension(500, 400));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        this.buttonPane.add(emptySpace);
        this.buttonPane.add(buttonSpace);
    }

    /**
     * Loads most current unpaid orders to an order pane.
     */
    protected void loadCurrOrders() {
        if(OrderUtil.getCurrentOrders().numOrders() == 0) {
            currentOrders.setText("There is no current order.");
        } else {
            currentOrders.setText(OrderUtil.getCurrentOrders().toString());
        }
    }
}
