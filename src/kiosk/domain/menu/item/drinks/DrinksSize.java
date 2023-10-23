package kiosk.domain.menu.item.drinks;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DrinksSize {
    REGULAR(1, "Regular"), LARGE(2, "Large");

    public static final int DRINKS_SIZE = DrinksSize.values().length;

    private static final Map<Integer, String> DRINKS_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(DrinksSize::getValue, DrinksSize::getName)));


    private final int value;

    private final String name;

    DrinksSize(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static String getDrinksSizeNameByMenuNumber(int menuNumber) {
        return DRINKS_MAP.get(menuNumber);
    }
}
