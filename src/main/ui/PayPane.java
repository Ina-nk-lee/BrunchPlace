package main.ui;

import javax.swing.*;
import java.awt.*;

public class PayPane extends CurrentOrdersPane{

    /**
     * Creates a pay pane.
     * @param buttonHandler to handle button click events.
     */
    public PayPane(ButtonHandler buttonHandler) {
        super(buttonHandler);
    }

    /**
     * Sets up a button pane that has a back button.
     */
    @Override
    protected void setButtonPane() {
        super.buttonPane = new JPanel();
        super.buttonPane.setLayout(new BoxLayout(super.buttonPane, BoxLayout.Y_AXIS));

        JPanel emptySpace = new JPanel();
        emptySpace.setPreferredSize(new Dimension(500, 310));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout(2, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        JButton payButton = new JButton("Pay");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(payButton);

        super.buttonPane.add(emptySpace);
        super.buttonPane.add(buttonSpace);
    }
}
