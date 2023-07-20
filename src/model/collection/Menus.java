package model.collection;

import model.group.Menu;

public class Menus extends Groups{
    public Menus() {
        super();
    }

    public void addMenu(Menu menu) {
        super.addGroup(menu);
    }

    public void removeMenu(Menu menu) {
        super.removeGroup(menu);
    }
}
