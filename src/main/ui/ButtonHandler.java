package main.ui;

import main.model.group.Menu;
import main.model.util.OrderUtil;

import java.util.List;

/**
 * This class handles button click events in BrunchPlace.
 */
public class ButtonHandler {
    private GUI gui;
    private List<Menu> menus;

    /**
     * Creates a ButtonHandler with a given food menu.
     */
    public ButtonHandler(GUI gui) {
        this.menus = MenuGetter.getInstance().getMenus();
        this.gui = gui;
    }


    public void takeOrder() {
        OrderUtil.startOrder(0);
        gui.mainPanel.openPanel(new TakeOrderPanel());

    }
}
