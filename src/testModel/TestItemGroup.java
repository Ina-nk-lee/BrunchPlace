package testModel;

import model.item.Item;
import model.itemGroup.Items;
import model.itemGroup.Menu;
import model.itemGroup.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestItemGroup {
    Items testItems;
    Menu testMenu;
    Order testOrder;
    Item itemA;
    Item itemB;

    @BeforeEach
    void runBefore() {
        testItems = new Items();
        testMenu = new Menu("TestMenu");
        testOrder = new Order(0);

        itemA = new Item("A", 10.0);
        itemB = new Item("B", 3.78);
    }

    @Test
    void testAddItem() {
        assertEquals(0, testItems.numItem());
        assertEquals(0, testMenu.numItem());
        assertEquals(0, testOrder.numItem());

        testItems.addItem(itemA);
        testMenu.addItem(itemA);
        testOrder.addItem(itemA);

        assertEquals(1, testItems.numItem());
        assertEquals(1, testMenu.numItem());
        assertEquals(1, testOrder.numItem());
    }

    @Test
    void testRemoveItem() {
        assertEquals(0, testItems.numItem());
        assertEquals(0, testMenu.numItem());
        assertEquals(0, testOrder.numItem());

        testItems.addItem(itemA);
        testMenu.addItem(itemA);
        testOrder.addItem(itemA);

        testItems.addItem(itemB);
        testMenu.addItem(itemB);
        testOrder.addItem(itemB);

        testItems.removeItem(itemA);
        testMenu.removeItem(itemA);
        testOrder.removeItem(itemA);

        assertEquals(1, testItems.numItem());
        assertEquals(1, testMenu.numItem());
        assertEquals(1, testOrder.numItem());
    }

    @Test
    void testItemToString() {
        testItems.addItem(itemA);
        assertEquals("<testItem>\nA / 10.0", testItems.toString("testItem"));
    }

    @Test
    void testMenuToString() {
        testMenu.addItem(itemB);
        assertEquals("<testMenu>\nB / 3.78", testMenu.toString("testMenu"));
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
}
