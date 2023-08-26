package main.ui;

import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a pane that shows current unpaid orders.
 */
public class CheckOrdersPane extends JSplitPane {
    protected ButtonHandler buttonHandler;
    protected final int DIVIDER_LOC = 480;
    protected JScrollPane orderPane;
    protected JPanel buttonPane;
    protected JTextArea emptyCartText;
    protected OrderJList orderJList;

    /**
     * Creates a current orders pane.
     * @param buttonHandler to handle button click events.
     */
    public CheckOrdersPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        setPanes();
    }

    /**
     * Sets up this pane to be horizontally split into two panes: a record pane and a pane with a button.
     */
    protected void setPanes() {
        setOrderDisplayPane();
        setButtonPane();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setEnabled(false);

        setLeftComponent(orderPane);
        setRightComponent(buttonPane);
    }

    /**
     * Sets up a scrollable order pane that shows current unpaid orders.
     */
    protected void setOrderDisplayPane() {
        orderPane = new JScrollPane();

        emptyCartText = new JTextArea();
        orderJList = new OrderJList(OrderUtil.getCurrentOrders().getList());

        showOrders();

        orderPane.setPreferredSize(new Dimension(500, 350));
        orderPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        orderPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    /**
     * Sets up a button pane that has a back button.
     */
    protected void setButtonPane() {
        buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.Y_AXIS));

        JPanel emptySpace = new JPanel();
        emptySpace.setPreferredSize(new Dimension(500, 340));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout(2, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(e -> {
            if(!orderJList.isSelectionEmpty()) {
                buttonHandler.confirmPayment(orderJList.getSelectedValue());
            }
        });
        buttonSpace.add(payButton);

        buttonPane.add(emptySpace);
        buttonPane.add(buttonSpace);
    }

    /**
     * Shows unpaid orders to an order pane.
     */
    protected void showOrders() {
        //  If there is no current order.
        if(OrderUtil.getCurrentOrders().numOrders() == 0) {
            emptyCartText.setText("There is no current order.");
            orderPane.setViewportView(emptyCartText);
        } else {
            //  If there is any order.
            orderJList.clearSelection();
            orderJList.updateOrderJList();
            orderPane.setViewportView(orderJList);
        }
    }

    /**
     * Clears the selection in the order JList.
     */
    protected void clearSelection() {
        orderJList.clearSelection();
    }
}
