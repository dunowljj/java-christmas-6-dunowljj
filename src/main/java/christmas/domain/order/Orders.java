package christmas.domain.order;

import christmas.validation.StringValidator;

import java.util.Arrays;
import java.util.List;

public class Orders {
    public static final String ORDER_DELIMITER = ",";
    private final List<Order> orders;

    public Orders(String input) {
        StringValidator.that(input).shouldNotIncludeSpace();

        this.orders = Arrays.stream(input.split(ORDER_DELIMITER))
                .map(Order::new)
                .toList();
    }
}
