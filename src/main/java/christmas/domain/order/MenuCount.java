package christmas.domain.order;

import christmas.validation.IntValidator;
import christmas.validation.StringValidator;

public class MenuCount {

    public static final int MENU_MIN_COUNT = 1;
    public static final int MENU_MAX_COUNT = 50_000;
    private final int count;

    public MenuCount(String menuCount) {
        StringValidator.that(menuCount).shouldBeNumberFormat();
        int count = Integer.parseInt(menuCount);
        IntValidator.that(count).shouldInRange(MENU_MIN_COUNT, MENU_MAX_COUNT);

        this.count = count;
    }
}
