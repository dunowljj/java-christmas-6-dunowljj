package christmas.domain.policy.discount.date;

import christmas.domain.benefit.Discount;
import christmas.domain.policy.discount.EventDiscountPolicy;

import java.time.LocalDate;

public interface EventDateDiscountPolicy extends EventDiscountPolicy<LocalDate, Discount> {

    @Override
    Discount calculateDiscount(LocalDate localDate);
}
