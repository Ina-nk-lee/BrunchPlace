package main.ui;

import main.model.group.Menu;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GUI extends JFrame {
    private List<Menu> menus;
    private MainMenuPanel mainMenuPanel;
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 500;
    public GUI() {
        super("The Story Cafe");
        this.menus = MenuGetter.getInstance().getMenus();

        mainMenuPanel = new MainMenuPanel(menus);

        add(mainMenuPanel);
        windowConfig();

        setResizable(false);
        setVisible(true);
    }

    public void windowConfig() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - WINDOW_WIDTH) / 2;
        int y = ((screenSize.height - WINDOW_HEIGHT) / 2);
        setBounds(x, y, WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}
