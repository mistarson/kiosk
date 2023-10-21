package kiosk.item;

import kiosk.Category;

public class Burgers extends Item{

    private BurgersSize burgersSize;

    public Burgers(String name, String description, Category category, int price, BurgersSize burgersSize) {
        super(name, description, category, price);
        this.burgersSize = burgersSize;
    }

    public BurgersSize getBurgersSize() {
        return burgersSize;
    }
}
