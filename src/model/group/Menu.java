package model.group;

public class Menu extends Group {
    private String name;

    public Menu(String menuName) {
        super();
        name = menuName;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public String toString() {
        return super.toString(name);
    }
}
