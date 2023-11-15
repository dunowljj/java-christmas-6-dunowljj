package christmas.domain.policy.badge;

import christmas.domain.policy.EventMarketingPolicy;

public interface EventBadgePolicy<T, R> extends EventMarketingPolicy {

    R findBadges(T t);
}
