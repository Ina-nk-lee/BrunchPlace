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
    private JPanel listPanel;
    private JTabbedPane tabPanel;
    private JScrollPane scrollPane;
    private JPanel orderPane;
    private List<ItemButton> itemButtons;
    private final int DIVIDER_LOC = 480;

    /**
     * Creates a panel for taking orders.
     * It takes order based on a menu from MenuGetter.java, which uses a singleton pattern.
     */
    public TakeOrderPanel() {
        menus = MenuGetter.getInstance().getMenus();
        itemButtons = new ArrayList<>();

        setPanels();
    }

    /**
     * Sets this panel, that is divided into two panels horizontally.
     * A menu panel goes to the top, and a list panel goes to the bottom.
     */
    private void setPanels() {
        setTabs();
        setListPanel();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setLeftComponent(tabPanel);
        setRightComponent(listPanel);
        setEnabled(false);
    }

    private void setTabs() {
        tabPanel = new JTabbedPane();
        for(Menu menu : menus) {
            tabPanel.addTab(menu.getName(), setMenuPane(menu));
        }
    }

    /**
     * Sets a menu pane, which goes into a tab panel.
     * It shows all the menu items in the menu as buttons.
     * An item panel that shows all the item buttons in a grid goes on top of a JScrollPane.
     */
    private JScrollPane setMenuPane(Menu menu) {
        // preferred button height = 40
        // preferred button width = 108

        JPanel itemPanel = new JPanel();
        itemPanel.setLayout(new GridBagLayout());

        int x = 0;
        int y = 0;

        for(Item item : menu) {
            GridBagConstraints constraints = new GridBagConstraints();

            if(x % 3 == 0) {
                x = 0;
                y++;
            }

            constraints.gridx = x;
            constraints.gridy = y;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;

            ItemButton button = new ItemButton(item);
            button.setPreferredSize(new Dimension(108, 150));
            itemButtons.add(button);
            itemPanel.add(button, constraints);

            x++;
        }

        JScrollPane menuPane = new JScrollPane(itemPanel);
        itemPanel.setPreferredSize(new Dimension(itemPanel.getPreferredSize().width, itemPanel.getPreferredSize().height));
        menuPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        menuPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        return menuPane;
    }

    /**
     * Sets a list panel, which shows all the items in the cart, and an order button.
     * Cart items in a JScrollPane are on the top, and the order button is at the bottom.
     */
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
}
