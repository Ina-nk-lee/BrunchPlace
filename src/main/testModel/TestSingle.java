package main.testModel;

import main.model.single.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestSingle {
    Item testItem;
    Item testEntree;
    Item testApp;
    Item testDrink;

    @BeforeEach
    void runBefore() {
        testItem = new Item("TestItem", 3.5);
        testEntree = new Item("TestEntree", 12.93);
        testApp = new Item("TestApp", 8.54);
        testDrink = new Item("TestDrink", 2.0);
    }

    @Test
    void testName() {
        assertEquals("TestItem", testItem.getName());
        testItem.setName("NewName");
        assertEquals("NewName", testItem.getName());

        assertEquals("TestEntree", testEntree.getName());
        testEntree.setName("NewEntree");
        assertEquals("NewEntree", testEntree.getName());

        assertEquals("TestApp", testApp.getName());
        testApp.setName("NewApp");
        assertEquals("NewApp", testApp.getName());

        assertEquals("TestDrink", testDrink.getName());
        testDrink.setName("NewDrink");
        assertEquals("NewDrink", testDrink.getName());
    }

    @Test
    void testPrice() {
        assertEquals(3.5, testItem.getPrice());
        testItem.setPrice(4.9);
        assertEquals(4.9, testItem.getPrice());

        assertEquals(12.93, testEntree.getPrice());
        testEntree.setPrice(18.6);
        assertEquals(18.6, testEntree.getPrice());

        assertEquals(8.54, testApp.getPrice());
        testApp.setPrice(5.87);
        assertEquals(5.87, testApp.getPrice());

        assertEquals(2.0, testDrink.getPrice());
        testDrink.setPrice(1.39);
        assertEquals(1.39, testDrink.getPrice());
    }

    @Test
    void testToString() {
        assertEquals("TestItem / 3.5", testItem.toString());

        assertEquals("TestEntree / 12.93", testEntree.toString());

        assertEquals("TestApp / 8.54", testApp.toString());

        assertEquals("TestDrink / 2.0", testDrink.toString());
    }
}
