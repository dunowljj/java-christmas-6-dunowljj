package christmas.domain.order;

public class Order {

    public static final String MENU_AND_COUNT_SPLITTER = "-";
    private final Menu menu;
    private final MenuCount count;

    public Order(String order) {
        String[] split = order.split(MENU_AND_COUNT_SPLITTER);

        this.menu =  Menu.findMenuBy(split[0]);
        this.count = new MenuCount(split[1]);
    }
}
