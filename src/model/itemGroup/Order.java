package model.itemGroup;

import model.item.Item;

import java.time.LocalDate;

public class Order extends Items{
    private LocalDate date;
    private double total;
    private int table;

    //  Creates an Order with an ArrayList, a local date, total = 0, and a given table number.
    //  Table number is 0 if it's to-go.
    public Order(int tableNo) {
        super();
        date = LocalDate.now();
        total = 0;
        table = tableNo;
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
}
