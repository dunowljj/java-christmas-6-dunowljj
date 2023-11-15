package christmas.domain.policy.discount;

import christmas.domain.policy.EventMarketingPolicy;

@FunctionalInterface
public interface EventDiscountBiPolicy<T, U, R> extends EventMarketingPolicy {

    R calculateDiscount(T t, U u);
}
