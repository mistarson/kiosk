package kiosk.constant;

import static kiosk.Category.CATEGORY_SIZE;

public class Constant {

    // 상수를 다시 대입한 상수 변수는 static final int 이어도 상수 취급 X
    public static final int ORDER_MENU_NUMBER = CATEGORY_SIZE + 1;
    public static final int ORDER_CANCEL_NUMBER = CATEGORY_SIZE + 2;
    public static final int MENU_START_NUM = 0;
    public static final int MENU_END_NUM = ORDER_CANCEL_NUMBER;
    public static final int ITEM_MENU_START_NUM = 1;
    public static final int ITEM_MENU_END_NUM = CATEGORY_SIZE;
    public static final int CONFIRM = 1;
    public static final int CANCEL = 2;
}
