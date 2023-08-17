package main.ui;

import main.model.group.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents a pane used for taking orders.
 */
public class TakeOrderPanel extends JSplitPane {
    private List<Menu> menus;
    private JPanel menuPanel;
    private JPanel listPanel;
    private JScrollPane scrollPane;
    private JPanel orderPane;

    public TakeOrderPanel() {
        menus = MenuGetter.getInstance().getMenus();
        setPanels();
    }

    private void setMenuPanel() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(3, 3, 3, 3));
        setMenuButtons();
    }

    private void setMenuButtons() {

    }

    private void setListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane();
        JTextArea cart = new JTextArea("text");
        scrollPane.setViewportView(cart);

        orderPane = new JPanel();
        orderPane.setLayout(new GridLayout());
        JButton orderButton = new JButton("Order");
        orderPane.add(orderButton);

        listPanel.add(scrollPane);
        listPanel.add(orderPane);
    }

    private void setPanels() {
        setMenuPanel();
        setListPanel();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(350);
        setLeftComponent(menuPanel);
        setRightComponent(listPanel);
        setEnabled(false);
    }
}
