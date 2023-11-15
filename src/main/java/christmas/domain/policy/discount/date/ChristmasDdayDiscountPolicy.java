package christmas.domain.policy.discount.date;

import java.time.LocalDate;

import static christmas.constants.Planner23_12Config.THIS_MONTH;
import static christmas.constants.Planner23_12Config.THIS_YEAR;
import static christmas.util.DateUtils.calculateDaysBetween;

public class ChristmasDdayDiscountPolicy implements EventDateDiscountPolicy {

    public static final long NO_DISCOUNT = 0L;
    public static final int START_MONEY = 1000;
    public static final int CHRISTMAS_DAY = 25;
    public static final int DISCOUNT_PER_DAY = 100;
    private static final LocalDate EVENT_START_DATE = LocalDate.of(
            THIS_YEAR.getValue(), THIS_MONTH.getValue(), 1
    );

    @Override
    public Long calculateDiscount(LocalDate localDate) {
        if (localDate.getDayOfMonth() > CHRISTMAS_DAY) {
            return NO_DISCOUNT;
        }

        long dayDiff = calculateDaysBetween(EVENT_START_DATE, localDate);
        return START_MONEY + dayDiff * DISCOUNT_PER_DAY;
    }
}
