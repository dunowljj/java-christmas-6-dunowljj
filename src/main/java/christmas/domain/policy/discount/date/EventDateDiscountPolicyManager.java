package christmas.domain.policy.discount.date;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventDateDiscountPolicyManager extends EventPolicyManager<EventDateDiscountPolicy> {

    public EventDateDiscountPolicyManager(List<EventDateDiscountPolicy> eventPolicies) {
        super(eventPolicies);
    }
}