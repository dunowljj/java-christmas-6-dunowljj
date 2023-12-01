package christmas.domain.policy.badge;

import christmas.domain.TotalBenefitAmount;

public interface EventTotalBenefitAmountBadgePolicy extends EventBadgePolicy<TotalBenefitAmount, Badge> {

    @Override
    Badge findBadges(TotalBenefitAmount totalBenefitAmount);
}
