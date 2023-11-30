package christmas.domain.policy.discount.date;

import christmas.domain.benefit.Discount;
import christmas.domain.order.Orders;

import java.time.LocalDate;

import static christmas.util.DateUtils.isWeekday;

public class ChristmasWeekDayDiscountPolicy implements EventDateAndOrderDiscountPolicy {

    public static final String NAME = "평일 할인";
    public static final long DISCOUNT_PER_DESSERT_COUNT = 2023;
    public static final long NO_DISCOUNT = 0;

    @Override
    public Discount calculateDiscount(Orders orders, LocalDate localDate) {
        if (isWeekday(localDate)) {
            return new Discount(NAME, orders.countDessert() * DISCOUNT_PER_DESSERT_COUNT);
        }
        return new Discount(NAME, NO_DISCOUNT);
    }
}
