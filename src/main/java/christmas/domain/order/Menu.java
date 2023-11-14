package christmas.domain.order;

import christmas.constants.KindOfMenu;

public interface Menu {

    String getName();

    int getNumericPrice();

    String getPrice();

    KindOfMenu getKindOfMenu();
}
