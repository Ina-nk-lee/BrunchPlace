package main.ui;

import javax.swing.*;
import java.awt.*;

/**
 * This class represents a pane that has buttons at the bottom.
 */
public class ButtonPane extends JPanel {
    private ButtonHandler buttonHandler;

    /**
     * Creates a button pane that has buttons at the bottom.
     * @param buttonHandler to handle button click events.
     */
    public ButtonPane(ButtonHandler buttonHandler) {
        this.buttonHandler = buttonHandler;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(setTopPane());
        this.add(setButtonPane());
    }

    /**
     * Sets up a top box.
     * @return the panel that goes to the top.
     */
    private JPanel setTopPane() {
        JPanel emptySpace = new JPanel();
        emptySpace.setPreferredSize(new Dimension(200, 400));

        return emptySpace;
    }

    /**
     * Sets up a button box with buttons.
     * @return the bottom panel that goes to the bottom.
     */
    private JPanel setButtonPane() {
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new GridLayout());

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonPane.add(backButton);

        return buttonPane;
    }
}
