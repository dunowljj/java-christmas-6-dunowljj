package christmas.domain.policy.discount.order;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventOrderDiscountPolicyApplier extends EventPolicyManager<EventOrderDiscountPolicy> {
    public EventOrderDiscountPolicyApplier(List<EventOrderDiscountPolicy> eventPolicies) {

        super(eventPolicies);
    }
}