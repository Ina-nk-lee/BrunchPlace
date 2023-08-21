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
    private Menu appsMenu;
    private Menu entreeMenu;
    private Menu drinkMenu;
    private static MenuGetter menuGetter;

    /**
     * Creates a menu and a MenuGetter.
     */
    private MenuGetter() {
        menus = new ArrayList<>();
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
     * A setter for an appetizer menu.
     */
    private void setAppMenu() {
        appsMenu = new Menu("Appetizer");

        Item truffleFries = new App("Truffle Fries", 8.5);
        Item clamChowder = new App("Clam Chowder", 12.0);
        Item beetSalad = new App("Beet Salad", 14.0);

        Item beefCarpaccio = new App("Beef Carpaccio", 19);
        Item calamariFries = new App("Calamari Fries", 15.5);
        Item hotWings = new App("Hot Wings", 12.5);

        Item shrimpCocktail = new App("Shrimp Cocktail", 11.0);
        Item onionRings = new App("Onion Rings", 7.0);
        Item freshOysters = new App("Fresh Oysters", 3);

        Item honeyMussels = new App("Honey Mussels", 23);

        appsMenu.addItem(truffleFries);
        appsMenu.addItem(clamChowder);
        appsMenu.addItem(beetSalad);
        appsMenu.addItem(beefCarpaccio);
        appsMenu.addItem(calamariFries);
        appsMenu.addItem(hotWings);
        appsMenu.addItem(shrimpCocktail);
        appsMenu.addItem(onionRings);
        appsMenu.addItem(freshOysters);
        appsMenu.addItem(honeyMussels);
    }

    /**
     * A setter for an entree menu.
     */
    private void setEntreeMenu() {
        entreeMenu = new Menu("Entree");

        Item carbonara = new Entree("Carbonara", 19.5);
        Item eggsBenedict = new Entree("Eggs Benedict", 21);
        Item chickenFrenchToast = new Entree("Chicken Toast", 22);

        Item avocadoToast = new Entree("Avocado Toast", 17);
        Item eggInHell = new Entree("Egg In Hell", 18.5);
        Item englishBreakfast = new Entree("English Breakfast", 14.5);

        Item porkBellyPancakes = new Entree("Pancakes", 20.5);

        entreeMenu.addItem(carbonara);
        entreeMenu.addItem(eggsBenedict);
        entreeMenu.addItem(chickenFrenchToast);
        entreeMenu.addItem(avocadoToast);
        entreeMenu.addItem(eggInHell);
        entreeMenu.addItem(englishBreakfast);
        entreeMenu.addItem(porkBellyPancakes);
    }

    /**
     * A setter for a drink menu.
     */
    private void setDrinkMenu() {
        drinkMenu = new Menu("Drink");

        Item lemonSour = new Drink("Lemon Sour", 11.0);
        Item mimosa = new Drink("Mimosa", 10);
        Item coffee = new Drink("Coffee", 4.5);

        drinkMenu.addItem(lemonSour);
        drinkMenu.addItem(mimosa);
        drinkMenu.addItem(coffee);
    }

    /**
     * A getter of a MenuGetter's menu.
     * @return a menu.
     */
    public List<Menu> getMenus() {
        return menus;
    }
}
