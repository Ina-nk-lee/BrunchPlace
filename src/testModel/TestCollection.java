package testModel;

import model.collection.Menus;
import model.collection.Orders;
import model.group.Menu;
import model.group.Order;
import model.single.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCollection {
    Orders testOrders;
    Menus testMenus;
    Order orderA;
    Order orderB;
    Menu menuA;
    Menu menuB;
    Item itemA;
    Item itemB;

    @BeforeEach
    void runBefore() {
        itemA = new Item("A", 10.0);
        itemB = new Item("B", 3.78);

        orderA = new Order(0);
        orderB = new Order(1);
        testOrders = new Orders();

        menuA = new Menu("Menu A");
        menuB = new Menu("Menu B");

        testOrders = new Orders();
        testMenus = new Menus();

        orderA.addItem(itemA);
        orderB.addItem(itemB);

        menuA.addItem(itemA);
        menuB.addItem(itemB);
    }

    @Test
    void testAddOrderWithToString() {
        testOrders.addOrder(orderA);
        testOrders.addOrder(orderB);

        assertEquals("<" + LocalDate.now() + " / Table No: 0>" +
                        "\nA / 10.0 / 1" +
                        "\nTotal 1 items." +
                        "\nTotal: 10.0" +
                        "\n\n<" + LocalDate.now() + " / Table No: 1>" +
                        "\nB / 3.78 / 1" +
                        "\nTotal 1 items." +
                        "\nTotal: 3.78",
                testOrders.toString());
    }

    @Test
    void testAddMenuWithToString() {
        testMenus.addMenu(menuA);
        testMenus.addMenu(menuB);

        assertEquals("<Menu A>" +
                "\nA / 10.0" +
                "\n" +
                "\n<Menu B>" +
                "\nB / 3.78",
                testMenus.toString());
    }

    @Test
    void testRemoveOrderWithToString() {
        testOrders.addOrder(orderA);
        testOrders.addOrder(orderB);

        testOrders.removeOrder(orderA);
        testOrders.removeOrder(orderB);

        assertEquals("", testOrders.toString());
    }

    @Test
    void testRemoveMenuWithToString() {
        testMenus.addMenu(menuA);
        testMenus.addMenu(menuB);

        testMenus.removeMenu(menuA);
        testMenus.removeMenu(menuB);

        assertEquals("", testMenus.toString());
    }
}
