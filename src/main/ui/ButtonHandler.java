package main.ui;

import main.model.group.Menu;
import main.model.util.OrderUtil;

import java.util.List;

/**
 * This class handles button click events in BrunchPlace.
 */
public class ButtonHandler {
    private List<Menu> menus;

    /**
     * Creates a ButtonHandler with a given food menu.
     * @param menus to use
     */
    public ButtonHandler(List<Menu> menus) {
        this.menus = menus;
    }


    public void takeOrder() {

        OrderUtil.startOrder(0);
    }
}
