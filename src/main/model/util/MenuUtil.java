package main.model.util;

import main.model.group.Menu;
import main.model.single.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * This class gets a preset menu using a Singleton pattern.
 * Food items can be added by manually editing setMenus in this class.
 */
public class MenuUtil {
    private List<Menu> menus;
    private Menu appsMenu;
    private Menu entreeMenu;
    private Menu drinkMenu;
    private static MenuUtil menuUtil;

    /**
     * Creates a menu and a MenuGetter.
     */
    private MenuUtil() {
        menus = new ArrayList<>();
        setMenus();
    }

    /**
     * A getter of a singular MenuGetter instance (Singleton pattern).
     * @return a singular MenuGetter instance.
     */
    public static MenuUtil getInstance() {
        if (menuUtil == null) {
            menuUtil = new MenuUtil();
        }
        return menuUtil;
    }

    /**
     * A setter for menus.
     */
    public void setMenus() {
        setAppMenu();
        setEntreeMenu();
        setDrinkMenu();

        menus.add(appsMenu);
        menus.add(entreeMenu);
        menus.add(drinkMenu);
    }

    /**
     * Adds a new item with a given name and price to the appetizer menu.
     * @param name of the new item
     * @param price of the new item
     */
    private void addApp(String name, double price) {
        Item item = new Item(name, price);
        appsMenu.addItem(item);
    }

    /**
     * Adds a new item with a given name and price to the entree menu.
     * @param name of the new item
     * @param price of the new item
     */
    private void addEntree(String name, double price) {
        Item item = new Item(name, price);
        entreeMenu.addItem(item);
    }

    /**
     * Adds a new item with a given name and price to the drink menu.
     * @param name of the new item
     * @param price of the new item
     */
    private void addDrink(String name, double price) {
        Item item = new Item(name, price);
        drinkMenu.addItem(item);
    }

    /**
     * A setter for an appetizer menu.
     */
    private void setAppMenu() {
        appsMenu = new Menu("Appetizer");

        addApp("Truffle Fries", 8.5);
        addApp("Clam Chowder", 12.0);
        addApp("Beet Salad", 14.0);

        addApp("Beef Carpaccio", 19);
        addApp("Calamari Fries", 15.5);
        addApp("Hot Wings", 12.5);

        addApp("Shrimp Cocktail", 11.0);
        addApp("Onion Rings", 7.0);
        addApp("Fresh Oysters", 3);

        addApp("Honey Mussels", 23);
    }

    /**
     * A setter for an entree menu.
     */
    private void setEntreeMenu() {
        entreeMenu = new Menu("Entree");

        addEntree("Carbonara", 19.5);
        addEntree("Eggs Benedict", 21);
        addEntree("Chicken Toast", 22);

        addEntree("Avocado Toast", 17);
        addEntree("Egg In Hell", 18.5);
        addEntree("English Breakfast", 14.5);

        addEntree("Pancakes", 20.5);
    }

    /**
     * A setter for a drink menu.
     */
    private void setDrinkMenu() {
        drinkMenu = new Menu("Drink");

        addDrink("Coffee", 4.5);
        addDrink("London Fog", 5.0);
        addDrink("Earl Grey", 3.0);
        addDrink("Honey Lemon Tea", 3.0);
        addDrink("Orange Juice", 3.5);
    }

    /**
     * A getter of a MenuGetter's menu.
     * @return a menu.
     */
    public List<Menu> getMenus() {
        return menus;
    }
}
