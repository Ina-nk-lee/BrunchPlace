package main.ui;

import javax.swing.*;
import java.awt.*;

public class PayPane extends OrderPane {

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
        emptySpace.setPreferredSize(new Dimension(500, 340));

        JPanel buttonSpace = new JPanel();
        buttonSpace.setLayout(new GridLayout(2, 1));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(e -> {
            if(!orderJList.isSelectionEmpty()) {
                buttonHandler.confirmPayment(super.orderJList.getSelectedValue());
            }
        });
        buttonSpace.add(payButton);

        super.buttonPane.add(emptySpace);
        super.buttonPane.add(buttonSpace);
    }
}
