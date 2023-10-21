package kiosk.item;

import kiosk.Category;

public class Drinks extends Item {

    private DrinksSize drinksSize;

    public Drinks(String name, String description, Category category, int price, DrinksSize drinksSize) {
        super(name, description, category, price);
        this.drinksSize = drinksSize;
    }

    public DrinksSize getDrinksSize() {
        return drinksSize;
    }
}
