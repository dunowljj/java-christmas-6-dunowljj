package christmas.domain.policy.badge;

import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalBenefitAmountBadgePolicyApplier extends EventPolicyManager<EventTotalBenefitAmountBadgePolicy> {

    public EventTotalBenefitAmountBadgePolicyApplier(List<EventTotalBenefitAmountBadgePolicy> eventPolicies) {
        super(eventPolicies);
    }
}
