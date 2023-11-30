package christmas.domain.policy.discount.date;

import christmas.domain.benefit.Discount;

import java.time.LocalDate;

import static christmas.constants.Planner23_12Config.THIS_MONTH;
import static christmas.constants.Planner23_12Config.THIS_YEAR;
import static christmas.util.DateUtils.calculateDaysBetween;

public class ChristmasDdayDiscountPolicy implements EventDateDiscountPolicy {

    public final String NAME = "크리스마스 디데이 할인";
    public static final int NO_DISCOUNT = 0;
    public static final int START_MONEY = 1000;
    public static final int CHRISTMAS_DAY = 25;
    public static final int DISCOUNT_PER_DAY = 100;

    private static final LocalDate EVENT_START_DATE = LocalDate.of(
            THIS_YEAR.getValue(), THIS_MONTH.getValue(), 1
    );

    @Override
    public Discount calculateDiscount(LocalDate localDate) {
        if (localDate.getDayOfMonth() > CHRISTMAS_DAY) {
            return new Discount(NAME, NO_DISCOUNT);
        }

        long dayDiff = calculateDaysBetween(EVENT_START_DATE, localDate);
        return new Discount(NAME, START_MONEY + (dayDiff * DISCOUNT_PER_DAY));

    }
}
