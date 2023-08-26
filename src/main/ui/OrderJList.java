package main.ui;

import main.model.group.Group;
import main.model.group.Order;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.util.List;

/**
 * This class represents a JList to display orders and allow the user to select one of them.
 */
public class OrderJList extends JList<Order>{
    List<Group> orders;

    /**
     * Creates a JList for orders.
     * Only a single order can be selected.
     * @param orders to be converted into a JList.
     */
    public OrderJList(List<Group> orders) {
        this.orders = orders;

        setCellRenderer(new jListCellRenderer());
        setLayoutOrientation(JList.VERTICAL);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    /**
     * Converts current orders to a JList with orders.
     */
    protected void updateOrderJList() {
        Order[] arr = new Order[orders.size()];

        for (int i = 0; i < orders.size(); i++) {
            arr[i] = (Order) orders.get(i);
        }

        this.setListData(arr);
    }

    /**
     * This class is a JList cell renderer for a customized formatted JList to show current orders.
     */
    private static class jListCellRenderer extends DefaultListCellRenderer {
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
