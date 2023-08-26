package main.ui;

import main.model.group.Menu;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a pane used for taking orders.
 */
public class TakeOrderPane extends JSplitPane {
    private List<Menu> menus;
    private MenuTabsPane menuTabsPane;
    private JPanel rightPanel;
    private JTabbedPane tabPanel;
    private JScrollPane cartPane;
    private JPanel buttonPane;
    private JTextPane cart;
    private ButtonHandler buttonHandler;
    private List<ItemButton> itemButtons;
    private final int DIVIDER_LOC = 480;

    /**
     * Creates a panel for taking orders.
     * It takes order based on a menu from MenuGetter.java, which uses a singleton pattern.
     */
    public TakeOrderPane(List<Menu> menus, ButtonHandler buttonHandler) {
        this.menus = menus;
        this.itemButtons = new ArrayList<>();
        this.buttonHandler = buttonHandler;

        setPanels();
    }

    /**
     * Sets this panel, that is divided into two panels horizontally.
     * A menu panel goes to the top, and a list panel goes to the bottom.
     */
    private void setPanels() {
        menuTabsPane = new MenuTabsPane(menus, buttonHandler);
        setRightPane();

        setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        setDividerLocation(DIVIDER_LOC);
        setEnabled(false);

        setLeftComponent(menuTabsPane);
        setRightComponent(rightPanel);
    }

//    /**
//     * Sets a tab for each menu.
//     */
//    private void setTabs() {
//        tabPanel = new JTabbedPane();
//        for(Menu menu : menus) {
//            tabPanel.addTab(menu.getName(), setMenuPane(menu));
//        }
//    }
//
//    /**
//     * Sets a menu pane, which goes into a tab panel.
//     * It shows all the menu items in the menu as buttons.
//     * An item panel that shows all the item buttons in a grid goes on top of a JScrollPane.
//     */
//    private JScrollPane setMenuPane(Menu menu) {
//        // preferred button height = 40
//        // preferred button width = 108
//
//        JPanel itemPanel = new JPanel();
//        itemPanel.setLayout(new GridBagLayout());
//
//        int x = 0;
//        int y = 0;
//
//        for(Item item : menu) {
//            GridBagConstraints constraints = new GridBagConstraints();
//
//            //  Place three items in a row.
//            if(x % 3 == 0) {
//                x = 0;
//                y++;
//            }
//
//            constraints.gridx = x;
//            constraints.gridy = y;
//            constraints.weightx = 1;
//            constraints.fill = GridBagConstraints.HORIZONTAL;
//
//            ItemButton button = new ItemButton(item, buttonHandler);
//            itemButtons.add(button);
//            itemPanel.add(button, constraints);
//
//            x++;
//        }
//
//        JScrollPane menuPane = new JScrollPane(itemPanel);
//        menuPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        menuPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//
//        return menuPane;
//    }

    /**
     * Sets a list panel, which shows all the items in the cart, and an order button.
     * Cart items in a JScrollPane are on the top, and the order button is at the bottom.
     */
    private void setRightPane() {
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

        cart = new JTextPane();
        cart.setEditable(false);
        cart.setContentType("text/html");
        cart.setText("The cart is empty.");

        cartPane = new JScrollPane();
        cartPane.setViewportView(cart);
        cartPane.setPreferredSize(new Dimension(500, 350));
        cartPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        cartPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout(2, 1));

        JButton backButton = new JButton("Back");
        buttonPane.add(backButton);
        backButton.addActionListener(e -> buttonHandler.openMainMenu());

        JButton orderButton = new JButton("Order");
        buttonPane.add(orderButton);
        orderButton.addActionListener(e -> buttonHandler.makeOrder());

        rightPanel.add(cartPane);
        rightPanel.add(buttonPane);
    }

    /**
     * Updates a cart pane to show items currently in the cart.
     */
    public void updateCart() {
        JTextPane cart = (JTextPane) cartPane.getViewport().getView();

        if(!OrderUtil.isEmpty()) {
            cart.setText(OrderUtil.getCart().toString());
        } else {
            cart.setText("The cart is empty.");
        }
    }
}
