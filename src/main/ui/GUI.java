package main.ui;

import main.model.group.Menu;
import main.model.util.MenuUtil;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * This class represents a GUI of BrunchPlace.
 */
public class GUI extends JFrame {
    protected MainPane mainPane;
    public static final int WINDOW_WIDTH = 650;
    public static final int WINDOW_HEIGHT = 550;

    /**
     * Creates a GUI by setting its window and panes.
     */
    public GUI() {
        super("The Story Cafe");
        List<Menu> menus = MenuUtil.getInstance().getMenus();
        OrderUtil.initUtil(menus);
        ButtonHandler buttonHandler = new ButtonHandler(this);
        mainPane = new MainPane(menus, buttonHandler);

        add(mainPane);
        setWindowLoc();

        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Sets this GUI's window location on the screen.
     */
    private void setWindowLoc() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - WINDOW_WIDTH) / 2;
        int y = (screenSize.height - WINDOW_HEIGHT) / 2;
        setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
