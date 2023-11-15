package christmas.domain.policy.discount.date;

import java.time.LocalDate;
import java.util.List;

import static christmas.constants.Planner23_12Config.THIS_MONTH;
import static christmas.constants.Planner23_12Config.THIS_YEAR;

public class ChristmasSpecialDiscountPolicy implements EventDateDiscountPolicy{

    public static final long DISCOUNT_AMOUNT = 1000;
    public static final long NO_DISCOUNT = 0;

    public static final List<LocalDate> SPECIAL_DATES = List.of(3, 10, 17, 24, 25, 31)
            .stream()
            .map((num) -> dateOf(num))
            .toList();
    public static LocalDate dateOf(int day) {
        return LocalDate.of(THIS_YEAR.getValue(), THIS_MONTH.getValue(), day);
    }

    @Override
    public Long calculateDiscount(LocalDate localDate) {
        if (SPECIAL_DATES.contains(localDate)) {
            return DISCOUNT_AMOUNT;
        }
        return NO_DISCOUNT;
    }
}
