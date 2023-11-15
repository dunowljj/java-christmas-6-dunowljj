package christmas.domain.policy.badge;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalAmountBadgePolicyManager extends EventPolicyManager<EventTotalAmountBadgePolicy> {

    public EventTotalAmountBadgePolicyManager(List<EventTotalAmountBadgePolicy> eventPolicies) {
        super(eventPolicies);
    }
}
