package main.ui;

import main.model.group.Menu;
import main.model.single.App;
import main.model.single.Drink;
import main.model.single.Entree;
import main.model.single.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * This class gets a preset menu using a Singleton pattern.
 * Food items can be added by manually editing setMenus in this class.
 */
public class MenuGetter {
    private List<Menu> menus;
    private static MenuGetter menuGetter;

    /**
     * Creates a menu and a MenuGetter.
     */
    private MenuGetter() {
        setMenus();
    }

    /**
     * A getter of a singular MenuGetter instance (Singleton pattern).
     * @return a singular MenuGetter instance.
     */
    public static MenuGetter getInstance() {
        if (menuGetter == null) {
            menuGetter = new MenuGetter();
        }
        return menuGetter;
    }

    /**
     * A setter for a list of menus.
     */
    public void setMenus() {
        Menu appsMenu = new Menu("Appetizers");
        Menu entreeMenu = new Menu("Entree");
        Menu drinkMenu = new Menu("Drinks");

        Item truffleFries = new App("Truffle Fries", 8.5);
        Item clamChowder = new App("Clam Chowder", 12);
        Item beetSalad = new App("Beet Salad", 14);
        Item beefCarpaccio = new App("Beef Carpaccio", 19);

        Item carbonara = new Entree("Carbonara", 19.5);
        Item eggsBenedict = new Entree("Eggs Benedict", 21);
        Item chickenFrenchToast = new Entree("Chicken French Toast", 22);
        Item avocadoToast = new Entree("Avocado Toast", 17);

        Item lemonSour = new Drink("Lemon Sour", 11.0);
        Item mimosa = new Drink("Mimosa", 10);

        appsMenu.addItem(truffleFries);
        appsMenu.addItem(clamChowder);
        appsMenu.addItem(beetSalad);
        appsMenu.addItem(beefCarpaccio);

        entreeMenu.addItem(carbonara);
        entreeMenu.addItem(eggsBenedict);
        entreeMenu.addItem(chickenFrenchToast);
        entreeMenu.addItem(avocadoToast);

        drinkMenu.addItem(lemonSour);
        drinkMenu.addItem(mimosa);

        List<Menu> menuList = new ArrayList<>();
        menuList.add(appsMenu);
        menuList.add(entreeMenu);
        menuList.add(drinkMenu);

        menus = menuList;
    }

    /**
     * A getter of a MenuGetter's menu.
     * @return a menu.
     */
    public List<Menu> getMenus() {
        return menus;
    }
}
