package christmas.domain.order;

import christmas.domain.TotalOrderAmount;
import christmas.validation.CollectionValidator;
import christmas.validation.StringValidator;

import java.util.Arrays;
import java.util.List;

public class Orders {
    public static final String ORDER_DELIMITER = ",";
    private final List<Order> orders;

    public Orders(String input) {
        StringValidator.that(input)
                .shouldNotBlank()
                .shouldNotIncludeSpace()
                .shouldNotStartWith(ORDER_DELIMITER)
                .shouldNotEndWith(ORDER_DELIMITER);

        List<Order> orders = Arrays.stream(input.split(ORDER_DELIMITER))
                .map(Order::new)
                .toList();

        CollectionValidator.that(orders).shouldNotHasDuplicatedElement();
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public TotalOrderAmount makeTotal() {
        Long sum = orders.stream()
                .map(Order::calculateOrderAmount)
                .reduce(Long::sum)
                .orElse(0L);

        return new TotalOrderAmount(sum);
    }

    public long countDessert() {
        return orders.stream()
                .filter((order -> order.isDessert()))
                .mapToLong(order -> order.getCount())
                .reduce(Long::sum)
                .orElse(0L);
    }

    public long countMainMenu() {
        return orders.stream()
                .filter((order -> order.isMainMenu()))
                .mapToLong(order -> order.getCount())
                .reduce(Long::sum)
                .orElse(0L);
    }
}
