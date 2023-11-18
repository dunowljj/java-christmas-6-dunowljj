package christmas.domain.policy.discount.date;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventDateDiscountPolicyApplier extends EventPolicyManager<EventDateDiscountPolicy> {

    public EventDateDiscountPolicyApplier(List<EventDateDiscountPolicy> eventPolicies) {
        super(eventPolicies);
    }
}