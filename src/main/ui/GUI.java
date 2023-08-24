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
    protected MainPanel mainPane;
    private ButtonHandler buttonHandler;
    private JLabel clock;
    private Timer timer;
    public static final int WINDOW_WIDTH = 650;
    public static final int WINDOW_HEIGHT = 550;

    /**
     * Creates a GUI by setting its window and panes.
     */
    public GUI() {
        super("The Story Cafe");
        this.menus = MenuGetter.getInstance().getMenus();
        OrderUtil.initUtil(menus);
        this.buttonHandler = new ButtonHandler(this);
        mainPane = new MainPanel(buttonHandler);

        add(mainPane);
        setWindowLoc();

        setResizable(false);
        setVisible(true);
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
