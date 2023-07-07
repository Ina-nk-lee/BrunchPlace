package model.itemGroup;

public class Menu extends Items{
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

}
