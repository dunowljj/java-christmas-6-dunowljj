package christmas.domain.policy.discount;

import christmas.domain.policy.EventPolicyManager;
import christmas.domain.policy.discount.date.EventDateAndOrderDiscountPolicy;

import java.util.List;

public class EventDateAndOrderDiscountPolicyApplier extends EventPolicyManager<EventDateAndOrderDiscountPolicy> {

    public EventDateAndOrderDiscountPolicyApplier(List<EventDateAndOrderDiscountPolicy> eventPolicies) {
        super(eventPolicies);
    }
}
