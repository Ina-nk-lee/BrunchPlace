package main.ui;

import main.model.group.Menu;
import main.model.single.Item;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is a tabbed pane which displays menus.
 * Each tab has a menu that is consist of item buttons.
 */
public class MenuTabsPane extends JTabbedPane {
    private List<ItemButton> itemButtons;
    private List<Menu> menus;
    private ButtonHandler buttonHandler;

    /**
     * Creates a pane with menu tabs.
     * @param menus to be used to create menu tabs.
     * @param buttonHandler to handle menu item button click events.
     */
    public MenuTabsPane(List<Menu> menus, ButtonHandler buttonHandler) {
        this.menus = menus;
        this.buttonHandler = buttonHandler;
        this.itemButtons = new ArrayList<>();

        setTabs();
    }

    /**
     * Adds tabs to this pane.
     * Each tab has a menu.
     */
    private void setTabs() {
        for(Menu menu : menus) {
            this.addTab(menu.getName(), setMenu(menu));
        }
    }

    /**
     * Sets a scrollable pane that has a menu pane inside, and adds item buttons to it based on the given menu.
     */
    private JScrollPane setMenu(Menu menu) {
        JPanel menuPane = new JPanel();
        menuPane.setLayout(new GridBagLayout());

        int col = 0;
        int row = 0;

        for(Item item : menu) {
            GridBagConstraints constraints = new GridBagConstraints();

            //  Place three items in a row.
            if(col % 3 == 0) {
                col = 0;
                row++;
            }

            constraints.gridx = col;
            constraints.gridy = row;
            constraints.weightx = 1;
            constraints.fill = GridBagConstraints.HORIZONTAL;

            ItemButton button = new ItemButton(item, buttonHandler);
            itemButtons.add(button);
            menuPane.add(button, constraints);

            col++;
        }

        JScrollPane scrollPane = new JScrollPane(menuPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        return scrollPane;
    }
}
