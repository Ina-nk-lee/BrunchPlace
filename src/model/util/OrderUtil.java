package model.util;

import model.collection.MenuCollection;
import model.group.Order;
import java.util.Scanner;

public class OrderUtil extends Util {
    Scanner intScan;
    Scanner StrScan;
    MenuCollection menuCollection;
    Order order;

    public OrderUtil(MenuCollection newMenu, Order newOrder) {
        menuCollection = newMenu;
        order = newOrder;

        this.showOptions();
        this.readCommand();
    }

    public void showOptions() {
        System.out.println("Select a number to proceed.");
        System.out.println("1. Add Item");
        System.out.println("2. Remove Item");
        System.out.println("3. Order");
        System.out.println("Press any other button to return to the Main Menu.");
    }

    public void readCommand() {
        intScan = new Scanner(System.in);
        int command = intScan.nextInt();

        switch(command) {
            case 1:
                this.addItem();
            case 2:
                this.removeItem();
            case 3:
                this.makeOrder();
            default:
                break;
        }
    }

    public void addItem() {
        this.printMenu();
    }

    public void removeItem() {

    }

    public void printMenu() {

    }

    public void makeOrder() {

    }
}
