package kiosk.validate;

import static kiosk.constant.Constant.*;

public class InputValidate {

    public static void mainMenuValidate(int mainMenuNumber) throws IllegalArgumentException {
        if (!(mainMenuNumber >= MENU_START_NUM && mainMenuNumber <= MENU_END_NUM)) {
            throw new IllegalArgumentException();
        }
    }

    public static void itemMenuValidate(int itemMenuNumber, int itemListSize) throws IllegalArgumentException {
        if (!(itemMenuNumber >= 1 && itemMenuNumber <= itemListSize)) {
            throw new IllegalArgumentException();
        }
    }

    public static void confirmOrCancelMenuNumberValidate(int menuNumber) throws IllegalArgumentException {
        if (!(menuNumber == CONFIRM || menuNumber == CANCEL)) {
            throw new IllegalArgumentException();
        }
    }

    public static void selectOptionValidate(int selectOptionNumber, String categoryName, int optionsCnt) throws IllegalArgumentException {

        switch (categoryName) {
            case "Burgers" -> BurgersSelectOptionNumberValidate(selectOptionNumber, optionsCnt);

            case "Drinks" -> DrinksSelectOptionNumberValidate(selectOptionNumber, optionsCnt);

            default -> throw new IllegalArgumentException();
        }
    }

    private static void BurgersSelectOptionNumberValidate(int selectOptionNumber, int optionsCnt) {
        if (!(selectOptionNumber >= 1 && selectOptionNumber <= optionsCnt)) {
            throw new IllegalArgumentException();
        }
    }

    private static void DrinksSelectOptionNumberValidate(int selectOptionNumber, int optionsCnt) {
        if (!(selectOptionNumber >= 1 && selectOptionNumber <= optionsCnt)) {
            throw new IllegalArgumentException();
        }
    }
}
