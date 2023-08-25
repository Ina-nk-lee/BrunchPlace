package main.ui;

import main.model.group.Group;
import main.model.group.Order;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderHistoryPane extends OrderPane {
    private Order selected;

    /**
     * Creates an order history pane.
     * @param buttonHandler to handle button click events.
     */
    public OrderHistoryPane(ButtonHandler buttonHandler) {
        super(buttonHandler);
        setOrderJListListener();
    }

    /**
     * Sets up a button pane that has a back button.
     */
    @Override
    protected void setButtonPane() {
        super.buttonPane = new JPanel();
        super.buttonPane.setLayout(new BoxLayout(super.buttonPane, BoxLayout.Y_AXIS));

        JPanel emptySpace = new JPanel();
        emptySpace.setPreferredSize(new Dimension(500, 310));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout(2, 1));

        JButton payButton = new JButton("Remove");
        payButton.addActionListener(e -> {
            if(selected != null) {
                buttonHandler.checkPayment(selected);
            }
        });
        buttonSpace.add(payButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        super.buttonPane.add(emptySpace);
        super.buttonPane.add(buttonSpace);
    }

    /**
     * Sets up a selection listener for the order JList.
     */
    private void setOrderJListListener() {
        super.orderJList.addListSelectionListener(e -> selected = super.orderJList.getSelectedValue());
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
            updateOrderJList();
            super.orderPane.setViewportView(super.orderJList);
        }
    }

    /**
     * Converts order history to an orderJList(JList).
     */
    @Override
    protected void updateOrderJList() {
        List<Group> orders = OrderUtil.getOrderRecords().getList();
        Order[] arr = new Order[orders.size()];

        for (int i = 0; i < orders.size(); i++) {
            arr[i] = (Order) orders.get(i);
        }

        orderJList.setListData(arr);
    }
}
