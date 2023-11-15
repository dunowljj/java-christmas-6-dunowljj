package christmas.domain.policy.discount.order;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventOrderDiscountPolicyManager extends EventPolicyManager<EventOrderDiscountPolicy> {
    public EventOrderDiscountPolicyManager(List<EventOrderDiscountPolicy> eventPolicies) {

        super(eventPolicies);
    }
}