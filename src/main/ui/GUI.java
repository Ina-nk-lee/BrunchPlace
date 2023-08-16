package main.ui;

import main.model.group.Menu;
import main.model.util.OrderUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

/**
 * This class represents a GUI of BrunchPlace.
 */
public class GUI extends JFrame {
    private List<Menu> menus;
    private MainPanel mainPanel;
    private ButtonHandler buttonHandler;
    private JLabel clock;
    private Timer timer;
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
        mainPanel = new MainPanel(buttonHandler);

        clock = new JLabel(new Date().toString());
        ActionListener updateClock = e -> clock.setText(new Date().toString());
        timer = new Timer(1000, updateClock);
        timer.start();

        add(mainPanel);
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
