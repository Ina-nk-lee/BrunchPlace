package main.ui;

import main.model.group.Group;
import main.model.group.Order;
import main.model.util.OrderUtil;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;

/**
 * This class represents a pane that shows current unpaid orders.
 */
public class CurrentOrdersPane extends JSplitPane {
    protected ButtonHandler buttonHandler;
    protected final int DIVIDER_LOC = 480;
    protected JScrollPane orderPane;
    protected JPanel buttonPane;
    private JTextArea emptyCartText;
    private JList<Order> orderJList;

    /**
     * Creates a current orders pane.
     * @param buttonHandler to handle button click events.
     */
    public CurrentOrdersPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        setPanes();
    }

    /**
     * Sets up this pane to be horizontally split into two panes: a record pane and a pane with a button.
     */
    protected void setPanes() {
        setOrderPane();
        setButtonPane();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(orderPane);
        setRightComponent(buttonPane);
        setEnabled(false);
    }

    /**
     * Sets up a scrollable order pane that shows current unpaid orders.
     */
    protected void setOrderPane() {
        orderPane = new JScrollPane();
        emptyCartText = new JTextArea();

        setOrderJList();
        showCurrOrders();

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
        emptySpace.setPreferredSize(new Dimension(500, 380));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        this.buttonPane.add(emptySpace);
        this.buttonPane.add(buttonSpace);
    }

    /**
     * Sets up an orderJList that lists current orders.
     */
    private void setOrderJList() {
        orderJList = new JList<>();
        orderJList.setCellRenderer(new jListCellRenderer());
        orderJList.setLayoutOrientation(JList.VERTICAL);
        orderJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        orderJList.addListSelectionListener(e -> buttonHandler.checkPayment(orderJList.getSelectedValue()));
    }

    /**
     * Shows current unpaid orders to an order pane.
     */
    protected void showCurrOrders() {
        if(OrderUtil.getCurrentOrders().numOrders() == 0) {
            emptyCartText.setText("There is no current order.");
            orderPane.setViewportView(emptyCartText);
        } else {
            updateOrderJList();
            orderPane.setViewportView(orderJList);
        }
    }

    /**
     * Converts current orders to an orderJList(JList).
     */
    private void updateOrderJList() {
        List<Group> orders = OrderUtil.getCurrentOrders().getList();
        Order[] arr = new Order[orders.size()];

        for (int i = 0; i < orders.size(); i++) {
            arr[i] = (Order) orders.get(i);
        }

        orderJList.setListData(arr);
    }

    /**
     * This class is a JList cell renderer for a customized formatted JList to show current orders.
     */
    private class jListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(
                JList list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            Order order = (Order) value;
            String labelText = order.toString();
            setText(labelText);

            JLabel listCellRendererComponent = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
            listCellRendererComponent.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

            return this;
        }

    }
}
