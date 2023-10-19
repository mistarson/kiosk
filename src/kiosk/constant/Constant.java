package kiosk.constant;

import static kiosk.Category.CATEGORY_SIZE;

public class Constant {

    public static final String WRONG_MENU_NUMBER = "메뉴를 잘못 입력하셨습니다. 처음으로 돌아갑니다.";
    public static final String EMPTY_ORDER_PRODUCT = "장바구니에 담은 물건이 없습니다. 처음으로 돌아갑니다.";


    public static final int ORDER_MENU_NUMBER = CATEGORY_SIZE + 1;
    public static final int ORDER_CANCEL_NUMBER = CATEGORY_SIZE + 2;
    public static final int MENU_START_NUM = 1;
    public static final int MENU_END_NUM = ORDER_CANCEL_NUMBER;
    public static final int CONFIRM = 1;
    public static final int CANCEL = 2;
}
