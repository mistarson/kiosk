package kiosk;

import kiosk.item.Item;

import java.util.Objects;

public class OrderItem  {

    private final String name;

    private final int price;

    private final String description;

    private int count;

    public OrderItem(String name, int price, String description, int count) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
    }

    public static OrderItem from(Item item) {
        return new OrderItem(item.getName(), item.getPrice(), item.getDescription(), 1);
    }

    public void addCount() {
        count++;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return getPrice() == orderItem.getPrice() &&
                Objects.equals(getName(), orderItem.getName()) &&
                Objects.equals(getDescription(), orderItem.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getDescription());
    }
}
