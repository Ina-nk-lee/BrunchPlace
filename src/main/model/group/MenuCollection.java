package main.model.group;

import main.model.single.Item;

import java.util.List;

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

//    // Combine Menus in a single Menu
//    private List<Item> combineMenu() {
//        List<Group> menuList = super.getMenuList();
//        List<Item> combinedMenu = new ArrayList<>();
//
//        for(Group it : menuList) {
//            List<Item> items = it.getItems();
//            combinedMenu.addAll(items);
//        }
//
//        return combinedMenu;
//    }

    //  Converts Menus to String with a shared numbering
    public String toString() {
        StringBuilder result = new StringBuilder();
        List<Group> menuList = super.getList();
        int numbering = 1;

        //  Retrieve each Menu
        for(Group it : menuList) {
            //  Puts the title of each Menu in the beginning
            Menu menu = ((Menu) it);
            result.append("<").append(menu.getName()).append(">").append("\n");

            //  Puts items with a shared numbering.
            for(Item i : it.getItems()) {
                result.append(numbering++).append(". ").append(i.toString()).append("\n");
            }
        }

        //  removes a new line at the end.
        if(result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }
}
