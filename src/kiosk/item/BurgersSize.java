package kiosk.item;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum BurgersSize {
    SINGLE(1, "Single"), DOUBLE(2,"Double");

    public static final int BURGERS_SIZE = BurgersSize.values().length;

    private static final Map<Integer, String> BURGERS_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(BurgersSize::getValue, BurgersSize::getName)));

    private final int value;

    private final String name;

    BurgersSize(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static String getBurgersSizeNameByMenuNumber(int menuNumber) {
        return BURGERS_MAP.get(menuNumber);
    }
}
