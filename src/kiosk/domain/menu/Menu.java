package kiosk.domain.menu;

public class Menu {

    private final String name;

    private final String description;

    private final Category category;

    protected Menu(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
