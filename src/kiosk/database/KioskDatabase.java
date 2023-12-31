package kiosk.database;

import kiosk.domain.menu.Category;
import kiosk.domain.order.Order;
import kiosk.domain.menu.item.burgers.Burgers;
import kiosk.domain.menu.item.burgers.BurgersSize;
import kiosk.domain.menu.item.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import kiosk.domain.menu.item.drinks.Drinks;
import kiosk.domain.menu.item.drinks.DrinksSize;
import kiosk.domain.orderItem.OrderItem;

public class KioskDatabase {

    public static List<Item> ItemsDB = new ArrayList<>();
    public static List<Order> ordersDB = new ArrayList<>();

    static {
        initialDatum();
    }

    static void initialDatum() {

        // Burgers
        ItemsDB.add(new Burgers
                ("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", Category.BURGERS, 6900, BurgersSize.SINGLE));
        ItemsDB.add(new Burgers
                ("ShackBurger", "토마토, 양상추, 쉑소스가 토핑된 치즈버거", Category.BURGERS, 10900, BurgersSize.DOUBLE));
        ItemsDB.add(new Burgers
                ("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", Category.BURGERS, 8900, BurgersSize.SINGLE));
        ItemsDB.add(new Burgers
                ("SmokeShack", "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거", Category.BURGERS, 12900, BurgersSize.DOUBLE));
        ItemsDB.add(new Burgers
                ("Shroom Burger", "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거", Category.BURGERS, 9400 ,BurgersSize.SINGLE));
        ItemsDB.add(new Burgers
                ("Shack Stack", "슈룸 버거와 쉑버거의 맛을 한번에 즐길 수 있는 메뉴", Category.BURGERS, 12400, BurgersSize.SINGLE));
        ItemsDB.add(new Burgers
                ("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", Category.BURGERS, 6900, BurgersSize.SINGLE));
        ItemsDB.add(new Burgers
                ("Cheeseburger", "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거", Category.BURGERS, 10900, BurgersSize.DOUBLE));
        ItemsDB.add(new Burgers
                ("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", Category.BURGERS, 5400, BurgersSize.SINGLE));
        ItemsDB.add(new Burgers
                ("Hamburger", "비프패티를 기반으로 야채가 들어간 기본버거", Category.BURGERS, 9000, BurgersSize.DOUBLE));

        // Frozen Custard
        ItemsDB.add(new Item
                ("Shakes", "바닐라, 초콜렛, 솔티드 카라멜, 블랙&화이트, 스트로베리, 피넛버터, 커피", Category.FROZEN_CUSTARD, 5900));
        ItemsDB.add(new Item
                ("Shake of the Week", "특별한 커스터드 플레이버", Category.FROZEN_CUSTARD, 6500));
        ItemsDB.add(new Item
                ("Red Bean Shake", "신선한 커스터드와 함께 우유와 레드빈이 블렌딩된 시즈널 쉐이크", Category.FROZEN_CUSTARD, 6500));
        ItemsDB.add(new Item
                ("Floats", "루트 비어, 퍼플 카우, 크림시클", Category.FROZEN_CUSTARD, 5400));

        // Drinks
        ItemsDB.add(new Drinks
                ("Shake-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", Category.DRINKS, 3900, DrinksSize.REGULAR));
        ItemsDB.add(new Drinks
                ("Shake-made Lemonade", "매장에서 직접 만드는 상큼한 레몬에이드", Category.DRINKS, 4500, DrinksSize.LARGE));
        ItemsDB.add(new Drinks
                ("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", Category.DRINKS, 3400, DrinksSize.REGULAR));
        ItemsDB.add(new Drinks
                ("Fresh Brewed Iced Tea", "직접 유기농 홍차를 우려낸 아이스티", Category.DRINKS, 3900, DrinksSize.LARGE));
        ItemsDB.add(new Drinks
                ("Fifty/Fifty", "레몬에이드와 아이스티의 만남", Category.DRINKS, 3500, DrinksSize.REGULAR));
        ItemsDB.add(new Drinks
                ("Fifty/Fifty", "레몬에이드와 아이스티의 만남", Category.DRINKS, 4400, DrinksSize.LARGE));
        ItemsDB.add(new Drinks
                ("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", Category.DRINKS, 2700, DrinksSize.REGULAR));
        ItemsDB.add(new Drinks
                ("Fountain Soda", "코카콜라, 코카콜라 제로, 스프라이트, 환타 오렌지, 환타 그레이프", Category.DRINKS, 3300, DrinksSize.LARGE));
        ItemsDB.add(new Drinks
                ("Abita Root Beer", "청량감있는 독특한 미국식 무알콜 탄산음료", Category.DRINKS, 4400, DrinksSize.REGULAR));
        ItemsDB.add(new Drinks
                ("Bottled Water", "지리산 암반대수층으로 만든 프리미엄 생수", Category.DRINKS, 1000, DrinksSize.REGULAR));

        // Beer
        ItemsDB.add(new Item
                ("ShackMeister Ale", "쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 에일 맥주", Category.BEER, 9800));
        ItemsDB.add(new Item
                ("Magpie Brewing Co.", "", Category.BEER, 6800));

    }

    public static List<Item> getItemListByCategoryNameLimit1(String categoryName) {

        List<Item> itemList = new ArrayList<>();
        for (Item DBItem : ItemsDB) {
            if (DBItem.getCategory().getName().equals(categoryName)) {
                String DBItemName = DBItem.getName();
                boolean existSameItem = false;
                for (Item item : itemList) {
                    if (item.getName().equals(DBItemName)) {
                        existSameItem = true;
                        break;
                    }
                }
                if (!existSameItem) {
                    itemList.add(DBItem);
                }
            }
        }

        return itemList;
    }

    public static List<Item> getItemListByItemName(String itemName) {

        return ItemsDB.stream()
                .filter((p) -> p.getName().equals(itemName))
                .collect(Collectors.toList());
    }

    public static int getTotalPrice() {
        return ordersDB.stream().mapToInt(Order::getTotalPrice).sum();
    }

    public static int getOrderDBSize() {
        return ordersDB.size();
    }

    public static List<OrderItem> getAllOrderItemList() {
        return ordersDB.stream()
                .flatMap(order -> order.getOrderItemList().stream())
                .collect(Collectors.toList());
    }
}
