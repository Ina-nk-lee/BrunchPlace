package main.ui;

import main.model.single.Item;

import javax.swing.*;

public class ItemButton extends JButton {
    public ItemButton(Item item) {
        super("<html>" + item.getName() + "<br>$" + item.getPrice() + "</html>");
    }
}
