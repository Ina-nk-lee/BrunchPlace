package testModel;

import model.Orders;
import model.item.Item;
import model.itemGroup.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrders {
    Orders testOrders;
    Order OrderA;
    Order OrderB;
    Item itemA;
    Item itemB;

    @BeforeEach
    void runBefore() {
        itemA = new Item("A", 10.0);
        itemB = new Item("B", 3.78);
        OrderA = new Order(0);
        OrderB = new Order(1);
        testOrders = new Orders();

        OrderA.addItem(itemA);
        OrderB.addItem(itemB);
    }

    @Test
    void testAddOrderWithToString() {
        testOrders.addOrder(OrderA);
        testOrders.addOrder(OrderB);

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
    void testRemoveOrderWithToString() {
        testOrders.addOrder(OrderA);
        testOrders.addOrder(OrderB);

        testOrders.removeOrder(OrderA);
        testOrders.removeOrder(OrderB);

        assertEquals("", testOrders.toString());
    }
}
