package kiosk.domain.menu;

import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Category {

    BURGERS(1, "Burgers", "앵거스 비프 통살을 다져만든 버거"),
    FROZEN_CUSTARD(2, "Frozen Custard", "매장에서 신선하게 만드는 아이스크림"),
    DRINKS(3, "Drinks", "매장에서 직접 만드는 음료"),
    BEER(4, "Beer", "뉴욕 브루클린 브루어리에서 양조한 맥주");

    private static final Map<Integer, String> CATEGORY_MAP = Collections.unmodifiableMap(
            Stream.of(values()).collect(Collectors.toMap(Category::getValue, Category::getName)));

    public static final int CATEGORY_SIZE = Category.values().length;

    private final int value;
    private final String name;
    private final String description;

    Category(int value, String name, String description) {
        this.value = value;
        this.name = name;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public static String getCategoryNameByMenuNumber(int menuNumber) {
        return CATEGORY_MAP.get(menuNumber);
    }
}
