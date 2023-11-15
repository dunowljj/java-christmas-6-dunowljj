package christmas.domain.policy.discount.date;

import christmas.domain.order.Orders;

import java.time.LocalDate;

import static christmas.util.dateUtils.isWeekday;

public class ChristmasWeekDayDiscountPolicy implements EventDateAndOrderDiscountPolicy {

    public static final long DISCOUNT_PER_DESSERT_COUNT = 2023;
    public static final long NO_DISCOUNT = 0;

    @Override
    public Long calculateDiscount(Orders orders, LocalDate localDate) {
        if (isWeekday(localDate)) {
            System.out.println(orders.countDessert());
            return orders.countDessert() * DISCOUNT_PER_DESSERT_COUNT;
        }
        return NO_DISCOUNT;
    }
}
