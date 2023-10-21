package kiosk;

import kiosk.item.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static kiosk.Category.getCategoryNameByMenuNumber;
import static kiosk.constant.Constant.*;
import static kiosk.database.KioskDatabase.*;


public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Order order = Order.initialOrder();

        while (true) {

            // 메인 메뉴 화면
            // TODO try-catch 중복 코드 해결하기
            int mainMenuNumber;
            try {
                mainMenuNumber = Screen.mainMenuScreen();
            } catch (IllegalArgumentException e) {
                System.out.println(WRONG_MENU_NUMBER + "\n");
                continue;
            }

            if (isItemMenuNumber(mainMenuNumber)) {
                String categoryName = getCategoryNameByMenuNumber(mainMenuNumber);
                List<Item> ItemListByCategoryNameLimit1 = getItemListByCategoryNameLimit1(categoryName);

                // 상품 메뉴 화면
                String itemName;
                try {
                    itemName = Screen.itemMenuScreen(categoryName, ItemListByCategoryNameLimit1);
                } catch (IllegalArgumentException e) {
                    System.out.println(WRONG_MENU_NUMBER + "\n");
                    continue;
                }

                // 옵션으로 선택하기
                List<Item> itemList = getItemListByItemName(itemName);

                Item item = itemList.get(0);
                if (HasOptionCategory(categoryName)) {
                    try {
                        item = Screen.selectOptionMenuScreen(itemList, categoryName);
                    } catch (IllegalArgumentException e) {
                        System.out.println(WRONG_MENU_NUMBER + "\n");
                        continue;
                    }
                }

                // 구매 화면
                int buyMenuNumber;
                try {
                    buyMenuNumber = Screen.buyMenuScreen(item);
                } catch (IllegalArgumentException e) {
                    System.out.println(WRONG_MENU_NUMBER + "\n");
                    continue;
                }

                if (buyMenuNumber == CONFIRM) {

                    order.addOrderItem(OrderItem.from(item));

                    Screen.buyCompletedScreen(item.getName());
                }
            }

            // 주문 관련 메뉴
            else {
                if (mainMenuNumber == ORDER_MENU_NUMBER) {

                    if (order.isOrderItemListEmpty()) {
                        System.out.println(EMPTY_ORDER_PRODUCT + "\n");
                        continue;
                    }

                    // 주문 화면
                    int orderConfirmMenuNumber;
                    try {
                        orderConfirmMenuNumber = Screen.orderMenuScreen(order);
                    } catch (IllegalArgumentException e) {
                        System.out.println(WRONG_MENU_NUMBER + "\n");
                        continue;
                    }

                    if (orderConfirmMenuNumber == CONFIRM) {
                        Screen.orderCompletedScreen();
                        ordersDB.add(order);
                        order = Order.initialOrder();
                    }

                } else {
                    // 주문 취소 화면
                    int orderCancelMenuNumber;
                    try {
                        orderCancelMenuNumber = Screen.orderCancelScreen();
                    } catch (IllegalArgumentException e) {
                        System.out.println(WRONG_MENU_NUMBER + "\n");
                        continue;
                    }

                    if (orderCancelMenuNumber == CONFIRM) {
                        Screen.orderCancelCompletedScreen();
                        order.cancelOrder();
                        ordersDB.add(order);
                        order = Order.initialOrder();
                    }
                }
            }
        }
    }


    private static boolean isItemMenuNumber(int menuNumber) {
        return menuNumber >= ITEM_MENU_START_NUM && menuNumber <= ITEM_MENU_END_NUM;
    }

    private static boolean HasOptionCategory(String categoryName) {
        return Category.BURGERS.getName().equals(categoryName) || Category.DRINKS.getName().equals(categoryName);
    }

}
