package kiosk.domain.menu.item;

import kiosk.domain.menu.Category;
import kiosk.domain.menu.Menu;

public class Item extends Menu {

    private final int price;

    public Item(String name, String description, Category category, int price) {
        super(name, description, category);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

}
