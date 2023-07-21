package testModel;

import model.collection.MenuCollection;
import model.collection.OrderCollection;
import model.group.Menu;
import model.group.Order;
import model.single.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCollection {
    OrderCollection testOrderCollection;
    MenuCollection testMenuCollection;
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
        testOrderCollection = new OrderCollection();

        menuA = new Menu("Menu A");
        menuB = new Menu("Menu B");

        testOrderCollection = new OrderCollection();
        testMenuCollection = new MenuCollection();

        orderA.addItem(itemA);
        orderB.addItem(itemB);

        menuA.addItem(itemA);
        menuB.addItem(itemB);
    }

    @Test
    void testAddOrderWithToString() {
        testOrderCollection.addOrder(orderA);
        testOrderCollection.addOrder(orderB);

        assertEquals("<" + LocalDate.now() + " / Table No: 0>" +
                        "\nA / 10.0 / 1" +
                        "\nTotal 1 items." +
                        "\nTotal: 10.0" +
                        "\n\n<" + LocalDate.now() + " / Table No: 1>" +
                        "\nB / 3.78 / 1" +
                        "\nTotal 1 items." +
                        "\nTotal: 3.78",
                testOrderCollection.toString());
    }

    @Test
    void testAddMenuWithToString() {
        testMenuCollection.addMenu(menuA);
        testMenuCollection.addMenu(menuB);

        assertEquals("<Menu A>" +
                "\nA / 10.0" +
                "\n" +
                "\n<Menu B>" +
                "\nB / 3.78",
                testMenuCollection.toString());
    }

    @Test
    void testRemoveOrderWithToString() {
        testOrderCollection.addOrder(orderA);
        testOrderCollection.addOrder(orderB);

        testOrderCollection.removeOrder(orderA);
        testOrderCollection.removeOrder(orderB);

        assertEquals("", testOrderCollection.toString());
    }

    @Test
    void testRemoveMenuWithToString() {
        testMenuCollection.addMenu(menuA);
        testMenuCollection.addMenu(menuB);

        testMenuCollection.removeMenu(menuA);
        testMenuCollection.removeMenu(menuB);

        assertEquals("", testMenuCollection.toString());
    }
}
