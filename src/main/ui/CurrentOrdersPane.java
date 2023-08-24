package main.ui;

import main.model.group.Group;
import main.model.group.Order;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents a pane that shows current unpaid orders.
 */
public class CurrentOrdersPane extends JSplitPane {
    private ButtonHandler buttonHandler;
    private final int DIVIDER_LOC = 480;
    private JScrollPane orderPane;
    private JPanel buttonPane;
    JTextArea emptyText;
    JList<Order> orderList;

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

//        currentOrders = new JTextArea("");
//        loadCurrOrders();
//        currentOrders.setEditable(false);
        emptyText = new JTextArea();
        loadCurrOrders();
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
            emptyText.setText("There is no current order.");
            orderPane.setViewportView(emptyText);
        } else {
            setOrderList();
            orderPane.setViewportView(orderList);
        }
    }

    private void setOrderList() {
        List<Group> orders = OrderUtil.getCurrentOrders().getList();
        Order[] arr = new Order[orders.size()];

        for (int i = 0; i < orders.size(); i++) {
            arr[i] = (Order) orders.get(i);
        }

        orderList = new JList<>(arr);
        orderList.setCellRenderer(new jListCellRenderer());
        orderList.setLayoutOrientation(JList.VERTICAL);
        orderList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    private class jListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Order order = (Order) value;
            // &lt; is "<", and &nbsp; is a tab in HTML.
//            String labelText = "<html> &lt;" + order.getDate().toString() + "><br>" +
//                    "Table No: &nbsp;&nbsp;" + order.getTable() + "<br>" +
//                    "------------------" + "<br>";
            String labelText = order.toString();
            setText(labelText);

            return this;
        }

    }
}
