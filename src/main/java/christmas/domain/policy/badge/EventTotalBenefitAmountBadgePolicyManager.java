package christmas.domain.policy.badge;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalBenefitAmountBadgePolicyManager extends EventPolicyManager<EventTotalBenefitAmountBadgePolicy> {

    public EventTotalBenefitAmountBadgePolicyManager(List<EventTotalBenefitAmountBadgePolicy> eventPolicies) {
        super(eventPolicies);
    }
}
