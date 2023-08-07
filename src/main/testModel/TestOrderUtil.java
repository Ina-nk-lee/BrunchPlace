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

        OrderUtil.initUtil(testMenuList);
        OrderUtil.startOrder(1);
    }

    @Test
    void testStartOrder() {
        assertEquals(1, OrderUtil.getOrder().getTable());
    }

    @Test
    void testAddItem() {
        OrderUtil.addItem("a");
        assertEquals(2, testMenu.numItem());
        assertEquals(10, OrderUtil.getOrder().getTotal());
        OrderUtil.removeItem("a");
    }

    @Test
    void testRemoveItem() {
        OrderUtil.addItem("a");
        assertEquals(10, OrderUtil.getOrder().getTotal());

        OrderUtil.removeItem("a");
        assertEquals(0, OrderUtil.getOrder().getTotal());
    }

    @Test
    void testMakeOrder() {
        OrderUtil.addItem("a");
        OrderUtil.makeOrder();

        assertNull(OrderUtil.getOrder());
        assertEquals(1, OrderUtil.getCurrentOrders().numItems());
        assertTrue(OrderUtil.isEmpty());
    }

    @Test
    void testPayOrder() {
        OrderUtil.addItem("a");
        OrderUtil.makeOrder();
        OrderUtil.payOrder(1);

        assertEquals(0, OrderUtil.getCurrentOrders().numOrders());
        assertEquals(1, OrderUtil.getOrderRecords().numOrders());
        assertEquals(10, OrderUtil.getSales());
    }
}
