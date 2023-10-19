package kiosk;

import java.util.List;

import static kiosk.Category.values;
import static kiosk.constant.Constant.ORDER_CANCEL_NUMBER;
import static kiosk.constant.Constant.ORDER_MENU_NUMBER;
import static kiosk.KioskDatabase.*;

public class Screen {

    public static void mainMenuScreen() {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("\n [ SHAKESHACK MENU ] ");


        for (Category category : values()) {
            System.out.println(category.getValue() + ". " + category.getName() + "\t" + category.getDescription());
        }

        System.out.println("\n[ ORDER MENU ]");
        System.out.println(ORDER_MENU_NUMBER + ". Order\t | 장바구니를 확인 후 주문합니다.");
        System.out.println(ORDER_CANCEL_NUMBER + ". Cancel\t | 진행중인 주문을 취소합니다.");
    }

    public static void itemMenuScreen(String categoryName) {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println("\n[ " + categoryName + " MENU ]");


        List<Item> productList = getItemListByCategory(categoryName);
        int idx = 1;
        for (Item product : productList) {
            System.out.println(idx++ + ". " + product.getName() + "\t" + product.getPrice() + "\t" + product.getDescription());
        }
    }

    public static void buyCompletedScreen(String productName) {
        System.out.println(productName + " 가 장바구니에 추가되었습니다.\n");
    }

    public static void orderMenuScreen(Order order) {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");

        List<Item> orderProductList = order.getOrderItemList();
        System.out.println("[ Orders ]\n");
        for (Item product : orderProductList) {
            System.out.println(product.getName() + "\t | W " + product.getPrice() + " |\t" + product.getDescription());
        }
        System.out.println("[ Total ]");
        System.out.println("W " + order.getTotalPrice() + "\n");
        System.out.println("1. 주문 \t 2. 메뉴판 ");
    }

    public static void buyMenuScreen(Item product) {
        System.out.println(product.getName() + "\t| W " + product.getPrice() + " | " + product.getDescription());
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");
    }

    public static void orderCompletedScreen() {
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + ordersDB.size() + 1 + " ] 번 입니다.");
    }

    public static void orderCancelScreen() {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");
    }

    public static void orderCancelCompletedScreen() {
        System.out.println("주문이 취소되었습니다.\n");
    }
}
