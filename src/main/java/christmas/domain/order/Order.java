package christmas.domain.order;

public class Order {

    private final Menu menu;
    private final int count;

    public Order(String order) {
        String[] split = order.split("-");
        this.menu = Menu23_12.BARBECUE_RIPS;
        this.count = Integer.parseInt(split[1]);
    }
}
