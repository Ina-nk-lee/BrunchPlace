package model.group;

import model.single.Item;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order extends Items{
    private LocalDate date;
    private double total;
    private int table;
    private int numItems;
    private Map<Item, Integer> orderList;

    //  Creates an Order with an ArrayList, a local date, total = 0, and a given table number.
    //  Table number is 0 if it's to-go.
    public Order(int tableNo) {
        super();
        date = LocalDate.now();
        total = 0;
        table = tableNo;
        numItems = 0;
        orderList = new HashMap<>();
    }

    public void addItem(Item item) {
        super.addItem(item);
        total += item.getPrice();
    }

    public void removeItem(Item item) {
        super.removeItem(item);
        total -= item.getPrice();
    }

    public LocalDate getDate() {
        return date;
    }

    public int numItem() {
        return super.numItem();
    }

    public void setDate(LocalDate newDate) {
        this.date = newDate;
    }

    public double getTotal() {
        return total;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int tableNo) {
        table = tableNo;
    }

    public int getQuantity(Item item) {
        this.updateOrderList();
        return orderList.getOrDefault(item, 0);
    }

    public String toString() {
        //  Update OrderList with a quantity for each item
        this.updateOrderList();

        StringBuilder result = new StringBuilder();
        result.append("<").append(date).append(" / Table No: ").append(table).append(">").append("\n");

        //  toString each item with a quantity
        for (Map.Entry<Item, Integer> entry : orderList.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            result.append(item.toString()).append(" / ").append(quantity).append("\n");
        }

        //  removes a new line at the end.
        if(result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        //  shows the total quantity of the items and the total price.
        result.append("\nTotal ").append(numItems).append(" items.\nTotal: ").append(total);

        return result.toString();
    }

    //  Updates OrderList according to the items(ArrayList) to calculate the quantity of each item.
    private void updateOrderList() {
        for(Item it : super.items) {
            if(orderList.containsKey(it)) {
                orderList.put(it, orderList.get(it) + 1);
            } else {
                orderList.put(it, 1);
            }
            numItems++;
        }
    }
}
