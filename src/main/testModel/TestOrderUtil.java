package main.testModel;

import main.model.group.Menu;
import main.model.group.Order;
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
        OrderUtil.newCart(1);
    }

    @Test
    void testStartOrder() {
        assertEquals(1, OrderUtil.getCart().getTable());
    }

    @Test
    void testAddItem() {
        OrderUtil.addCartItem("a", 1);
        assertEquals(2, testMenu.numItem());
        assertEquals(10, OrderUtil.getCart().getTotal());
        OrderUtil.removeCartItem("a", 1);
    }

    @Test
    void testRemoveItem() {
        OrderUtil.addCartItem("a", 1);
        assertEquals(10, OrderUtil.getCart().getTotal());

        OrderUtil.removeCartItem("a", 1);
        assertEquals(0, OrderUtil.getCart().getTotal());
    }

    @Test
    void testMakeOrder() {
        OrderUtil.addCartItem("a", 1);
        OrderUtil.makeOrder();

        assertNull(OrderUtil.getCart());
        assertEquals(1, OrderUtil.getCurrentOrders().numItems());
        assertTrue(OrderUtil.isEmpty());
    }

    @Test
    void testPayOrder() {
        OrderUtil.addCartItem("a", 1);
        OrderUtil.makeOrder();
        OrderUtil.payOrder((Order) OrderUtil.getCurrentOrders().getList().get(0));

        assertEquals(0, OrderUtil.getCurrentOrders().numOrders());
        assertEquals(1, OrderUtil.getOrderRecords().numOrders());
        assertEquals(10, OrderUtil.getSales());
    }
}
