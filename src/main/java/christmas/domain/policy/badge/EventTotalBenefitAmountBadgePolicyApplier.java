package christmas.domain.policy.badge;

import christmas.domain.TotalBenefitAmount;
import christmas.domain.benefit.Badges;
import christmas.domain.policy.EventPolicyManager;

import java.util.List;

public class EventTotalBenefitAmountBadgePolicyApplier extends EventPolicyManager<EventTotalBenefitAmountBadgePolicy> {

    public EventTotalBenefitAmountBadgePolicyApplier(List<EventTotalBenefitAmountBadgePolicy> eventPolicies) {
        super(eventPolicies);
    }

    public Badges applyAll(TotalBenefitAmount totalBenefitAmount) {
        return new Badges(
                eventPolicies.stream()
                        .map((policy) -> policy.findBadges(totalBenefitAmount))
                        .toList()
        );
    }
}
