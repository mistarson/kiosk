package kiosk;

import kiosk.item.*;
import kiosk.validate.InputValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static kiosk.Category.values;
import static kiosk.constant.Constant.ORDER_CANCEL_NUMBER;
import static kiosk.constant.Constant.ORDER_MENU_NUMBER;
import static kiosk.database.KioskDatabase.getTotalPrice;
import static kiosk.database.KioskDatabase.ordersDB;

public class Screen {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static int mainMenuScreen() throws IOException {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println("\n [ SHAKESHACK MENU ] ");

        for (Category category : values()) {
            System.out.println(category.getValue() + ". " + category.getName() + "\t" + category.getDescription());
        }

        System.out.println("\n[ ORDER MENU ]");
        System.out.println(ORDER_MENU_NUMBER + ". Order\t | 장바구니를 확인 후 주문합니다.");
        System.out.println(ORDER_CANCEL_NUMBER + ". Cancel\t | 진행중인 주문을 취소합니다.");

        int mainMenuNumber = Integer.parseInt(br.readLine());
        InputValidator.validateMainMenu(mainMenuNumber);

        return mainMenuNumber;
    }

    public static String itemMenuScreen(String categoryName, List<Item> itemList) throws IOException {
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 상품메뉴판을 보시고 상품을 골라 입력해주세요.");
        System.out.println("\n[ " + categoryName + " MENU ]");

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.println(i + 1 + ". " + item.getName() + "\t" + item.getPrice() + "\t" + item.getDescription());
        }

        int itemMenuNumber = Integer.parseInt(br.readLine());
        InputValidator.validateItemMenu(itemMenuNumber, itemList.size());

        Item selectedItem = itemList.get(itemMenuNumber - 1);

        return selectedItem.getName();
    }

    public static void buyCompletedScreen(String itemName) {
        System.out.println(itemName + " 가 장바구니에 추가되었습니다.\n");
    }

    public static int orderMenuScreen(Order order) throws IOException {
        System.out.println("아래와 같이 주문 하시겠습니까?\n");

        List<OrderItem> orderItemList = order.getOrderItemList();
        System.out.println("[ Orders ]");
        for (OrderItem orderItem : orderItemList) {
            System.out.println(orderItem.getName() + "\t| W " + orderItem.getPrice() + "| " + orderItem.getCount() + "개 |\t" + orderItem.getDescription());
        }
        System.out.println("[ Total ]");
        System.out.println("W " + order.getTotalPrice() + "\n");
        System.out.println("1. 주문 \t 2. 메뉴판 ");

        int orderConfirmMenuNumber = Integer.parseInt(br.readLine());
        InputValidator.validateConfirmOrCancelMenuNumber(orderConfirmMenuNumber);

        return orderConfirmMenuNumber;
    }

    public static Item selectOptionMenuScreen(List<Item> itemList, String categoryName) throws IOException {
        Item firstItem = itemList.get(0);
        System.out.println(firstItem.getName() + "\t| W " + firstItem.getPrice() +
                " | " + firstItem.getDescription());
        System.out.println("위 메뉴의 어떤 옵션으로 추가하시겠습니까?");

        switch (categoryName) {
            case "Burgers" -> {
                for (Item item : itemList) {
                    Burgers burger = (Burgers) item;
                    BurgersSize burgersSize = burger.getBurgersSize();
                    System.out.print(burgersSize.getValue() + ". " + burgersSize.getName() + "(W " + burger.getPrice() + ")\t");
                }
            }
            case "Drinks" -> {
                for (Item item : itemList) {
                    Drinks drink = (Drinks) item;
                    DrinksSize drinksSize = drink.getDrinksSize();
                    System.out.print(drinksSize.getValue() + ". " + drinksSize.getName() + "(W " + drink.getPrice() + ")\t");
                }
            }
            default -> throw new IllegalArgumentException();
        }

        int selectOptionNumber = Integer.parseInt(br.readLine());
        InputValidator.validateSelectOption(selectOptionNumber, itemList.size());

        return itemList.get(selectOptionNumber - 1);
    }

    public static int buyMenuScreen(Item item) throws IOException {
        System.out.println(item.getName() + "\t| W " + item.getPrice() + " | " + item.getDescription());
        System.out.println("위 메뉴의 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");

        int buyMenuNumber = Integer.parseInt(br.readLine());
        InputValidator.validateConfirmOrCancelMenuNumber(buyMenuNumber);

        return buyMenuNumber;
    }

    public static void orderCompletedScreen() {
        System.out.println("주문이 완료되었습니다!\n");
        System.out.println("대기번호는 [ " + ordersDB.size() + 1 + " ] 번 입니다.");
    }

    public static int orderCancelScreen() throws IOException {
        System.out.println("진행하던 주문을 취소하시겠습니까?");
        System.out.println("1. 확인\t 2. 취소");

        int orderCancelMenuNumber = Integer.parseInt(br.readLine());
        InputValidator.validateConfirmOrCancelMenuNumber(orderCancelMenuNumber);

        return orderCancelMenuNumber;
    }

    public static void orderCancelCompletedScreen() {
        System.out.println("주문이 취소되었습니다.\n");
    }

    public static void totalOrderItemsScreen() throws IOException {

        int totalPrice = getTotalPrice();

        System.out.println("[ 총 판매금액 현황 ]");
        System.out.println("현재까지 총 판매된 금액은 [ W " + totalPrice + " ] 이며 판매된 상품 목록은 아래와 같습니다.\n");

        ordersDB.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .forEach(orderItem -> System.out.println("- " + orderItem.getName() + "\t W " + orderItem.getPrice()));

        System.out.println("돌아가려면 아무 키나 누르세요.");
        br.readLine();
    }
}
