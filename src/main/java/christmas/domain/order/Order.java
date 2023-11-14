package christmas.domain.order;

import christmas.validation.IntValidator;

import java.util.Objects;

public class Order {

    public static final String MENU_AND_COUNT_SPLITTER = "-";
    private static final int ORDER_SPLIT_COUNT = 2;
    private final Menu menu;
    private final MenuCount count;

    public Order(String order) {
        String[] split = order.split(MENU_AND_COUNT_SPLITTER);
        IntValidator.that(split.length).shouldSameWith(ORDER_SPLIT_COUNT);

        this.menu =  Menu.findMenuBy(split[0]);
        this.count = new MenuCount(split[1]);
    }

    public String getMenuName() {
        return menu.getName();
    }

    public int getCount() {
        return count.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order order)) return false;

        return Objects.equals(menu, order.menu);
    }

    @Override
    public int hashCode() {
        if (menu != null) {
            return menu.hashCode();
        }
        return 0;
    }

    public long calculateOrderAmount() {
         return count.multiple(menu.getNumericPrice());
    }
}
