package christmas.domain.order;

import christmas.constants.KindOfMenu;

public interface Menu {

    static Menu findMenuBy(String key) {
        return MenuFinder.findMenuBy(key);
    }

    String getName();

    int getNumericPrice();

    String getPrice();

    KindOfMenu getKindOfMenu();
}
