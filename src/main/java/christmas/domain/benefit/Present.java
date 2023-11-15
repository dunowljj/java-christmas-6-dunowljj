package christmas.domain.benefit;

import christmas.domain.order.Menu;
import christmas.domain.order.MenuCount;

public class Present {

    private final Menu menu;
    private final MenuCount menuCount;

    public Present(Menu menu, int count) {
        this.menu = menu;
        this.menuCount = new MenuCount(count);
    }

    @Override
    public String toString() {
        return String.format("%s %s개", menu.getName(), menuCount);
    }
}
