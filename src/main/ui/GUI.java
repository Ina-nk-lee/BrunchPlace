package main.ui;

import main.model.group.Menu;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents a GUI of BrunchPlace.
 */
public class GUI extends JFrame {
    private List<Menu> menus;
    private MainMenuPanel mainMenuPanel;
    private ButtonHandler buttonHandler;
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;

    /**
     * Creates a GUI by setting its window and panels.
     */
    public GUI() {
        super("The Story Cafe");
        this.menus = MenuGetter.getInstance().getMenus();
        OrderUtil.initUtil(menus);
        this.buttonHandler = new ButtonHandler(menus);

        mainMenuPanel = new MainMenuPanel(buttonHandler);

        add(mainMenuPanel);
        setWindowLoc();

        setResizable(false);
        setVisible(true);
    }

    /**
     * Sets this GUI's window location on the screen.
     */
    public void setWindowLoc() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - WINDOW_WIDTH) / 2;
        int y = (screenSize.height - WINDOW_HEIGHT) / 2;
        setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
