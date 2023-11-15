package christmas.domain.policy.discount;

import christmas.domain.policy.EventMarketingPolicy;

import java.time.LocalDate;

public interface EventDateDiscountPolicy extends EventMarketingPolicy {

    long calculateDiscount(LocalDate localDate);
}
