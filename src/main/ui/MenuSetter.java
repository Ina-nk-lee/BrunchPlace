package main.ui;

import main.model.group.Menu;
import main.model.single.App;
import main.model.single.Drink;
import main.model.single.Entree;
import main.model.single.Item;

import java.util.ArrayList;
import java.util.List;

public class MenuSetter {
    private List<Menu> menus;

    private MenuSetter() {
        Menu appsMenu = new Menu("Appetizers");
        Menu entreeMenu = new Menu("Entree");
        Menu drinkMenu = new Menu("Drinks");

        Item truffleFries = new App("Truffle Fries", 8.5);
        Item carbonara = new Entree("Carbonara", 19.5);
        Item lemonSour = new Drink("Lemon Sour", 11.0);

        appsMenu.addItem(truffleFries);
        entreeMenu.addItem(carbonara);
        drinkMenu.addItem(lemonSour);

        List<Menu> menuList = new ArrayList<>();
        menuList.add(appsMenu);
        menuList.add(entreeMenu);
        menuList.add(drinkMenu);

        menus = menuList;
    }

    public MenuSetter getInstance() {
        return this;
    }
}
