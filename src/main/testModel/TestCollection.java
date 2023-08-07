package main.testModel;

import main.model.group.MenuCollection;
import main.model.group.OrderRecords;
import main.model.group.Menu;
import main.model.group.Order;
import main.model.single.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCollection {
    OrderRecords testOrderRecords;
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
        testOrderRecords = new OrderRecords();

        menuA = new Menu("Menu A");
        menuB = new Menu("Menu B");

        testOrderRecords = new OrderRecords();
        testMenuCollection = new MenuCollection();

        orderA.addItem(itemA);
        orderB.addItem(itemB);

        menuA.addItem(itemA);
        menuB.addItem(itemB);
    }

    @Test
    void testAddOrderWithToString() {
        testOrderRecords.addOrder(orderA);
        testOrderRecords.addOrder(orderB);

        assertEquals("1. <" + LocalDate.now() + " / Table No: 0>" +
                        "\nA / 10.0 / 1" +
                        "\nTotal 1 items." +
                        "\nTotal: 10.0" +
                        "\n\n2. <" + LocalDate.now() + " / Table No: 1>" +
                        "\nB / 3.78 / 1" +
                        "\nTotal 1 items." +
                        "\nTotal: 3.78",
                testOrderRecords.toString());
    }

    @Test
    void testAddMenuWithToString() {
        testMenuCollection.addMenu(menuA);
        testMenuCollection.addMenu(menuB);

        assertEquals("<Menu A>" +
                "\n1. A / 10.0" +
                "\n<Menu B>" +
                "\n2. B / 3.78",
                testMenuCollection.toString());
    }

    @Test
    void testRemoveOrderWithToString() {
        testOrderRecords.addOrder(orderA);
        testOrderRecords.addOrder(orderB);

        testOrderRecords.removeOrder(orderA);
        testOrderRecords.removeOrder(orderB);

        assertEquals("", testOrderRecords.toString());
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
