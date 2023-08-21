package main.ui;

import main.model.single.Item;

import javax.swing.*;

public class ItemButton extends JButton {
    public ItemButton(Item item) {
        super("<html><br><br><br>" + item.getName() + "<br>$" + item.getPrice() + "<br><br><br></html>");
    }
}
