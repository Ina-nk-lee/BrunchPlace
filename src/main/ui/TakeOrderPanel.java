package main.ui;

import main.model.group.Menu;
import main.model.single.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a pane used for taking orders.
 */
public class TakeOrderPanel extends JSplitPane {
    private List<Menu> menus;
    private JScrollPane menuPanel;
    private JPanel listPanel;
    private JScrollPane scrollPane;
    private JPanel orderPane;
    private List<ItemButton> itemButtons;
    private final int DIVIDER_LOC = 480;

    public TakeOrderPanel() {
        menus = MenuGetter.getInstance().getMenus();
        itemButtons = new ArrayList<>();

        setPanels();
    }

    private void setMenuPanel() {
        JPanel itemPanel = new JPanel();
        menuPanel = new JScrollPane(itemPanel);
        itemPanel.setLayout(new GridLayout(0, 3, 0, 0));
        itemPanel.setPreferredSize(new Dimension(400, 500));

        for(Menu menu : menus) {
            for(Item item : menu) {
                ItemButton button = new ItemButton(item);
                itemButtons.add(button);
                itemPanel.add(button);
            }
        }
    }

    private void setListPanel() {
        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));

        scrollPane = new JScrollPane();
        JTextArea cart = new JTextArea("Cart");
        cart.setEditable(false);
        scrollPane.setViewportView(cart);
        scrollPane.setPreferredSize(new Dimension(500, 5000));

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
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(menuPanel);
        setRightComponent(listPanel);
        setEnabled(false);
    }

}
