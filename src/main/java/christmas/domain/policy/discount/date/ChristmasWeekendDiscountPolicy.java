package christmas.domain.policy.discount.date;

import java.time.LocalDate;

public class ChristmasWeekendDiscountPolicy implements EventDateDiscountPolicy {

    @Override
    public Long calculateDiscount(LocalDate localDate) {
        return null;
    }
}
