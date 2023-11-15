package christmas.domain.policy.discount.date;

import christmas.domain.policy.discount.EventDiscountPolicy;

import java.time.LocalDate;

@FunctionalInterface
public interface EventDateDiscountPolicy extends EventDiscountPolicy<LocalDate, Long> {

    @Override
    Long calculateDiscount(LocalDate localDate);
}
