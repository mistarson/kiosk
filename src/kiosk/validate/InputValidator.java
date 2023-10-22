package kiosk.validate;

import static kiosk.constant.Constant.*;

public class InputValidator {

    public static void validateMainMenu(int mainMenuNumber) {
        if (!(mainMenuNumber >= MENU_START_NUM && mainMenuNumber <= MENU_END_NUM)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateItemMenu(int itemMenuNumber, int itemListSize) {
        if (!(itemMenuNumber >= 1 && itemMenuNumber <= itemListSize)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateConfirmOrCancelMenuNumber(int menuNumber) {
        if (!(menuNumber == CONFIRM || menuNumber == CANCEL)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSelectOption(int selectOptionNumber, int optionsCnt) {
        if (!(selectOptionNumber >= 1 && selectOptionNumber <= optionsCnt)) {
            throw new IllegalArgumentException();
        }
    }
}
