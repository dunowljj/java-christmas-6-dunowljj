package christmas.domain.policy.discount.date;

import christmas.domain.benefit.Discount;
import christmas.domain.order.Orders;

import java.time.LocalDate;

import static christmas.util.DateUtils.isWeekend;

public class ChristmasWeekendDiscountPolicy implements EventDateAndOrderDiscountPolicy {

    public static final String NAME = "주말 할인";
    public static final long DISCOUNT_PER_MAIN_MENU_COUNT = 2023;
    public static final long NO_DISCOUNT = 0;

    @Override
    public Discount calculateDiscount(Orders orders, LocalDate localDate) {
        if (isWeekend(localDate)) {
            return new Discount(NAME, orders.countMainMenu() * DISCOUNT_PER_MAIN_MENU_COUNT);
        }
        return new Discount(NAME, NO_DISCOUNT);
    }
}
