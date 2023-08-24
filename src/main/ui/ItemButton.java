package main.ui;

import main.model.single.Item;

import javax.swing.*;
import java.awt.*;

public class ItemButton extends JButton {
    private Item item;
    private ButtonHandler buttonHandler;

    public ItemButton(Item item, ButtonHandler buttonHandler) {
        super("<html>" + item.getName() + "<br>$" + item.getPrice() + "</html>");
        this.item = item;
        this.buttonHandler = buttonHandler;
        this.setPreferredSize(new Dimension(108, 140));
        this.addActionListener(e -> buttonHandler.addItemToCart(this.item));
    }
}
