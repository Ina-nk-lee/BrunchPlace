package main.ui;

import main.model.group.Order;

import javax.swing.*;
import java.awt.*;

public class PayPane extends OrderPane {
    protected Order selected;

    /**
     * Creates a pay pane.
     * @param buttonHandler to handle button click events.
     */
    public PayPane(ButtonHandler buttonHandler) {
        super(buttonHandler);
        setOrderJListListener();
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

        JButton payButton = new JButton("Pay");
        payButton.addActionListener(e -> {
            if(selected != null) {
                buttonHandler.checkPayment(selected);
            }
        });
        buttonSpace.add(payButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> buttonHandler.openMainMenu());
        buttonSpace.add(backButton);

        super.buttonPane.add(emptySpace);
        super.buttonPane.add(buttonSpace);
    }

    /**
     * Sets up a selection listener for the order JList.
     */
    private void setOrderJListListener() {
        super.orderJList.addListSelectionListener(e -> selected = super.orderJList.getSelectedValue());
    }
}
