package christmas.domain.policy.badge;

import christmas.domain.TotalBenefitAmount;
import christmas.domain.benefit.Badges;
import christmas.domain.policy.EventMarketingPolicy;

public interface EventBadgePolicy extends EventMarketingPolicy {

    Badges findBadges(TotalBenefitAmount totalBenefitAmount);
}
