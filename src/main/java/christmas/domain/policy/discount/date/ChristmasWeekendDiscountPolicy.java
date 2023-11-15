package christmas.domain.policy.discount.date;

import christmas.domain.order.Orders;

import java.time.LocalDate;

import static christmas.util.dateUtils.isWeekend;

public class ChristmasWeekendDiscountPolicy implements EventDateAndOrderDiscountPolicy {

    public static final long DISCOUNT_PER_MAIN_MENU_COUNT = 2023;
    public static final long NO_DISCOUNT = 0;

    @Override
    public Long calculateDiscount(Orders orders, LocalDate localDate) {
        if (isWeekend(localDate)) {
            return orders.countMainMenu() * DISCOUNT_PER_MAIN_MENU_COUNT;
        }
        return NO_DISCOUNT;
    }
}
