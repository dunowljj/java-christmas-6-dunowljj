package christmas.domain.policy.discount;

import christmas.domain.policy.EventPolicyManager;
import christmas.domain.policy.discount.date.EventDateAndOrderDiscountPolicy;

import java.util.List;

public class EventDateAndOrderDiscountPolicyManager extends EventPolicyManager<EventDateAndOrderDiscountPolicy> {

    public EventDateAndOrderDiscountPolicyManager(List<EventDateAndOrderDiscountPolicy> eventPolicies) {
        super(eventPolicies);
    }
}
