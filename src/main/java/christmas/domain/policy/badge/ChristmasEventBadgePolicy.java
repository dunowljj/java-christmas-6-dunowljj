package christmas.domain.policy.badge;

import christmas.domain.TotalBenefitAmount;

import static christmas.domain.policy.badge.Badge.*;

public class ChristmasEventBadgePolicy implements EventTotalBenefitAmountBadgePolicy {

    @Override
    public Badge findBadges(TotalBenefitAmount totalBenefitAmount) {
        if (totalBenefitAmount.isMoreThan(SANTA.getThreshold())) {
            return SANTA;
        }

        if (totalBenefitAmount.isMoreThan(TREE.getThreshold())) {
            return TREE;
        }
        if (totalBenefitAmount.isMoreThan(STAR.getThreshold())) {
            return STAR;
        }

        return NONE;
    }
}
