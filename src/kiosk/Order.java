package kiosk;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> orderItemList = new ArrayList<>();

    private boolean isCanceled = false;

    private int totalPrice;

    public Order() {
    }

    public static Order initialOrder() {
        return new Order();
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void addOrderItem(OrderItem newOrderItem) {

        boolean existSameItem = false;
        for (OrderItem orderItem : orderItemList) {
            if (newOrderItem.equals(orderItem)) {
                existSameItem = true;
                orderItem.addCount();
                break;
            }
        }

        if (!existSameItem) {
            orderItemList.add(newOrderItem);
        }

        totalPrice += newOrderItem.getPrice();
    }

    public void cancelOrder() {
        isCanceled = true;
    }

    public boolean isOrderItemListEmpty() {
        return orderItemList.isEmpty();
    }
}
