package christmas.domain.policy.badge;

import christmas.domain.TotalBenefitAmount;

public interface EventTotalBenefitAmountBadgePolicy extends EventBadgePolicy<TotalBenefitAmount, BadgeRank> {

    @Override
    BadgeRank findBadges(TotalBenefitAmount totalBenefitAmount);
}
