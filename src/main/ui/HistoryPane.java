package main.ui;

import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a pane that displays the order history.
 */
public class HistoryPane extends CheckOrdersPane {

    /**
     * Creates an order history pane.
     * @param buttonHandler to handle button click events.
     */
    public HistoryPane(ButtonHandler buttonHandler) {
        super(buttonHandler);
        super.orderJList = new OrderJList(OrderUtil.getOrderRecords().getList());
    }

    /**
     * Sets up a button pane that has a back button and a remove button.
     */
    @Override
    protected void setButtonPane() {
        super.buttonPane = new JPanel();
        super.buttonPane.setLayout(new BoxLayout(super.buttonPane, BoxLayout.Y_AXIS));

        JPanel emptySpace = new JPanel();
        emptySpace.setPreferredSize(new Dimension(500, 340));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout(2, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        JButton payButton = new JButton("Remove");
        payButton.addActionListener(e -> {
            if(!orderJList.isSelectionEmpty()) {
                // buttonHandler.confirmPayment(orderJList.getSelectedValue());
            }
        });
        buttonSpace.add(payButton);

        super.buttonPane.add(emptySpace);
        super.buttonPane.add(buttonSpace);
    }

    /**
     * Shows order history on the order pane.
     */
    @Override
    protected void showOrders() {
        if(OrderUtil.getOrderRecords().numOrders() == 0) {
            super.emptyCartText.setText("There is no order record.");
            super.orderPane.setViewportView(super.emptyCartText);
        } else {
            super.orderJList.clearSelection();
            super.orderJList.updateOrderJList();
            super.orderPane.setViewportView(super.orderJList);

            super.orderPane.setViewportView(super.orderJList);
        }
    }
}
