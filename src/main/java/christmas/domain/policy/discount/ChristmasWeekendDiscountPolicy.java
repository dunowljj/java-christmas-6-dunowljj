package christmas.domain.policy.discount;

import java.time.LocalDate;

public class ChristmasWeekendDiscountPolicy implements EventDateDiscountPolicy {

    @Override
    public long calculateDiscount(LocalDate localDate) {
        return 0;
    }
}
