package kiosk.validate;

import static kiosk.constant.Constant.*;

public class InputValidator {

    public static void validateMainMenu(int mainMenuNumber) throws IllegalArgumentException {
        if (!(mainMenuNumber >= MENU_START_NUM && mainMenuNumber <= MENU_END_NUM)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateItemMenu(int itemMenuNumber, int itemListSize) throws IllegalArgumentException {
        if (!(itemMenuNumber >= 1 && itemMenuNumber <= itemListSize)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateConfirmOrCancelMenuNumber(int menuNumber) throws IllegalArgumentException {
        if (!(menuNumber == CONFIRM || menuNumber == CANCEL)) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateSelectOption(int selectOptionNumber, int optionsCnt) throws IllegalArgumentException {
        validateSelectOptionNumber(selectOptionNumber, optionsCnt);
    }

    private static void validateSelectOptionNumber(int selectOptionNumber, int optionsCnt) {
        if (!(selectOptionNumber >= 1 && selectOptionNumber <= optionsCnt)) {
            throw new IllegalArgumentException();
        }
    }
}
