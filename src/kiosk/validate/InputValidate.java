package kiosk.validate;

import kiosk.KioskDatabase;

import static kiosk.constant.Constant.*;

public class InputValidate {

    public static void mainMenuValidate(String menuNumberStr) throws IllegalArgumentException {

        int menuNumber = Integer.parseInt(menuNumberStr); // NumberFormatException 예상
        rightMenuNumberValidate(menuNumber);

    }

    public static void itemMenuValidate(String productMenuNumberStr, String categoryName) throws IllegalArgumentException {

        int productMenuNumber = Integer.parseInt(productMenuNumberStr);
        rightItemMenuNumberValidate(productMenuNumber, categoryName);

    }

    public static void buyMenuValidate(String buyMenuNumberStr) throws IllegalArgumentException {

        int buyMenuNumber = Integer.parseInt(buyMenuNumberStr);
        rightBuyMenuNumber(buyMenuNumber);

    }

    public static void orderConfirmMenuNumberValidate(String orderConfirmMenuNumberStr) {

        int orderConfirmMenuNumber = Integer.parseInt(orderConfirmMenuNumberStr);
        rightOrderConfirmMenuNumber(orderConfirmMenuNumber);
    }

    public static void orderCancelMenuNumberValidate(String orderCancelMenuNumberStr) {

        int orderCancelMenuNumber = Integer.parseInt(orderCancelMenuNumberStr);
        rightOrderCancelMenuNumber(orderCancelMenuNumber);
    }

    private static void rightMenuNumberValidate(int menuNumber) {
        if (!(menuNumber >= MENU_START_NUM && menuNumber <= MENU_END_NUM)) {
            throw new IllegalArgumentException();
        }
    }

    private static void rightItemMenuNumberValidate(int productMenuNumber, String categoryName) {
        int productListSize = KioskDatabase.getItemListSizeByCategory(categoryName);

        if (!(productMenuNumber >= 1 && productMenuNumber <= productListSize)) {
            throw new IllegalArgumentException();
        }

    }

    private static void rightBuyMenuNumber(int buyMenuNumber) {
        if (!(buyMenuNumber == CONFIRM || buyMenuNumber == CANCEL)) {
            throw new IllegalArgumentException();
        }

    }

    private static void rightOrderConfirmMenuNumber(int orderConfirmMenuNumber) {
        if (!(orderConfirmMenuNumber == CONFIRM || orderConfirmMenuNumber == CANCEL)) {
            throw new IllegalArgumentException();
        }
    }

    private static void rightOrderCancelMenuNumber(int orderCancelMenuNumber) {
        if (!(orderCancelMenuNumber == CONFIRM || orderCancelMenuNumber == CANCEL)) {
            throw new IllegalArgumentException();
        }
    }

}
