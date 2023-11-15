package christmas.domain.policy.present;

import christmas.domain.policy.EventMarketingPolicy;

@FunctionalInterface
public interface EventPresentPolicy<T, R> extends EventMarketingPolicy {

    R findPresents(T t);
}
