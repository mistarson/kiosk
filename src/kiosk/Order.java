package kiosk;

import kiosk.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<Item> orderItemList = new ArrayList<>();

    private boolean isCanceled = false;

    private int totalPrice;

    public Order() {
    }

    public static Order initialOrder() {
        return new Order();
    }

    public List<Item> getOrderItemList() {
        return orderItemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addOrderItem(Item item) {
        orderItemList.add(item);
        totalPrice += item.getPrice();
    }

    public void cancelOrder() {
        isCanceled = true;
    }

    public boolean isOrderItemListEmpty() {
        return orderItemList.isEmpty();
    }
}
