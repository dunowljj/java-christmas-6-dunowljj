package christmas.domain.policy.discount.date;

import java.time.LocalDate;

public class ChristmasWeekDayDiscountPolicy implements EventDateDiscountPolicy {

    @Override
    public Long calculateDiscount(LocalDate localDate) {
        return null;
    }
}
