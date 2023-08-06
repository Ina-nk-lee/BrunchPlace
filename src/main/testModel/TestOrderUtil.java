package main.testModel;

import main.model.group.Menu;
import main.model.single.Item;
import main.model.util.OrderUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestOrderUtil {
    Menu testMenu;
    List<Menu> testMenuList;
    OrderUtil testOrderUtil;
    Item itemA;
    Item itemB;

    @BeforeEach
    void runBefore() {
        testMenu = new Menu("Test Menu");

        testMenuList = new ArrayList<>();
        testMenuList.add(testMenu);

        itemA = new Item("A", 10);
        itemB = new Item("B", 5);
        testMenu.addItem(itemA);
        testMenu.addItem(itemB);

        testOrderUtil = new OrderUtil(testMenuList);
        testOrderUtil.startOrder(1);
    }

    @Test
    void testStartOrder() {
        assertEquals(1, testOrderUtil.getOrder().getTable());
    }

    @Test
    void testAddItem() {
        testOrderUtil.addItem("a");
        assertEquals(2, testMenu.numItem());
        assertEquals(10, testOrderUtil.getOrder().getTotal());
    }

    @Test
    void testRemoveItem() {
        testOrderUtil.addItem("a");
        assertEquals(10, testOrderUtil.getOrder().getTotal());

        testOrderUtil.removeItem("a");
        assertEquals(0, testOrderUtil.getOrder().getTotal());
    }

    @Test
    void testMakeOrder() {
        testOrderUtil.addItem("a");
        testOrderUtil.makeOrder();

        assertNull(testOrderUtil.getOrder());
        assertEquals(1, testOrderUtil.getOrderRecords().numItems());
        assertTrue(testOrderUtil.isEmpty());
    }
}
