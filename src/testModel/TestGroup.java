package testModel;

import model.single.Item;
import model.group.Group;
import model.group.Menu;
import model.group.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestGroup {
    Group testGroup;
    Menu testMenu;
    Order testOrder;
    Item itemA;
    Item itemB;

    @BeforeEach
    void runBefore() {
        testGroup = new Group();
        testMenu = new Menu("TestMenu");
        testOrder = new Order(0);

        itemA = new Item("A", 10.0);
        itemB = new Item("B", 3.78);
    }

    @Test
    void testAddItem() {
        assertEquals(0, testGroup.numItem());
        assertEquals(0, testMenu.numItem());
        assertEquals(0, testOrder.numItem());

        testGroup.addItem(itemA);
        testMenu.addItem(itemA);
        testOrder.addItem(itemA);

        assertEquals(1, testGroup.numItem());
        assertEquals(1, testMenu.numItem());
        assertEquals(1, testOrder.numItem());
    }

    @Test
    void testRemoveItem() {
        assertEquals(0, testGroup.numItem());
        assertEquals(0, testMenu.numItem());
        assertEquals(0, testOrder.numItem());

        testGroup.addItem(itemA);
        testMenu.addItem(itemA);
        testOrder.addItem(itemA);

        testGroup.addItem(itemB);
        testMenu.addItem(itemB);
        testOrder.addItem(itemB);

        testGroup.removeItem(itemA);
        testMenu.removeItem(itemA);
        testOrder.removeItem(itemA);

        assertEquals(1, testGroup.numItem());
        assertEquals(1, testMenu.numItem());
        assertEquals(1, testOrder.numItem());
    }

    @Test
    void testItemToString() {
        testGroup.addItem(itemA);
        assertEquals("<testItem>\nA / 10.0", testGroup.toString("testItem"));
    }

    @Test
    void testMenuToString() {
        testMenu.addItem(itemB);
        assertEquals("<TestMenu>\nB / 3.78", testMenu.toString());
    }

    @Test
    void testGetName() {
        assertEquals("TestMenu", testMenu.getName());
    }

    @Test
    void testSetName() {
        testMenu.setName("NewMenu");
        assertEquals("NewMenu", testMenu.getName());
    }

    @Test
    void testOrderGetSetDate() {
        testOrder.setDate(LocalDate.now());
        assertEquals(LocalDate.now(), testOrder.getDate());
    }

    @Test
    void testOrderGetSetTable() {
        testOrder.setTable(1);
        assertEquals(1, testOrder.getTable());
    }

    @Test
    void testOrderGetTotal() {
        assertEquals(0, testOrder.getTotal());
    }

    @Test
    void testOrderGetQuantity() {
        assertEquals(0, testOrder.getQuantity(itemA));
    }

    @Test
    void testOrderToString() {
        assertEquals("<" + LocalDate.now() + " / Table No: 0>" +
                "\nTotal 0 items." +
                "\nTotal: 0.0",
                testOrder.toString());

        testOrder.setTable(1);
        testOrder.addItem(itemA);
        testOrder.addItem(itemA);
        assertEquals("<" + LocalDate.now() + " / Table No: 1>" +
                "\nA / 10.0 / 2" +
                "\nTotal 2 items." +
                "\nTotal: 20.0",
                testOrder.toString());

    }
}
