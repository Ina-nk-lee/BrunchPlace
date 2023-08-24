package main.ui;

import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;

public class CurrentOrdersPane extends JSplitPane {
    private ButtonHandler buttonHandler;
    private final int DIVIDER_LOC = 480;
    private JScrollPane recordPane;
    private JPanel rightPane;
    JTextArea currentOrders;

    public CurrentOrdersPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        setPanes();
    }

    private void setPanes() {
        setRecordPane();
        setRightPane();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(recordPane);
        setRightComponent(rightPane);
        setEnabled(false);
    }

    private void setRecordPane() {
        recordPane = new JScrollPane();

        currentOrders = new JTextArea("");
        loadRecords();
        currentOrders.setEditable(false);

        recordPane.setViewportView(currentOrders);
        recordPane.setPreferredSize(new Dimension(500, 350));
        recordPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        recordPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    }

    private void setRightPane() {
        rightPane = new JPanel();
        rightPane.setLayout(new BoxLayout(rightPane, BoxLayout.Y_AXIS));

        JPanel emptyPane = new JPanel();
        emptyPane.setPreferredSize(new Dimension(500, 400));

        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonPane.add(backButton);

        rightPane.add(emptyPane);
        rightPane.add(buttonPane);
    }

    private void loadRecords() {
        if(OrderUtil.getOrderRecords().numItems() == 0) {
            currentOrders.setText("There is no order.");
        } else {
            currentOrders.setText(OrderUtil.getCurrentOrders().toString());

        }
    }
}
