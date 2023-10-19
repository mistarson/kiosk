package kiosk;

import kiosk.validate.InputValidate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static kiosk.Category.CATEGORY_SIZE;
import static kiosk.Category.getCategoryNameByMenuNumber;
import static kiosk.constant.Constant.*;
import static kiosk.KioskDatabase.getItemByItemMenuNumber;
import static kiosk.KioskDatabase.ordersDB;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Order order = Order.initialOrder();


        while (true) {
            // 메인 메뉴 화면
            Screen.mainMenuScreen();

            String menuNumberStr = br.readLine();

            // TODO try-catch 중복 코드 해결하기
            try {
                InputValidate.mainMenuValidate(menuNumberStr);
            } catch (IllegalArgumentException e) {
                System.out.println(WRONG_MENU_NUMBER + "\n");
                continue;
            }

            int menuNumber = Integer.parseInt(menuNumberStr);
            if (isProductMenuNumber(menuNumber)) {
                String categoryName = getCategoryNameByMenuNumber(menuNumber);

                // 상품 메뉴 화면
                Screen.itemMenuScreen(categoryName);

                String itemMenuNumberStr = br.readLine();
                try {
                    InputValidate.itemMenuValidate(itemMenuNumberStr, categoryName);
                } catch (IllegalArgumentException e) {
                    System.out.println(WRONG_MENU_NUMBER + "\n");
                    continue;
                }

                int itemMenuNumber = Integer.parseInt(itemMenuNumberStr);
                Item product = getItemByItemMenuNumber(itemMenuNumber, categoryName);

                // 구매 화면
                Screen.buyMenuScreen(product);

                String buyMenuNumberStr = br.readLine();
                try {
                    InputValidate.buyMenuValidate(buyMenuNumberStr);
                } catch (IllegalArgumentException e) {
                    System.out.println(WRONG_MENU_NUMBER + "\n");
                    continue;
                }

                int buyMenuNumber = Integer.parseInt(buyMenuNumberStr);
                if (buyMenuNumber == CONFIRM) {
                    order.addOrderItem(product);

                    Screen.buyCompletedScreen(product.getName());
                }
            }

            // 주문 관련 메뉴
            else {
                if (menuNumber == ORDER_MENU_NUMBER) {

                    if (order.isOrderItemListEmpty()) {
                        System.out.println(EMPTY_ORDER_PRODUCT + "\n");
                        continue;
                    }

                    // 주문 화면
                    Screen.orderMenuScreen(order);

                    String orderConfirmMenuNumberStr = br.readLine();
                    try {
                        InputValidate.orderConfirmMenuNumberValidate(orderConfirmMenuNumberStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println(WRONG_MENU_NUMBER + "\n");
                        continue;
                    }

                    int orderConfirmMenuNumber = Integer.parseInt(orderConfirmMenuNumberStr);
                    if (orderConfirmMenuNumber == CONFIRM) {
                        Screen.orderCompletedScreen();
                        ordersDB.add(order);
                        order = Order.initialOrder();
                    }

                } else {
                    // 주문 취소 화면
                    // TODO 별도 취소, 전체 취소 구현하기
                    Screen.orderCancelScreen();

                    String orderCancelMenuNumberStr = br.readLine();
                    try {
                        InputValidate.orderCancelMenuNumberValidate(orderCancelMenuNumberStr);
                    } catch (IllegalArgumentException e) {
                        System.out.println(WRONG_MENU_NUMBER + "\n");
                        continue;
                    }

                    int orderCancelMenuNumber = Integer.parseInt(orderCancelMenuNumberStr);
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


    private static boolean isProductMenuNumber(int menuNumber) {
        return menuNumber >= MENU_START_NUM && menuNumber <= CATEGORY_SIZE;
    }

}
