package main.model.group;

import main.model.single.Item;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Order extends Group {
    private LocalDate date;
    private double total;
    private int table;
    private int numItems;
    private boolean isOrdered;
    private boolean isPaid;
    private Map<Item, Integer> orderList;

    //  Creates an Order with an ArrayList, a local date, total = 0, and a given table number.
    //  Table number is 0 if it's to-go.
    public Order(int tableNo) {
        super();
        date = LocalDate.now();
        total = 0;
        table = tableNo;
        numItems = 0;
        isOrdered = false;
        isPaid = false;
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

    public boolean isOrdered() {
        return isOrdered;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setOrdered() {
        isOrdered = true;
    }

    public void setPaid() {
        isPaid = true;
    }

    public int getQuantity(Item item) {
        this.updateOrderList();
        return orderList.getOrDefault(item, 0);
    }

    //  Updates OrderList according to the items(ArrayList) to calculate the quantity of each item.
    private void updateOrderList() {
        numItems = 0;
        for(Item curr : this) {
            int count = 0;
            for(Item other : this) {
                if(curr.getName() == )
            }
//            if(orderList.containsKey(it)) {
//                orderList.replace(it, orderList.get(it) + 1);
//            } else {
//                orderList.put(it, 1);
//            }
            numItems++;
        }
    }

    public String toString() {
        //  Update OrderList with a quantity for each item
        this.updateOrderList();

        StringBuilder result = new StringBuilder();
        result.append("<").append(date).append(">")
                .append("\nTable No: ").append(table).append("\n")
                .append("------------------\n");

        //  toString each item with a quantity
        for (Map.Entry<Item, Integer> entry : orderList.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            result.append(item.toString())
                    .append("\n\tx ").append(quantity).append("\n");
        }

        //  shows the total quantity of the items and the total price.
        result.append("------------------\n")
                .append("Items: ").append("\t").append(numItems).append("\n")
                .append("Total: ").append("\t").append(total);

        //  removes a new line at the end.
//        if(result.length() > 0) {
//            result.setLength(result.length() - 1);
//        }

        return result.toString();
    }
}
