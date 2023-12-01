package christmas.domain.policy.present;

import christmas.domain.policy.EventMarketingPolicy;

@FunctionalInterface
public interface EventPresentPolicy<T, R> extends EventMarketingPolicy {

    public static final String NAME = "증정 이벤트";

    R findPresents(T t);
}
