package model.collection;

import model.group.Group;
import model.group.Menu;

import java.util.ArrayList;

public class MenuCollection extends Collection {
    public MenuCollection() {
        super();
    }

    public void addMenu(Menu menu) {
        super.addGroup(menu);
    }

    public void removeMenu(Menu menu) {
        super.removeGroup(menu);
    }

    private void combineMenu() {
        ArrayList<Group> menuList = super.getMenuList();
        for(Group it : menuList) {

        }
    }
}
