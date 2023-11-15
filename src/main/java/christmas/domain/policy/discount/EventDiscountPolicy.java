package christmas.domain.policy.discount;

import christmas.domain.policy.EventMarketingPolicy;

@FunctionalInterface
public interface EventDiscountPolicy<T, R> extends EventMarketingPolicy {

    R calculateDiscount(T t);
}
